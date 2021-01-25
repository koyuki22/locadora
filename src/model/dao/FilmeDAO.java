package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.filme;

public class FilmeDAO {
	private static final Connection con = null;

	public void create(filme f) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("INSERT INTO FILME(titulo, categoria, dub, 3d, duracao, sinopse) VALUES (?,?,?,?,?,?)");
			
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setBoolean(3, f.isDublado());
			stmt.setInt(4, f.getTempo());
			stmt.setBoolean(5, f.isImg3d());
			stmt.setString(6, f.getSinopse());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Filme salvo com sucesso!");
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
			
			
		}finally {
			
		ConnectionFactory.closeConnection(con,stmt);
			
			
			
		}
	}

	public static Connection getCon() {
		return con;
	}
    //cadastrar
	public List<filme> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<filme> filmes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT + FROM filme;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				filme f = new filme();
				f.setIdFilme(rs.getInt("idFilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setTempo(rs.getInt("tempo"));
				f.setImg3d(rs.getBoolean("img3d"));
				f.setDublado(rs.getBoolean("dublado"));
				f.setSinopse(rs.getString("sinopse"));
				f.setCategoria(rs.getString("categoria"));
				filmes.add(f);
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar informações no BD: " + e);
			e.printStackTrace();
		}finally {
			
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
				return filmes;
		
	}
	
	//listar
	public filme read(int idFilme) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		filme f = new filme();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM movie WHERE id=? LIMIT 1");
			stmt.setInt(1, idFilme);
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				f.setIdFilme(rs.getInt("idFilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setTempo(rs.getInt("tempo"));
				f.setImg3d(rs.getBoolean("img3d"));
				f.setDublado(rs.getBoolean("dublado"));
				f.setSinopse(rs.getString("sinopse"));
				f.setCategoria(rs.getString("categoria"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return f;
	}
	
	//alterar
	public void update(filme f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE movie SET titulo=?, =?, dublado=?, categoria=?, img3d=?, sinopse=? WHERE idfilme=?");
			
			stmt.setString(2, f.getTitulo());
			stmt.setInt(1, f.getIdFilme());
			stmt.setString(6, f.getSinopse());
			stmt.setString(7, f.getCategoria());
			stmt.setBoolean(4, f.isImg3d());
			stmt.setBoolean(5, f.isDublado());
			stmt.setInt(3, f.getTempo());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Mudanças salvas com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

	
	
	public void remove(int idFilme) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM movie WHERE id=?");
			
			stmt.setInt(1, idFilme);
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
}


