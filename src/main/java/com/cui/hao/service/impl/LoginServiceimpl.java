package com.cui.hao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cui.hao.dao.PersonMapper;
import com.cui.hao.meta.User;
import com.cui.hao.service.LoginService;

@Component("loginService")
public class LoginServiceimpl implements LoginService {
	
	@Autowired
	private PersonMapper personMapper;
	
	public boolean userLogin(String username, String password) {
		
		User user = personMapper.login(username, password);
		if (user !=null ){
			return true;
		}else{
			return false;
		}
	

	}
	
	
	public List<User> Login() {
		// TODO Auto-generated method stub
		return  personMapper.getAllPerson();
	}	

	
	
	public User getUserName(String username) {
		 
		return personMapper.getUserName(username);
	}
	
	public User getUserid(int id) {
		
		return personMapper.getUser(id);
	}
	
	
	

	
	
	
	
}
