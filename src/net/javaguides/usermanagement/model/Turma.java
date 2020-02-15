package net.javaguides.usermanagement.model;

import java.util.Date;

public class Turma {
	protected int id;
	protected int instrutores_id;
	protected int cursos_id;
	protected Date data_inicio;
	protected Date data_final;
	protected int carga_horaria;
	protected Curso curso;
	
	public Turma(int instrutores_id, int cursos_id, Date data_inicio, Date data_final, int carga_horaria) {
		super();
		this.instrutores_id = instrutores_id;
		this.cursos_id = cursos_id;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
		this.carga_horaria = carga_horaria;
	}
	
	public Turma(int id, int instrutores_id, int cursos_id, Date data_inicio, Date data_final, int carga_horaria) {
		super();
		this.id = id;
		this.instrutores_id = instrutores_id;
		this.cursos_id = cursos_id;
		this.data_inicio = data_inicio;
		this.data_final = data_final;
		this.carga_horaria = carga_horaria;
	}
	
	public Turma(int id, Curso curso) {
		super();
		this.id = id;
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInstrutores_id() {
		return instrutores_id;
	}
	public void setInstrutores_id(int instrutores_id) {
		this.instrutores_id = instrutores_id;
	}
	public int getCursos_id() {
		return cursos_id;
	}
	public void setCursos_id(int cursos_id) {
		this.cursos_id = cursos_id;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public int getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
	
}
