package com.winson.csms.service;

import java.util.List;

import com.winson.csms.model.Role;
import com.winson.csms.model.Type;
import com.winson.csms.model.User;

public interface CSMSService {

	List<User> getAllUser();
	int addOneUser(User user);
	int updateUser(User user);
	User getUserByNumber(String number);
	int deleteUser(User user);		
	List<Role> getAllRoles();
	List<Type> getAllTypes();
	Role getRoleById(Integer id);
	Type getTypeById(Integer id);

}
