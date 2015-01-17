package foo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foo.dao.UserDAO;
import foo.db.MySQL;

@Component("userDAO")
public class UserDAOImpl implements UserDAO{
	
	private String table = "users";
	private String dataBase = "test";
	
	@Autowired
	private MySQL mySQL;
	
	@Override
	public void insert(String username, String Id) {
		try {
			mySQL.insertToDB(dataBase, "insert into "+table+" (username,password) values(?,?)", username, Id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String username, String Id) {
		
	}

	@Override
	public void delete(String username, String Id) {
		
	}
	
	//select
	@Override
	public ResultSet select(String username, String Id) {
		return mySQL.seletFromDB(dataBase, "select * from "+table);
	}
	
	@Override
	public ResultSet selectByUserName(String username) {
		return mySQL.selectById(dataBase,"select * from users where username = ?", username);
	}
	
	@Override
	public boolean isExist(String username) {
		try {
			if(selectByUserName(username).next()) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
