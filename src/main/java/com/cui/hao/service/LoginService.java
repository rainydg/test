package com.cui.hao.service;

import java.util.List;

import com.cui.hao.meta.User;

public interface LoginService {
	
	public boolean userLogin(String username,String password);
	
	public User getUserName(String username);
	
	public User getUserid(int id);
	
	public List<User> Login();
	
}
