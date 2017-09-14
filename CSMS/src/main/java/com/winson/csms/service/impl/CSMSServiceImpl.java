package com.winson.csms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winson.csms.dao.CSMSDao;
import com.winson.csms.model.Role;
import com.winson.csms.model.Type;
import com.winson.csms.model.User;
import com.winson.csms.service.CSMSService;


@Service
public class CSMSServiceImpl implements CSMSService {
	
	@Autowired
	private CSMSDao dao;

	@Override
	public List<User> getAllUser() {
		
		return dao.getAllUser();
	}

	@Override
	public int addOneUser(User user) {
		
		return dao.addOneUser(user);
	}

	@Override
	public int updateUser(User user) {
		
		return dao.updateUser(user);
	}

	@Override
	public User getUserByNumber(String number) {
		
		return dao.getUserByNumber(number);
	}

	@Override
	public int deleteUser(User user) {
		
		return dao.deleteUser(user);
	}

	@Override
	public List<Role> getAllRoles() {
		
		return dao.getAllRoles();
	}

	@Override
	public List<Type> getAllTypes() {
		
		return dao.getAllTypes();
	}

	@Override
	public Role getRoleById(Integer id) {
	
		return dao.getRoleById(id);
	}

	@Override
	public Type getTypeById(Integer id) {
		
		return dao.getTypeById(id);
	}



}
