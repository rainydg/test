package com.cui.hao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cui.hao.meta.User;

public interface PersonMapper {
	
	@Select("Select * from person")
	public List<User>getAllPerson();
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "username", column = "userName"),
		@Result (property = "password", column = "password"),
		@Result (property = "nickName", column = "nickName"),
		@Result (property = "usertype", column = "userType"),
	})
	@Select("Select * from person where userName=#{userName} and password=#{password}")
	public User login(@Param("userName") String username,@Param("password") String password); 
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "username", column = "userName"),
		@Result (property = "password", column = "password"),
		@Result (property = "nickName", column = "nickName"),
		@Result (property = "usertype", column = "userType"),
	})
	@Select("Select * from person where userName=#{userName}")
	public User getUserName(String username);
	
	@Select("Select * from person where nicName=#{nickName}")
	public User getUsernickName(String nickName);

	@Select("Select * from person where id=#{id}")
	public User getUser(int id);
	
	@Select("Select * from person where userType=#{usertype}")
	public int getUserType(int usertype);
}
