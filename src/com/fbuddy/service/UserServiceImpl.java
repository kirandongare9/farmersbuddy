package com.fbuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbuddy.dao.UserDao;
import com.fbuddy.dto.AgriOfficer;
import com.fbuddy.dto.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	
	@Override
	public void save(User user) {
		dao.save(user);
	}

	@Override
	public User doAuth(User user) {
		return dao.doAuth(user);
	}

	@Override
	public void saveAgriOfficer(AgriOfficer officer) {
		dao.saveAgriOfficer(officer);
		
	}

	@Override
	public List<User> get() {
		return dao.get();
	}

	@Override
	public void delete(int userId) {
		dao.delete(userId);
	}

	@Override
	public User get(String userName) {
		return dao.get(userName);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public User get(int userId) {
		return dao.get(userId);
	}

}
