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
	
	public Contato getContato(int codContato){
		String sql = "SELECT * FROM tbl_contato WHERE codigo = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codContato);
			rs = stm.executeQuery();
			
			if(rs.next()) {
				contato = new Contato();
				contato.setCodigo(rs.getInt("codigo"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
			}
			
			return contato;
		}catch (Exception e) {
			e.printStackTrace();
			return contato;
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
	
	public boolean atualizar(int codContato) {
		String sql = "UPDATE tbl_contato"
				+ " SET nome=?,"
				+ " email=?,"
				+ " telefone=?"
				+ " WHERE codigo=?";
		
		try {	
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.contato.getNome());
			stm.setString(2, this.contato.getEmail());
			stm.setString(3, this.contato.getTelefone()); 
			stm.setInt(4, codContato);
			stm.execute();
			
			return true;
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public boolean deletar(int codContato) {
		String sql = "DELETE FROM tbl_contato WHERE codigo=?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codContato);
			stm.execute();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}	