package br.com.fiap.cap;

public class Fila {
	
	private class Node {
		
		Paciente patient;
		Node next;
	}
	
	private Node start;
	private Node end;
	
	public void init() {
		start = end = null;
	}
	
	public boolean isEmpty() {
		if(start == null && end == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void enqueue (Paciente p) {
		Node newNode = new Node();
		newNode.patient = p;
		newNode.next = null;
		if(isEmpty()) {
			start = newNode;
		} else {
			end.next = newNode;
		}
		end = newNode;
	}
	
	

}
