package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

 abstract class DAO {
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	
	public void connect() throws NamingException, SQLException{
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/mariadb");
		this.con = ds.getConnection();
	}
	
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getStmt() {
		return this.stmt;
	}
	
	
}
