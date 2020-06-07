package com.fbuddy.service;

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

}
