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
import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;
import net.javaguides.usermanagement.dao.InstrutorDAO;
import net.javaguides.usermanagement.model.Instrutores;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private AdministradorDAO administradorDAO;
	private InstrutorDAO instrutorDAO;
	
	public void init() {
		userDAO = new UserDAO();
		administradorDAO = new AdministradorDAO();
		instrutorDAO = new InstrutorDAO();
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
			case "/new":
				showNewForm(request, response);
				break;
			case "/newAdmin":
				showNewAdminForm(request, response);
				break;
			case "/newInstrutor":
				showNewInstrutoresForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/insertAdmin":
				insertAdmin(request, response);
				break;
			case "/insertInstrutor":
				insertInstrutores(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/deleteAdmin":
				deleteAdmin(request, response);
				break;
			case "/deleteInstrutor":
				deleteInstrutores(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/editAdmin":
				showEditFormAdmin(request, response);
				break;
			case "/editInstrutor":
				showEditFormInstrutores(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/updateAdmin":
				updateAdmin(request, response);
				break;
			case "/updateInstrutor":
				updateInstrutores(request, response);
				break;
			case "/listAdmin":
				listAdminUser(request, response);
				break;
			case "/listInstrutores":
				listInstrutor(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name, email, country);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User book = new User(id, name, email, country);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");

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
	
}