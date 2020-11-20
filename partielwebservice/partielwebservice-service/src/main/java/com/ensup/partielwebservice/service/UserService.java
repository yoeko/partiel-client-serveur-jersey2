package com.ensup.partielwebservice.service;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import com.ensup.partielwebservice.dao.IUserDao;
import com.ensup.partielwebservice.dao.UserDao;
import com.ensup.partielwebservice.domaine.User;

public class UserService {
	
	//private static final Logger serviceLogger = LogManager.getLogger(UserService.class);
	
	IUserDao userDao = new UserDao();
	
	/**
	 * createUser
	 * @param user
	 */
	public void createUser(User user) {
		userDao.createUser(user);
	}
	
	/**
	 * getEtudiant
	 * @param id
	 */
	public User getUser(String login, String password) {
		//serviceLogger.info("Méthode getUser");
		return userDao.getUser(login, password);
	}
}
