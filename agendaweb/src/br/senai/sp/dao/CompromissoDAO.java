package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.model.Compromisso;

public class CompromissoDAO {
	
	private Compromisso compromisso;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}
	
	public boolean gravar() {
		String sql = "INSERT INTO tbl_compromisso (cod_usuario, titulo,"
				+ " data, hora_inicio,"
				+ " hora_fim, descricao,"
				+ " prioridade, status)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, this.compromisso.getUsuario().getCodUsuario());
			stm.setString(2, this.compromisso.getTitulo());
			stm.setString(3, this.compromisso.getData());
			stm.setString(4, this.compromisso.getHora_inicio());
			stm.setString(5, this.compromisso.getHora_fim());
			stm.setString(6, this.compromisso.getDescricao());
			stm.setInt(7, this.compromisso.getPrioridade());
			stm.setInt(8, this.compromisso.getStatus());
			stm.execute();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizar() {
		String sql = "UPDATE tbl_compromisso "
				+ "SET titulo=?, "
				+ "data=?, "
				+ "hora_inicio=?, "
				+ "hora_fim=?, "
				+ "descricao=?, "
				+ "prioridade=?, "
				+ "status=? "
				+ "WHERE cod_compromisso=?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.compromisso.getTitulo());
			stm.setString(2, this.compromisso.getData());
			stm.setString(3, this.compromisso.getHora_inicio());
			stm.setString(4, this.compromisso.getHora_fim());
			stm.setString(5, this.compromisso.getDescricao());
			stm.setInt(6, this.compromisso.getPrioridade());
			stm.setInt(7, this.compromisso.getStatus());
			stm.setInt(8, this.compromisso.getCod_compromisso());
			stm.execute();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Compromisso> getCompromissos(int codCompromisso, int status){
		String sql = "SELECT * FROM tbl_compromisso WHERE cod_usuario = ? AND status = ?";
		
		ArrayList<Compromisso> compromissos = new ArrayList<>();
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codCompromisso);
			stm.setInt(2, status);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				compromisso = new Compromisso();
				compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				compromisso.setTitulo(rs.getString("titulo"));
				compromisso.setData(rs.getString("data"));
				
				compromissos.add(compromisso);
			}
			
			return compromissos;
		}catch (Exception e) {
			e.printStackTrace();
			return compromissos;
		}
	}
	
	public Compromisso getCompromisso(int codCompromisso){
		String sql = "SELECT * FROM tbl_compromisso WHERE cod_compromisso = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codCompromisso);
			rs = stm.executeQuery();
			
			if(rs.next()) {
				compromisso = new Compromisso();
				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setHora_inicio(rs.getString("hora_inicio"));
				this.compromisso.setHora_fim(rs.getString("hora_fim"));
				this.compromisso.setStatus(rs.getInt("status"));
				this.compromisso.setDescricao(rs.getString("descricao"));
			}
			
			return this.compromisso;
		}catch (Exception e) {
			e.printStackTrace();
			return this.compromisso;
		}
	}
	
	public boolean mudarCompromisso(int codCompromisso, int estadoCompromisso) {
		String sql = "UPDATE tbl_compromisso "
				+ "SET status = ? "
				+ "WHERE cod_compromisso = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, estadoCompromisso);
			stm.setInt(2, codCompromisso);
			stm.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
}
