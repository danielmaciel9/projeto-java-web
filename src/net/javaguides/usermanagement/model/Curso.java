package net.javaguides.usermanagement.model;

public class Curso {
	protected int id;
	protected String nome;
	protected String requisito;
	protected String ementa;
	protected int carga_horaria;
	protected double preco;
	
	public Curso(String nome, String requisito, String ementa, int carga_horaria, double preco) {
		super();
		this.nome = nome;
		this.requisito = requisito;
		this.ementa = ementa;
		this.carga_horaria = carga_horaria;
		this.preco = preco;
	}

	public Curso(int id, String nome, String requisito, String ementa, int carga_horaria, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.requisito = requisito;
		this.ementa = ementa;
		this.carga_horaria = carga_horaria;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRequisito() {
		return requisito;
	}
	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public int getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
