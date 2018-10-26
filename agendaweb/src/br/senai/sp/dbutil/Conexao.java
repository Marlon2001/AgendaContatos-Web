package br.senai.sp.dbutil;

import java.sql.*;

public class Conexao {
	private static Connection conexao;
	
	public static Connection getConexao() {
		
		try {
			Class.forName("");
			conexao = DriverManager.getConnection("");
		} catch(Exception erro) {
			erro.printStackTrace();
		}
		
		return conexao;
	}
}
