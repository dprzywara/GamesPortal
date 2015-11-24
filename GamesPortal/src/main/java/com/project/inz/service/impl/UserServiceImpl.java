package com.project.inz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.inz.dao.UserDao;
import com.project.inz.model.User;
import com.project.inz.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public void saveUser(User employee) {
		dao.saveUser(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */

	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if (entity != null) {
			entity.setUsername(user.getUsername());
			entity.setPassword(user.getPassword());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setRoles(user.getRoles());
			entity.setEnabled(user.isEnabled());
		}
	}

	public void deleteUserByLogin(String login) {
		dao.deleteUserByUsername(login);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public User findUserByLogin(String login) {
		return dao.findUserByUsername(login);
	}

	public boolean isUserLoginUnique(Integer id, String login) {
		User user = findUserByLogin(login);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	public void deleteUser(Integer id) {
		dao.deleteUser(id);
	}

	@Override
	public List<String> getAllUsernames() {
		List<String> usernames = new ArrayList<>();
		List<User> users = findAllUsers();
		System.out.println("tyle userow: "+users.size());
		for (User user : users) {
			usernames.add(user.getUsername());
			
		}
		System.out.println("tyle usernames: "+usernames.size());
		return usernames;
	}

}