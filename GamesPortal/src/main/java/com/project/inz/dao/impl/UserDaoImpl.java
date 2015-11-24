package com.project.inz.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.inz.dao.AbstractDao;
import com.project.inz.dao.UserDao;
import com.project.inz.model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	
	
	//@Autowired
	//PasswordEncoder passwordEncoder;
	
	
    public User findById(Integer id) {
    	
    	User user = getById(id);
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		System.out.println("takie haslo:"+user.getPassword());
		return user;
    }
 
    public void saveUser(User user) {
    	//String hashedPassword = passwordEncoder.encode(user.getPassword());  
	//	user.setPassword(hashedPassword);
        persist(user);
    }
 
    public void deleteUserByUsername(String userName) {
        delete(findUserByUsername(userName));
    }
    
    public void deleteUser(Integer id) {

		User user = findById(id);

		if (null != user) {
			delete(user);
		}

	}
 
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createCriteria();
        return (List<User>) criteria.list();
    }
 
    public User findUserByUsername(String userName) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("username", userName));
        return (User) criteria.uniqueResult();
    }
    
    public void updateUser(User user){
		update(user);
	}
    
    
	public Boolean checkIfUserExists(String username) {
		if(findUserByUsername(username)!=null)
			return true;
		
		return false;
	}

	
}