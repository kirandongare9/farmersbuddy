package com.fbuddy.dao;

import java.util.List;

import com.fbuddy.dto.AgriOfficer;
import com.fbuddy.dto.User;

public interface UserDao {

	public User get(int userId);
	public User get(String userName);
	public void save(User user);
	public User doAuth(User user);
	public void saveAgriOfficer(AgriOfficer officer);
	public List<User> get();
	public void delete(int userId);
	public void update(User user);
	
}
