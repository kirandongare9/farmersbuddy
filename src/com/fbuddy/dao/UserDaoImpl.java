package com.fbuddy.dao;

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

}
