package com.fbuddy.service;

import com.fbuddy.dto.AgriOfficer;
import com.fbuddy.dto.User;

public interface UserService {

	public void save(User user);
	public User doAuth(User user);

	public void saveAgriOfficer(AgriOfficer officer);
}
