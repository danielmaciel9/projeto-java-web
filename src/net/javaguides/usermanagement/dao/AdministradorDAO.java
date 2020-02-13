package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Administrador;

public class AdministradorDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_ADMINISTRADOR_SQL = "INSERT INTO administrador" + "  (nome, login, senha) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_ADMINISTRADOR_BY_ID = "select id,nome,login,senha from administrador where id =?";
	private static final String SELECT_ALL_ADMINISTRADOR = "select * from administrador";
	private static final String DELETE_ADMINISTRADOR_SQL = "delete from administrador where id = ?;";
	private static final String UPDATE_ADMINISTRADOR_SQL = "update administrador set nome = ?,login= ?, senha =? where id = ?;";

	public AdministradorDAO() {
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

	public void insertAdmin(Administrador administrador) throws SQLException {
		System.out.println(INSERT_ADMINISTRADOR_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMINISTRADOR_SQL)) {
			preparedStatement.setString(1, administrador.getNome());
			preparedStatement.setString(2, administrador.getLogin());
			preparedStatement.setString(3, administrador.getSenha());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Administrador selectAdmin(int id) {
		Administrador administrador = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMINISTRADOR_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				administrador = new Administrador(id, nome, login, senha);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return administrador;
	}

	public List<Administrador> selectAllAdministradores() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Administrador> administradores = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINISTRADOR);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				administradores.add(new Administrador(id, nome, login, senha));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return administradores;
	}

	public boolean deleteAdmin(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ADMINISTRADOR_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateAdmin(Administrador administrador) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ADMINISTRADOR_SQL);) {
			statement.setString(1, administrador.getNome());
			statement.setString(2, administrador.getLogin());
			statement.setString(3, administrador.getSenha());
			statement.setInt(4, administrador.getId());

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