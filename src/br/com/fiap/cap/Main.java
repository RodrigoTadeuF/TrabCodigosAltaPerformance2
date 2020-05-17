package br.com.fiap.cap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int registro, opcao = 0;
		String nome, cpf;
		String [] perguntas = {"Está com tosse?", "Está com falta de ar?", "Está com febre?"};
		String [] respostas = new String [3];
		String [] leitos = new String [2];
		
		Fila atendimento = new Fila();
		Fila internacao = new Fila();
		
		atendimento.init();
		internacao.init();
		
		System.out.println("Bem vindo ao atendimento desta unidade!");
		System.out.println("Selecione uma das opeções abaixo: ");
		
		while(opcao != 4) {
			System.out.println("Digite 1 para cadastrar um paciente.");
			System.out.println("Digite 2 para atender o paciente.");
			System.out.println("Digite 3 para");
			System.out.println("Digite 4 para finalizar o dia!");	
			opcao = sc.nextInt();
			
			Paciente p = null; 
			
			switch(opcao) {
			case 1:
				p = new Paciente();
				
				System.out.println("Digite o registro: ");
				registro = sc.nextInt();
				p.setRegistro(registro);
				sc.nextLine();
				
				System.out.println("Digite o nome do paciente:");
				nome = sc.nextLine();
				p.setNome(nome);
				
				System.out.println("Digite o cpf do paciente:  ");
				cpf = sc.nextLine();
				p.setCpf(cpf);
				
				atendimento.enqueue(p);
				
				break;
				
			case 2:
				if(!atendimento.isEmpty()) {
					Paciente atendido = atendimento.dequeue();
					System.out.println("Retirado da lista: " + atendido.getNome());
		
					sc.nextLine();
					
					for (int i = 0; i< perguntas.length; i++) {
						System.out.println(perguntas[i]);
						respostas[i] = sc.nextLine().toUpperCase();
					}
					
					for (int i = 0; i < respostas.length; i++) {
						System.out.println(respostas[i]);
					}
					
					if (respostas[0].equals("SIM") && respostas[1].equals("SIM") && respostas[2].equals("SIM")) {
						for (int i = 0; i < leitos.length; i++) {
							if(leitos[i] == null) {
								leitos[i] = atendido.getCpf();
							} else {
								atendimento.enqueue(atendido);
								System.out.println("Adicionado na lista de internação.");
							}
						}
					}
					
					else if(respostas[1].equals("SIM")) {
						for (int i = 0; i < leitos.length; i++) {
							if(leitos[i] == null) {
								leitos[i] = atendido.getCpf();
							} else {
								atendimento.enqueue(atendido);
							}
						}
					}
					else {
						System.out.println("Você foi liberado, fique bem!");
					}	
					
					for (int i = 0; i < leitos.length; i++) {
						System.out.println(leitos[i]);
					}
				}
				
				
				break;
			case 3:
				//Logica liberacao internacao
				break;
			
			default:
				System.out.println("Até breve e fique bem!");
			}
		}

		
		sc.close();
	}

}
