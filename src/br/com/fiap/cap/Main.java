package br.com.fiap.cap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("Bem vindo ao atendimento desta unidade!");
		System.out.println("Selecione uma das ope��es abaixo: ");
		
		while(opcao != 4) {
			System.out.println("Digite 1 para cadastrar um paciente.");
			System.out.println("Digite 2 para ");
			System.out.println("Digite 3 para");
			System.out.println("Digite 4 para finalizar o dia!");	
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			
			default:
				System.out.println("At� breve e fique bem!");
			}
		}
		
		Paciente p1 = new Paciente(1, "Rodrigo Tadeu", "39055568805");
		Fila fila = new Fila();
		
		fila.init();
		fila.enqueue(p1);
		

	}

}
