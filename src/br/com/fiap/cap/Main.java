package br.com.fiap.cap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		Fila fila = new Fila();
		fila.init();
		
		System.out.println("Bem vindo ao atendimento desta unidade!");
		System.out.println("Selecione uma das opeções abaixo: ");
		
		while(opcao != 4) {
			System.out.println("Digite 1 para cadastrar um paciente.");
			System.out.println("Digite 2 para ");
			System.out.println("Digite 3 para");
			System.out.println("Digite 4 para finalizar o dia!");	
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:
				Paciente p = new Paciente();
				// Logica para preencher os dados do paciente
				fila.enqueue(p);
				break;
			case 2:
				// Dequeue
				// Logica das perguntas e encaminhamento
				// Logica internacao
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
