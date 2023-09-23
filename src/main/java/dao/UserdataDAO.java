package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.User;

public class UserdataDAO extends DAO{
	
	public List<User> findAll(){
		List<User> list = new ArrayList<>();
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM userdata");
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("passward");
				String pict = rs.getString("image");
				User user = new User(id, name, pass, pict);
				list.add(user);
			}
		}catch(NamingException | SQLException e) {
			System.out.println("Connection failed");
		}finally {
			super.disconnect();
		}
		return list;
	}
	
	public User findOne(int id) {
		User user = null;
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM userdata WHERE id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
			user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("image"));
		}catch(NamingException | SQLException e) {
			System.out.println("Connection failed");
		}finally {
			super.disconnect();
		}
		return user;
	}
	
	public User findOne(String name) {
		User user = null;
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM userdata WHERE name=?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			rs.next();
//			int i = rs.getInt("id");
//			System.out.println(i);
			user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("image"));
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
			System.out.println("Connection failed");
		}finally {
			super.disconnect();
		}
		return user;
	}
	
	public void insertOne(User user) {
		try {
			this.connect();
			stmt = con.prepareStatement("INSERT INTO userdata(name, password, image) VALUES(?,?,?)");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getPict());
			stmt.execute();
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			super.disconnect();
		}
	}
	
	//Update要修正
	public void updateOne(User user) {
		try {
			this.connect();
			stmt = con.prepareStatement("UPDATE userdata SET name=?, password=?, image=? WHERE id=?");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getPict());
			stmt.setInt(4, user.getId());
			stmt.execute();
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			super.disconnect();
		}
	}
}