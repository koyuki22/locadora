package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}


