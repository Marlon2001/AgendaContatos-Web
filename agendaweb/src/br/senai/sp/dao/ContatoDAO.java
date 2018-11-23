package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.model.Contato;

public class ContatoDAO {
	
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public ArrayList<Contato> getContatos(int codUsuario){
		String sql = "SELECT * FROM tbl_contato WHERE cod_usuario = ?";
		
		ArrayList<Contato> contatos = new ArrayList<>();
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				contato = new Contato();
				contato.setCodigo(rs.getInt("codigo"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
				contatos.add(contato);
			}
			
			return contatos;
		}catch (Exception e) {
			e.printStackTrace();
			return contatos;
		}
	}
	
	public boolean gravar() {
		String sql = "INSERT INTO tbl_contato "
				+ "(cod_usuario, nome, email, telefone) "
				+ "VALUES (?, ?, ?, ?)";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, contato.getUsuario().getCodUsuario());
			stm.setString(2, contato.getNome());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getTelefone());
			stm.execute();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}	