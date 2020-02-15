package net.javaguides.usermanagement.model;

import java.util.Date;

public class Matricula {
	protected int id;
	protected int turmas_id;
	protected int alunos_id;
	protected Date data_matricula;
	protected double nota;
	protected Turma turma;
	
	public Matricula(int turmas_id, int alunos_id, Date data_matricula, double nota) {
		super();
		this.turmas_id = turmas_id;
		this.alunos_id = alunos_id;
		this.data_matricula = data_matricula;
		this.nota = nota;
	}
	public Matricula(int id, int turmas_id, int alunos_id, Date data_matricula, double nota) {
		super();
		this.id = id;
		this.turmas_id = turmas_id;
		this.alunos_id = alunos_id;
		this.data_matricula = data_matricula;
		this.nota = nota;
	}
	
	public Matricula(int id, double nota, Turma turma) {
		super();
		this.id = id;
		this.nota = nota;
		this.turma = turma;
	}
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTurmas_id() {
		return turmas_id;
	}
	public void setTurmas_id(int turmas_id) {
		this.turmas_id = turmas_id;
	}
	public int getAlunos_id() {
		return alunos_id;
	}
	public void setAlunos_id(int alunos_id) {
		this.alunos_id = alunos_id;
	}
	public Date getData_matricula() {
		return data_matricula;
	}
	public void setData_matricula(Date data_matricula) {
		this.data_matricula = data_matricula;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
