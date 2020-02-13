package net.javaguides.usermanagement.model;

public class Aluno {
	protected int id;
	protected String cpf;
	protected String nome;
	protected String email;
	protected String celular;
	protected String login;
	protected String senha;
	protected String endereco;
	protected String cidade;
	protected String bairro;
	protected String cep;
	protected String comentario;
	protected Boolean aprovado;
	
	public Aluno(String cpf, String nome, String email, String celular, String login, String senha,
			String endereco, String cidade, String bairro, String cep, String comentario, Boolean aprovado) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.comentario = comentario;
		this.aprovado = aprovado;
	}
	
	public Aluno(int id, String cpf, String nome, String email, String celular, String login, String senha,
			String endereco, String cidade, String bairro, String cep, String comentario, Boolean aprovado) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.comentario = comentario;
		this.aprovado = aprovado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Boolean getAprovado() {
		return aprovado;
	}
	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	
}

