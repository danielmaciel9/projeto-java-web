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
import net.javaguides.usermanagement.model.Matricula;
import net.javaguides.usermanagement.model.Turma;

public class CursoDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_CURSOS_SQL = "INSERT INTO cursos" + "  (nome, requisito, ementa, carga_horaria, preco) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_CURSOS_BY_ID = "select nome, requisito, ementa, carga_horaria, preco from cursos where id =?";
	private static final String SELECT_ALL_CURSOS = "select * from cursos";
	private static final String DELETE_CURSOS_SQL = "delete from cursos where id = ?;";
	private static final String UPDATE_CURSOS_SQL = "update cursos set nome = ?,requisito = ?, ementa = ?, carga_horaria = ?, preco = ? where id = ?;";

	private static final String SELECT_ALUNOS_FROM_CURSO = "select alunos.nome, alunos.id, cursos.id, cursos.nome, matriculas.id, turmas.id, matriculas.nota\n" + 
			"from matriculas\n" + 
			"inner join turmas on matriculas.turmas_id = turmas.id\n" + 
			"inner join cursos on turmas.cursos_id = cursos.id\n" + 
			"inner join alunos on matriculas.alunos_id = alunos.id\n" + 
			"where cursos.id = ?;";
	
	public CursoDAO() {
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

	public void insertCurso(Curso curso) throws SQLException {
		System.out.println(INSERT_CURSOS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CURSOS_SQL)) {
			preparedStatement.setString(1, curso.getNome());
			preparedStatement.setString(2, curso.getRequisito());
			preparedStatement.setString(3, curso.getEmenta());
			preparedStatement.setInt(4, curso.getCarga_horaria());
			preparedStatement.setDouble(5, curso.getPreco());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Curso selectCurso(int id) {
		Curso curso = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CURSOS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nome = rs.getString("nome");
				String requisito = rs.getString("requisito");
				String ementa = rs.getString("ementa");
				Integer carga_horaria = rs.getInt("carga_horaria");
				Double preco = rs.getDouble("preco");
				curso = new Curso(id, nome, requisito, ementa, carga_horaria, preco);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return curso;
	}

	public List<Curso> selectAllCursos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Curso> cursos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CURSOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String requisito = rs.getString("requisito");
				String ementa = rs.getString("ementa");
				Integer carga_horaria = rs.getInt("carga_horaria");
				Double preco = rs.getDouble("preco");
				cursos.add(new Curso(id, nome, requisito, ementa, carga_horaria, preco));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cursos;
	}

	public List<Aluno> selectAlunoFromCurso(Curso curso) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Aluno> alunos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALUNOS_FROM_CURSO);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.setInt(1, curso.getId());
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String alunos_nome = rs.getString("alunos.nome");
				int alunos_id = rs.getInt("alunos.id");
				int cursos_id = rs.getInt("cursos.id");
				String cursos_nome = rs.getString("cursos.nome");
				int matriculas_id = rs.getInt("matriculas.id");
				int turmas_id = rs.getInt("turmas.id");
				Double matriculas_nota = rs.getDouble("matriculas.nota");
				alunos.add(new Aluno(alunos_id, alunos_nome, new Matricula(matriculas_id, matriculas_nota, new Turma(turmas_id, new Curso(cursos_id, cursos_nome)))));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alunos;
	}
	
	public boolean deleteCurso(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CURSOS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateCurso(Curso curso) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CURSOS_SQL);) {
			statement.setString(1, curso.getNome());
			statement.setString(2, curso.getRequisito());
			statement.setString(3, curso.getEmenta());
			statement.setInt(4, curso.getCarga_horaria());
			statement.setDouble(5, curso.getPreco());
			statement.setInt(6, curso.getId());

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