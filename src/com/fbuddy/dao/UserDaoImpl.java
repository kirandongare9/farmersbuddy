package com.fbuddy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fbuddy.dto.AgriOfficer;
import com.fbuddy.dto.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate jt;
	
	public void save(User user) {
		//save coding
		String query = "insert into users(username,pswd,name,email,first_name,last_name,gender,dob,state,city,role) values(?,?,?,?,?,?,?,?,?,?,?)";
		jt.update(query,user.getUserName() , user.getPswd() , user.getName() , user.getEmail() , user.getFirstName(),
				user.getLastName(),user.getGender(),user.getDob(),user.getState(),user.getCity(),user.getRole()==null?"":user.getRole());
	}

	@Override
	public User doAuth(User user) {
		
		String sql = "select username,name,email,role from users where username = ? and pswd = ?;";
		List<Map<String, Object>> result = jt.queryForList(sql,user.getUserName(),user.getPswd());
		if(result==null || result.size()==0)
			return null;
		else {
			user.setEmail(result.get(0).get("email").toString());
			Object role = result.get(0).get("role");
			user.setRole(role==null?"":role.toString());
		}
		
		return user;
	}

	@Override
	public void saveAgriOfficer(AgriOfficer officer) {
		//save coding
		User user = officer.getUser();
		user.setRole("officer");
		this.save(user);
		
		String query = "insert into agri_officers(username,qualification,designation) values(?,?,?)";
		jt.update(query,user.getUserName() , officer.getQualification(),officer.getDesignation());
		
	}

	@Override
	public List<User> get() {
		
		String query = "select * from users";
		
		List<Map<String,Object>> result = jt.queryForList( query);
		List<User> users = new ArrayList<>();
		
		result.forEach( row -> {
			User user = new User();
			user.setId(Integer.parseInt(row.get("id").toString()));
			user.setName(row.get("first_name")+" "+row.get("last_name"));
			user.setEmail(row.get("email").toString());
			user.setUserName(row.get("username").toString());
			Object role = row.get("role");
			user.setRole(role==null?"":role.toString());
			users.add(user);
		});
		
		return users;
	}

	@Override
	public void delete(int userId) {
		String query = "delete from users where id = ?";
		jt.update(query,userId);

	}

	@Override
	public User get(String userName) {
		
		String query = "select * from users where username = ?";
		
		List<Map<String,Object>> result = jt.queryForList( query , userName);
		List<User> users = new ArrayList<>();
		
		result.forEach( row -> {
			User user = new User();
			user.setFirstName(row.get("first_name").toString());
			user.setLastName(row.get("last_name").toString());
			user.setId(Integer.parseInt(row.get("id").toString()));
			user.setDob(row.get("dob").toString());
			user.setState(row.get("state").toString());
			user.setCity(row.get("city").toString());
			
			user.setName(row.get("first_name")+" "+row.get("last_name"));
			user.setEmail(row.get("email").toString());
			user.setUserName(row.get("username").toString());
			Object role = row.get("role");
			user.setRole(role==null?"":role.toString());
			users.add(user);
		});
		
		return users.size()>0?users.get(0):null;
	}

	@Override
	public void update(User user) {
		String query = "update users set username = ? , first_name = ? , last_name = ? , dob = ? , state = ? , city = ? , email = ? , role = ? where id = ?";
		jt.update(query,user.getUserName(),user.getFirstName(),user.getLastName(),user.getDob(),user.getState(),user.getCity(),user.getEmail(),user.getRole(),user.getId());
	}

	@Override
	public User get(int userId) {

		String query = "select * from users where id = ?";
		
		List<Map<String,Object>> result = jt.queryForList( query , userId);
		List<User> users = new ArrayList<>();
		
		result.forEach( row -> {
			User user = new User();
			user.setFirstName(row.get("first_name").toString());
			user.setLastName(row.get("last_name").toString());
			user.setId(Integer.parseInt(row.get("id").toString()));
			user.setDob(row.get("dob").toString());
			user.setState(row.get("state").toString());
			user.setCity(row.get("city").toString());
			
			user.setName(row.get("first_name")+" "+row.get("last_name"));
			user.setEmail(row.get("email").toString());
			user.setUserName(row.get("username").toString());
			Object role = row.get("role");
			user.setRole(role==null?"":role.toString());
			users.add(user);
		});
		
		return users.size()>0?users.get(0):null;

	}

	
}
