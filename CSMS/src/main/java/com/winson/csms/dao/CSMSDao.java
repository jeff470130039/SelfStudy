package com.winson.csms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.winson.csms.model.Role;
import com.winson.csms.model.Type;
import com.winson.csms.model.User;

@Repository
public interface CSMSDao {
	//user dao
	List<User> getAllUser();
	int addOneUser(User user);
	int updateUser(User user);
	User getUserByNumber(String number);
	int deleteUser(User user);
	
	//role dao
	List<Role> getAllRoles();
	Role getRoleById(Integer id);
	
	//type dao 
	List<Type> getAllTypes();
	Type getTypeById(Integer id);

}
