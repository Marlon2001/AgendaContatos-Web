package br.senai.sp.dao;

import java.sql.PreparedStatement;

import br.senai.sp.dbutil.Conexao;
import br.senai.sp.model.Usuario;

public class UsuarioDAO {
	Usuario usuario;
	
	public UsuarioDAO(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioDAO() {
		
	}
	
	public boolean gravar() {
		try {
			String insert = "";
			
			PreparedStatement stm = Conexao.getConexao().prepareStatement(insert);
			
			if(stm.execute()) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
}
