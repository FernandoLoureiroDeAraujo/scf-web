package br.com.loureiro.scf.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MdlConexaoBanco {
	
	private static final Logger logger = LogManager.getLogger(MdlConexaoBanco.class);

	private static final String CLASS = "org.mariadb.jdbc.Driver";	
	private static final String URL = "jdbc:mariadb://localhost:3306/DB_SCF";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	// Método de Conexão
	public Connection getConexao() {
		
		Connection conn = null; 

		try {	
			Class.forName(CLASS);		
			conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}	
		
		return conn;
	}
	
	// Método que fecha Connection
	private void fecharConexao(Connection conn) {
		if(conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {} 
	}
	
	// Método que fecha Statement
	private void fecharConexao(Statement stmt) {
		if(stmt == null)
			return;
		try {
			stmt.close();
		} catch (SQLException e) {}
	}
	
	// Método que fecha ResultSet
	private void fecharConexao(ResultSet rset) {
		if(rset == null)
			return;
		try {
			rset.close();
		} catch (SQLException e) {} 
	}
	
	// Método que fecha todas as conexões
	public void fecharTodasConexoes(Connection conn, Statement stmt) {
		fecharConexao(stmt);
		fecharConexao(conn);
	}

	// Método que fecha todas as conexões 
	public void fecharTodasConexoes(Connection conn, Statement stmt, ResultSet rset) {
		fecharConexao(rset);
		fecharConexao(stmt);
		fecharConexao(conn);
	}
}