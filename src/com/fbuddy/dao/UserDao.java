package com.fbuddy.dao;

import com.fbuddy.dto.User;

public interface UserDao {

	public void save(User user);
	public User doAuth(User user);
}
