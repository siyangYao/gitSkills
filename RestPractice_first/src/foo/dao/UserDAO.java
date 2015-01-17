package foo.dao;

import java.sql.ResultSet;

public interface UserDAO {
	public void insert(String username, String Id);
	public void update(String username, String Id);
	public void delete(String username, String Id);
	public ResultSet select(String username, String Id);
	public ResultSet selectByUserName(String username);
	public boolean isExist(String username);
}
