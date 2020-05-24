package com.fbuddy.service;

import com.fbuddy.dto.User;

public interface UserService {

	public void save(User user);
	public User doAuth(User user);
}
