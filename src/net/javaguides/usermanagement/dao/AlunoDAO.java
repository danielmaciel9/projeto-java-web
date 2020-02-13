package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Aluno;

public class AlunoDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_ALUNOS_SQL = "INSERT INTO alunos" + "  (cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_ALUNOS_BY_ID = "select cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado from alunos where id =?";
	private static final String SELECT_ALL_ALUNOS = "select * from alunos";
	private static final String DELETE_ALUNOS_SQL = "delete from alunos where id = ?;";
	private static final String UPDATE_ALUNOS_SQL = "update alunos set cpf = ?,nome = ?, email = ?, celular = ?, login = ?, senha = ?, endereco = ?, cidade = ?, bairro = ?, cep = ?, comentario = ?, aprovado = ? where id = ?;";

	public AlunoDAO() {
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

	public void insertAluno(Aluno aluno) throws SQLException {
		System.out.println(INSERT_ALUNOS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ALUNOS_SQL)) {
			preparedStatement.setString(1, aluno.getCpf());
			preparedStatement.setString(2, aluno.getNome());
			preparedStatement.setString(3, aluno.getEmail());
			preparedStatement.setString(4, aluno.getCelular());
			preparedStatement.setString(5, aluno.getLogin());
			preparedStatement.setString(6, aluno.getSenha());
			preparedStatement.setString(7, aluno.getEndereco());
			preparedStatement.setString(8, aluno.getCidade());
			preparedStatement.setString(9, aluno.getBairro());
			preparedStatement.setString(10, aluno.getCep());
			preparedStatement.setString(11, aluno.getComentario());
			preparedStatement.setBoolean(12, aluno.getAprovado());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Aluno selectAluno(int id) {
		Aluno aluno = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALUNOS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String celular = rs.getString("celular");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String cep = rs.getString("cep");
				String comentario = rs.getString("comentario");
				Boolean aprovado = rs.getBoolean("aprovado");
				aluno = new Aluno(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return aluno;
	}

	public List<Aluno> selectAllAlunos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Aluno> alunos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ALUNOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String celular = rs.getString("celular");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String cep = rs.getString("cep");
				String comentario = rs.getString("comentario");
				Boolean aprovado = rs.getBoolean("aprovado");
				alunos.add(new Aluno(id, cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alunos;
	}

	public boolean deleteAluno(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ALUNOS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateAluno(Aluno aluno) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ALUNOS_SQL);) {
			statement.setString(1, aluno.getCpf());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getEmail());
			statement.setString(4, aluno.getCelular());
			statement.setString(5, aluno.getLogin());
			statement.setString(6, aluno.getSenha());
			statement.setString(7, aluno.getEndereco());
			statement.setString(8, aluno.getCidade());
			statement.setString(9, aluno.getBairro());
			statement.setString(10, aluno.getCep());
			statement.setString(11, aluno.getComentario());
			statement.setBoolean(12, aluno.getAprovado());
			statement.setInt(13, aluno.getId());
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