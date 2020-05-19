package br.com.fiap.cap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println(" ----------------------------------------");
		System.out.printf("| Bem vindo ao atendimento desta unidade!|%n");
		System.out.println(" ----------------------------------------");

		Scanner sc = new Scanner(System.in);
		int registro, opcao = 0;
		String nome, cpf;
		String[] perguntas = { "Está com tosse?", "Está com falta de ar?", "Estás com febre?" };
		String[] respostas = new String[3];
		String[] leitos = new String[2];

		Fila atendimento = new Fila();
		Fila internacao = new Fila();

		atendimento.init();
		internacao.init();

		int topo = 0;

		while (opcao != 4) {
			System.out.println("");
			System.out.println(" ----------------------------------------");
			System.out.printf("|    Selecione uma das opções abaixo     |%n");
			System.out.println(" ----------------------------------------");
			System.out.println("| 1 - Cadastrar um paciente.             |");
			System.out.println("| 2 - Atender um paciente.               |");
			System.out.println("| 3 - Liberar um paciente.               |");
			System.out.println("| 4 - Finalizar o dia!                   |");
			System.out.println(" ----------------------------------------");
			System.out.println("");
			opcao = sc.nextInt();

			Paciente p = null;

			switch (opcao) {
			case 1:
				p = new Paciente();

				System.out.println("");
				System.out.println(" ----------------------------------------");
				System.out.println("|           Página de cadastro           |");
				System.out.println(" ----------------------------------------");
				System.out.printf(" Digite o nº do registro: ");
				registro = sc.nextInt();
				System.out.println(" ----------------------------------------");
				p.setRegistro(registro);
				sc.nextLine();

				System.out.printf(" Digite o nome do paciente: ");
				nome = sc.nextLine();
				p.setNome(nome);
				System.out.println(" ----------------------------------------");

				System.out.printf(" Digite o cpf do paciente: ");
				cpf = sc.nextLine();
				p.setCpf(cpf);
				System.out.println(" ----------------------------------------");

				atendimento.enqueue(p);
				break;

			case 2:
				if (!atendimento.isEmpty()) {
					Paciente atendido = atendimento.dequeue();
					System.out.println("");
					System.out.println(
							" ------------------------------------------------------------------------------------------------");
					System.out.printf("                          Paciente: " + atendido.getNome()
							+ ", retirado da lista.%n"
							+ "      Responda um pequeno questionário com 'Sim' ou 'Não' para que possamos te analisar%n");
					System.out.println(
							" ------------------------------------------------------------------------------------------------");

					sc.nextLine();

					for (int i = 0; i < perguntas.length; i++) {
						System.out.printf("  " + perguntas[i] + " ");
						respostas[i] = sc.nextLine().toUpperCase();
						System.out.println(
								" ------------------------------------------------------------------------------------------------");
					}

					if (respostas[1].equals("SIM")
							|| respostas[0].equals("SIM") && respostas[1].equals("SIM") && respostas[2].equals("SIM")) {
						for (int i = 0; i < leitos.length; i++) {
							if (topo == leitos.length) {
								internacao.enqueue(atendido);
								System.out.println("");
								System.out.println(" -----------------------------------");
								System.out.println("| Adicionado na lista de internados.|");
								System.out.println(" -----------------------------------");
								break;
							} else if (leitos[topo] == null) {
								leitos[topo] = atendido.getCpf();
								topo++;
								break;
							}
						}

						for (int i = 0; i < leitos.length; i++) {
							if (leitos[i] != null) {
								System.out.println("");
								System.out.println(" ----------------------------");
								System.out.println("|CPF do paciente no leito:   |");
								System.out.println(" ----------------------------");
								System.out.println(" " + leitos[i]);
								System.out.println(" -----------------------------");
							}else {
								System.out.println(" Leito disponível");
								System.out.println(" -----------------------------");
							}
						}
					} else {
						System.out.println("");
						System.out.println(" -------------------------------");
						System.out.println("| Você foi liberado, fique bem! |");
						System.out.println(" -------------------------------");
						System.out.println("");
					}
				} else {
					System.out.println("");
					System.out.println(" --------------------------------");
					System.out.println("| Fila de atendimento está vazia!|");
					System.out.println(" --------------------------------");
				}
				break;

			case 3:
				Paciente liberado = null;

				if (leitos[0] != null) {
					System.out.println(" --------------------------------------------------------------------");
					System.out.println("       Paciente portador do CPF: " + leitos[0] + ", pode ser liberado?     ");
					System.out.println(" --------------------------------------------------------------------");
					System.out.printf(" (Sim ou Não): ");
					sc.nextLine();
					String libera = sc.nextLine().toUpperCase();

					if (libera.equals("SIM")) {
						System.out.println("");
						System.out.println(" --------------------------------------");
						System.out.println("| Paciente " + leitos[0] + " liberado! |");
						System.out.println(" --------------------------------------");

						if (leitos[1] != null) {
							if (!internacao.isEmpty()) {
								leitos[0] = leitos[1];
								liberado = internacao.dequeue();
								leitos[1] = liberado.getCpf();
							} else {
								leitos[0] = leitos[1];
								leitos[1] = null;
							}
						} else {
							System.out.println("");
							System.out.println(" -------------------------------------------");
							System.out.println("| A fila de leitos e internação está vazia! |");
							System.out.println(" -------------------------------------------");
							System.out.println("");
							topo = 0;
							leitos[topo] = null;
						}
					}
				} else {
					System.out.println("");
					System.out.println(" -------------------------------------------");
					System.out.println("| A fila de leitos e internação está vazia! |");
					System.out.println(" -------------------------------------------");
					System.out.println("");
					topo = 0;
					leitos[topo] = null;
				}
				break;

			case 4:
				System.out.println("");
				System.out.println(" -----------------------");
				System.out.println("| Até breve e fique bem!|");
				System.out.println(" -----------------------");
				break;

			default:
				System.out.println("");
				System.out.println(" -------------------------");
				System.out.println("| Digite uma opção válida!|");
				System.out.println(" -------------------------");
			}
		}
		sc.close();
	}
}
