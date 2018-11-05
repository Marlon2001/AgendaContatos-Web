package br.senai.sp.dao;

import java.sql.PreparedStatement;

import br.senai.sp.model.Usuario;

public class UsuarioDao {
	private Usuario usuario;
	private PreparedStatement stm;
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean gravar() {
		String sql = "INSERT INTO tbl_usuario"
				+ " (nome, email, senha, sexo, dtNascimento)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {	
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.usuario.getNome());
			stm.setString(2, this.usuario.getEmail());
			stm.setString(3, this.usuario.getSenha());
			stm.setString(4, this.usuario.getSexo().substring(0, 1));
			stm.setString(5, this.usuario.getDtNascimento());
			
			stm.execute();
			return true;
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
}
