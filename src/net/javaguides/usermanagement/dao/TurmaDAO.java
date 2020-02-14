package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import net.javaguides.usermanagement.model.Turma;

public class TurmaDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_TURMAS_SQL = "INSERT INTO turmas" + "  (instrutores_id, cursos_id, data_inicio, data_final, carga_horaria) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_TURMAS_BY_ID = "select id, instrutores_id, cursos_id, data_inicio, data_final, carga_horaria from turmas where id =?";
	private static final String SELECT_ALL_TURMAS = "select * from turmas";
	private static final String DELETE_TURMAS_SQL = "delete from turmas where id = ?;";
	private static final String UPDATE_TURMAS_SQL = "update turmas set instrutores_id = ?, cursos_id = ?, data_inicio = ?, data_final = ? ,carga_horaria = ? where id = ?;";

	public TurmaDAO() {
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

	public void insertTurma(Turma turma) throws SQLException {
		System.out.println(INSERT_TURMAS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TURMAS_SQL)) {
			preparedStatement.setInt(1, turma.getInstrutores_id());
			preparedStatement.setInt(2, turma.getCursos_id());
			preparedStatement.setDate(3, new java.sql.Date(turma.getData_inicio().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(turma.getData_final().getTime()));
			preparedStatement.setInt(5, turma.getCarga_horaria());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Turma selectTurma(int id) {
		Turma turma = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TURMAS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer instrutores_id = rs.getInt("instrutores_id");
				Integer cursos_id = rs.getInt("cursos_id");
				Date data_inicio = rs.getDate("data_inicio");
				Date data_final = rs.getDate("data_final");
				Integer carga_horaria = rs.getInt("carga_horaria");
				turma = new Turma(id, instrutores_id, cursos_id, data_inicio, data_final, carga_horaria);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return turma;
	}

	public List<Turma> selectAllTurmas() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Turma> turmas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TURMAS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				Integer instrutores_id = rs.getInt("instrutores_id");
				Integer cursos_id = rs.getInt("cursos_id");
				Date data_inicio = rs.getDate("data_inicio");
				Date data_final = rs.getDate("data_final");
				Integer carga_horaria = rs.getInt("carga_horaria");
				turmas.add(new Turma(id, instrutores_id, cursos_id, data_inicio, data_final, carga_horaria));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return turmas;
	}

	public boolean deleteTurma(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TURMAS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateTurma(Turma turma) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TURMAS_SQL);) {
			statement.setInt(1, turma.getInstrutores_id());
			statement.setInt(2, turma.getCursos_id());
			statement.setDate(3, new java.sql.Date(turma.getData_inicio().getTime()));
			statement.setDate(4, new java.sql.Date(turma.getData_final().getTime()));
			statement.setInt(5, turma.getCarga_horaria());
			statement.setInt(6, turma.getId());

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