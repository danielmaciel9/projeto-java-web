package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Aluno;
import net.javaguides.usermanagement.model.Curso;
import net.javaguides.usermanagement.model.Instrutores;
import net.javaguides.usermanagement.model.Matricula;
import net.javaguides.usermanagement.model.Turma;

public class InstrutorDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_INSTRUTORES_SQL = "INSERT INTO instrutores" + "  (nome, email, valor_hora, login, senha, experiencia) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_INSTRUTORES_BY_ID = "select id,nome, email, valor_hora, login, senha, experiencia from instrutores where id =?";
	private static final String SELECT_ALL_INSTRUTORES = "select * from instrutores";
	private static final String DELETE_INSTRUTORES_SQL = "delete from instrutores where id = ?;";
	private static final String UPDATE_INSTRUTORES_SQL = "update instrutores set nome = ?, email = ?, valor_hora = ?, login = ?, senha = ?, experiencia = ? where id = ?;";

	private static final String SELECT_INSTRUTORES_EXTRATO_CURSO = "select instrutores.nome, instrutores.id, cursos.nome, cursos.id, turmas.id, cursos.carga_horaria, cursos.preco\n" + 
			"	from instrutores\n" + 
			"	inner join turmas on turmas.instrutores_id = instrutores.id\n" + 
			"	inner join cursos on turmas.cursos_id = cursos.id\n" + 
			"	where instrutores.id = ?;";
	
	public InstrutorDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertInstrutores(Instrutores instrutor) throws SQLException {
		System.out.println(INSERT_INSTRUTORES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INSTRUTORES_SQL)) {
			preparedStatement.setString(1, instrutor.getNome());
			preparedStatement.setString(2, instrutor.getEmail());
			preparedStatement.setInt(3, instrutor.getValor_hora());
			preparedStatement.setString(4, instrutor.getLogin());
			preparedStatement.setString(5, instrutor.getSenha());
			preparedStatement.setString(6, instrutor.getExperiencia());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Instrutores selectInstrutor(int id) {
		Instrutores instrutores = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INSTRUTORES_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				Integer valor_hora = rs.getInt("valor_hora");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String experiencia = rs.getString("experiencia");
				instrutores = new Instrutores(id, nome, email, valor_hora, login, senha, experiencia);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return instrutores;
	}

	public List<Instrutores> selectAllInstrutores() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Instrutores> instrutores = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INSTRUTORES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				Integer valor_hora = rs.getInt("valor_hora");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String experiencia = rs.getString("experiencia");
				instrutores.add(new Instrutores(id, nome, email, valor_hora, login, senha, experiencia));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return instrutores;
	}

	
	public List<Turma> selectInstrutoresFromCursoValor(Turma turma) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Turma> turmas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INSTRUTORES_EXTRATO_CURSO);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.setInt(1, turma.getId());
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int turma_id = rs.getInt("turmas.id");
				int curso_id = rs.getInt("cursos.id");
				String curso_nome = rs.getString("cursos.nome");
				int curso_carga_horaria = rs.getInt("cursos.carga_horaria");
				String instrutores_nome = rs.getString("instrutores.nome");
				int instrutores_id = rs.getInt("instrutores.id");
				Double curso_preco = rs.getDouble("cursos.preco");
				
				turmas.add(new Turma(turma_id, new Curso(curso_id, curso_nome, curso_carga_horaria, curso_preco), new Instrutores(instrutores_id, instrutores_nome)));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return turmas;
	}
	
	
	public boolean deleteInstrutores(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_INSTRUTORES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateInstrutores(Instrutores instrutor) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_INSTRUTORES_SQL);) {
			statement.setString(1, instrutor.getNome());
			statement.setString(2, instrutor.getEmail());
			statement.setInt(3, instrutor.getValor_hora());
			statement.setString(4, instrutor.getLogin());
			statement.setString(5, instrutor.getSenha());
			statement.setString(6, instrutor.getExperiencia());
			statement.setInt(7, instrutor.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}