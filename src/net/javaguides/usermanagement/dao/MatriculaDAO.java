package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.javaguides.usermanagement.model.Matricula;

public class MatriculaDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_MATRICULAS_SQL = "INSERT INTO matriculas" + "  (turmas_id, alunos_id, data_matricula, nota) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_MATRICULAS_BY_ID = "select id, turmas_id, alunos_id, data_matricula, nota from matriculas where id =?";
	private static final String SELECT_ALL_MATRICULAS = "select * from matriculas";
	private static final String DELETE_MATRICULAS_SQL = "delete from matriculas where id = ?;";
	private static final String UPDATE_MATRICULAS_SQL = "update matriculas set turmas_id = ?, alunos_id = ?, data_matricula = ?, nota = ? where id = ?;";

	public MatriculaDAO() {
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

	public void insertMatricula(Matricula matricula) throws SQLException {
		System.out.println(INSERT_MATRICULAS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATRICULAS_SQL)) {
			preparedStatement.setInt(1, matricula.getTurmas_id());
			preparedStatement.setInt(2, matricula.getAlunos_id());
			preparedStatement.setDate(3, new java.sql.Date(matricula.getData_matricula().getTime()));
			preparedStatement.setDouble(4, matricula.getNota());	

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Matricula selectMatricula(int id) {
		Matricula matricula = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATRICULAS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer turmas_id = rs.getInt("turmas_id");
				Integer alunos_id = rs.getInt("alunos_id");
				Date data_matricula = rs.getDate("data_matricula");
				Double nota = rs.getDouble("nota");
				matricula = new Matricula(id, turmas_id, alunos_id, data_matricula, nota);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return matricula;
	}

	public List<Matricula> selectAllMatriculas() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Matricula> matriculas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATRICULAS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				Integer turmas_id = rs.getInt("turmas_id");
				Integer alunos_id = rs.getInt("alunos_id");
				Date data_matricula = rs.getDate("data_matricula");
				Double nota = rs.getDouble("nota");
				matriculas.add(new Matricula(id, turmas_id, alunos_id, data_matricula, nota));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return matriculas;
	}

	public boolean deleteMatricula(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_MATRICULAS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateMatricula(Matricula matricula) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MATRICULAS_SQL);) {
			statement.setInt(1, matricula.getTurmas_id());
			statement.setInt(2, matricula.getAlunos_id());
			statement.setDate(3, new java.sql.Date(matricula.getData_matricula().getTime()));
			statement.setDouble(4, matricula.getNota());	
			statement.setInt(5, matricula.getId());
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