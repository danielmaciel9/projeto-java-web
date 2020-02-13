package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.AdministradorDAO;
import net.javaguides.usermanagement.model.Administrador;
import net.javaguides.usermanagement.dao.InstrutorDAO;
import net.javaguides.usermanagement.model.Instrutores;
import net.javaguides.usermanagement.dao.CursoDAO;
import net.javaguides.usermanagement.model.Curso;
import net.javaguides.usermanagement.dao.AlunoDAO;
import net.javaguides.usermanagement.model.Aluno;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministradorDAO administradorDAO;
	private InstrutorDAO instrutorDAO;
	private CursoDAO cursoDAO;
	private AlunoDAO alunoDAO;
	
	public void init() {
		administradorDAO = new AdministradorDAO();
		instrutorDAO = new InstrutorDAO();
		cursoDAO = new CursoDAO();
		alunoDAO = new AlunoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newAdmin":
				showNewAdminForm(request, response);
				break;
			case "/newInstrutor":
				showNewInstrutoresForm(request, response);
				break;
			case "/newCurso":
				showNewFormCurso(request, response);
				break;
			case "/newAluno":
				showNewFormAluno(request, response);
				break;
			case "/insertAdmin":
				insertAdmin(request, response);
				break;
			case "/insertInstrutor":
				insertInstrutores(request, response);
				break;
			case "/insertCurso":
				insertCurso(request, response);
				break;
			case "/insertAluno":
				insertAluno(request, response);
				break;
			case "/deleteAdmin":
				deleteAdmin(request, response);
				break;
			case "/deleteInstrutor":
				deleteInstrutores(request, response);
				break;
			case "/deleteCurso":
				deleteCurso(request, response);
				break;
			case "/deleteAluno":
				deleteAluno(request, response);
				break;
			case "/editAdmin":
				showEditFormAdmin(request, response);
				break;
			case "/editInstrutor":
				showEditFormInstrutores(request, response);
				break;
			case "/editCurso":
				showEditFormCurso(request, response);
				break;
			case "/editAluno":
				showEditFormAluno(request, response);
				break;
			case "/updateAdmin":
				updateAdmin(request, response);
				break;
			case "/updateInstrutor":
				updateInstrutores(request, response);
				break;
			case "/updateCurso":
				updateCurso(request, response);
				break;
			case "/updateAluno":
				updateAluno(request, response);
				break;
			case "/listAdmin":
				listAdminUser(request, response);
				break;
			case "/listInstrutores":
				listInstrutor(request, response);
				break;
			case "/listCursos":
				listCurso(request, response);
				break;
			case "/listAlunos":
				listAluno(request, response);
				break;
			default:
				listAdminUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/****************** PARTE DO SERVLET - ADMINISTRADOR ******************/
	
	private void listAdminUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Administrador> administradores = administradorDAO.selectAllAdministradores();
		request.setAttribute("listAdministrador", administradores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewAdminForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditFormAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Administrador existingUser = administradorDAO.selectAdmin(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-form.jsp");
		request.setAttribute("admin", existingUser);
		dispatcher.forward(request, response);

	}
	
	private void insertAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Administrador newAdministrador = new Administrador(nome, login, senha);
		administradorDAO.insertAdmin(newAdministrador);
		response.sendRedirect("listAdmin");
	}
	
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Administrador book = new Administrador(id, nome, login, senha);
		administradorDAO.updateAdmin(book);
		response.sendRedirect("listAdmin");
	}
	
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		administradorDAO.deleteAdmin(id);
		response.sendRedirect("listAdmin");

	}
	
	/****************** FIM DO SERVLET - ADMINISTRADOR ******************/
	
	/****************** PARTE DO SERVLET - INSTRUTORES ******************/
	
	private void listInstrutor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Instrutores> instrutores = instrutorDAO.selectAllInstrutores();
		request.setAttribute("listInstrutores", instrutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("instrutores-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewInstrutoresForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("instrutores-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormInstrutores(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Instrutores existingUser = instrutorDAO.selectInstrutor(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("instrutores-form.jsp");
		request.setAttribute("instrutores", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void insertInstrutores(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int valor_hora = Integer.parseInt(request.getParameter("valor_hora"));
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String experiencia = request.getParameter("experiencia");
		Instrutores newInstrutores = new Instrutores(nome, email, valor_hora, login, senha, experiencia);
		instrutorDAO.insertInstrutores(newInstrutores);
		response.sendRedirect("listInstrutores");
	}
	
	private void updateInstrutores(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int valor_hora = Integer.parseInt(request.getParameter("valor_hora"));
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String experiencia = request.getParameter("experiencia");

		Instrutores book = new Instrutores(id, nome, email, valor_hora, login, senha, experiencia);
		instrutorDAO.updateInstrutores(book);
		response.sendRedirect("listInstrutores");
	}
	
	private void deleteInstrutores(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		instrutorDAO.deleteInstrutores(id);
		response.sendRedirect("listInstrutores");

	}
	
	/****************** FIM DO SERVLET - INSTRUTORES ******************/
	
	/****************** PARTE DO SERVLET - CURSO ******************/
	
	private void listCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Curso> listCurso = cursoDAO.selectAllCursos();
		request.setAttribute("listCurso", listCurso);
		RequestDispatcher dispatcher = request.getRequestDispatcher("curso-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("curso-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormCurso(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Curso existingUser = cursoDAO.selectCurso(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("curso-form.jsp");
		request.setAttribute("curso", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertCurso(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String requisito = request.getParameter("requisito");
		String ementa = request.getParameter("ementa");
		int carga_horaria = Integer.parseInt(request.getParameter("carga_horaria"));
		Double preco = Double.parseDouble(request.getParameter("preco"));
		Curso newCurso = new Curso(nome, requisito, ementa, carga_horaria, preco);
		cursoDAO.insertCurso(newCurso);
		response.sendRedirect("listCursos");
	}

	private void updateCurso(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String requisito = request.getParameter("requisito");
		String ementa = request.getParameter("ementa");
		int carga_horaria = Integer.parseInt(request.getParameter("carga_horaria"));
		Double preco = Double.parseDouble(request.getParameter("preco"));

		Curso book = new Curso(id, nome, requisito, ementa, carga_horaria, preco);
		cursoDAO.updateCurso(book);
		response.sendRedirect("listCursos");
	}
	
	private void deleteCurso(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cursoDAO.deleteCurso(id);
		response.sendRedirect("listCursos");

	}
	
	/****************** FIM DO SERVLET - CURSO ******************/
	
	/****************** PARTE DO SERVLET - ALUNO ******************/
	
	private void listAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Aluno> listAluno = alunoDAO.selectAllAlunos();
		request.setAttribute("listAluno", listAluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Aluno existingUser = alunoDAO.selectAluno(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("aluno-form.jsp");
		request.setAttribute("aluno", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertAluno(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String comentario = request.getParameter("comentario");
		Boolean aprovado = Boolean.parseBoolean(request.getParameter("aprovado"));
		Aluno newAluno = new Aluno(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
		alunoDAO.insertAluno(newAluno);
		response.sendRedirect("listAlunos");
	}

	private void updateAluno(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String comentario = request.getParameter("comentario");
		Boolean aprovado = Boolean.parseBoolean(request.getParameter("aprovado"));

		Aluno book = new Aluno(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
		alunoDAO.updateAluno(book);
		response.sendRedirect("listAlunos");
	}

	private void deleteAluno(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		alunoDAO.deleteAluno(id);
		response.sendRedirect("listAlunos");
	}
	
	/****************** FIM DO SERVLET - ALUNO ******************/
	
}