package foo.db;

import java.sql.*;

import org.springframework.stereotype.Component;

@Component("MySQL")
public class MySQL {
	
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
    private String url="jdbc:mysql://localhost:3306/";
	private String user="root";
	private String password="";
	
	private Connection getConn(String dataBase) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url+dataBase, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("getConn is exception");
		}
		
		return conn;
	}
	
	private Statement getStmt() throws SQLException{
		if(conn==null) return null;
		return conn.createStatement();
	}
	
	private PreparedStatement getPstmt(String sql) throws SQLException{
		if(conn==null) return null;
		return conn.prepareStatement(sql);
	}
	
	public void insertToDB(String dataBase, String sql, String username, String Id) throws SQLException{
		conn=getConn(dataBase);
		pstmt=getPstmt(sql);
		
		pstmt.setString(1, username);
		pstmt.setString(2, Id);
		pstmt.executeUpdate();
	}
	
	public void updateToDB(){
		
	}
	
	//select
	public ResultSet seletFromDB(String dataBase, String sql) {
		try {
			conn=getConn(dataBase);
			stmt=getStmt();
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("seletFromDB is exception"+e.getMessage());
		}
		return rs;
	}
	
	public ResultSet selectById(String dataBase, String sql, String Id) {
		try {
			conn=getConn(dataBase);
			pstmt=getPstmt(sql);
			pstmt.setString(1, Id);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectById is exception"+e.getMessage());
		}
		
		return rs;
		
	}
}
