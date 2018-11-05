package br.senai.sp.dao;

import java.sql.*;

public class Conexao {
	private static Connection conexao;
	
	public static Connection getConexao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://10.107.134.23/db_inf2tb?useTimezone=true&serverTimezone=UTC"; 
			String user = "inf2tb1";
			String pass = "123";
			conexao = DriverManager.getConnection(dbURL, user, pass);
		} catch(Exception erro) {
			erro.printStackTrace();
		}
		
		return conexao;
	}
}
