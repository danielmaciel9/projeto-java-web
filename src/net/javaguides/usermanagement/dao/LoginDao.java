package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import net.javaguides.usermanagement.model.Aluno;
import net.javaguides.usermanagement.model.Instrutores;
import net.javaguides.usermanagement.model.LoginBean;

public class LoginDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/escola?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private static final String SELECT_INSTRUTORES_BY_LOGIN = "select id, nome, email, valor_hora, login, senha, experiencia from instrutores where login = ? and senha = ?";
	private static final String SELECT_ALUNO_BY_LOGIN = "select cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado from alunos where login = ? and senha = ?";
	
	
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
	
    public List<Object> validate(String username, String password) throws ClassNotFoundException {
        boolean status = false;

        System.out.println(SELECT_INSTRUTORES_BY_LOGIN);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INSTRUTORES_BY_LOGIN)) {
				// Step 2:Create a statement using connection object
	         
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            status = rs.next();
	            
	            if(status) {
	            	Instrutores instrutores;
	            	String nome = rs.getString("nome");
					String email = rs.getString("email");
					Integer valor_hora = rs.getInt("valor_hora");
					String login = rs.getString("login");
					String senha = rs.getString("senha");
					String experiencia = rs.getString("experiencia");
					instrutores = new Instrutores(nome, email, valor_hora, login, senha, experiencia);
	            	return Arrays.asList(status, "instrutor", instrutores);
	            }
	            
	            
    		}
		catch (SQLException e) {
			printSQLException(e);
		}
		try (Connection connection2 = getConnection();
				PreparedStatement preparedStatement2 = connection2.prepareStatement(SELECT_ALUNO_BY_LOGIN)) {
				// Step 2:Create a statement using connection object
	         
	            preparedStatement2.setString(1, username);
	            preparedStatement2.setString(2, password);
	
	            System.out.println(preparedStatement2);
	            ResultSet rs2 = preparedStatement2.executeQuery();
	            status = rs2.next();
	            
	            if(status) {
	            	Aluno aluno;
	            	String cpf = rs2.getString("cpf");
					String nome = rs2.getString("nome");
					String email = rs2.getString("email");
					String celular = rs2.getString("celular");
					String login = rs2.getString("login");
					String senha = rs2.getString("senha");
					String endereco = rs2.getString("endereco");
					String cidade = rs2.getString("cidade");
					String bairro = rs2.getString("bairro");
					String cep = rs2.getString("cep");
					String comentario = rs2.getString("comentario");
					Boolean aprovado = rs2.getBoolean("aprovado");
					aluno = new Aluno(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado);
	            	return Arrays.asList(status, "aluno", aluno);
	            }
	            
	            
    		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return Arrays.asList();
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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