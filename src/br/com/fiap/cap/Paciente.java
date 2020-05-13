package br.com.fiap.cap;

public class Paciente {

	private Integer registro;
	private String nome;
	private String cpf;
	
	public Paciente() {	}
	
	public Paciente(Integer registro, String nome, String cpf) {
		this.registro = registro;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	
}
