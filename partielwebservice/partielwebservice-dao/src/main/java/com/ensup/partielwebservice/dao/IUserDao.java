package com.ensup.partielwebservice.dao;

import com.ensup.partielwebservice.domaine.User;

public interface IUserDao {

	/**  Methode pour crée un utilisateur
	 * createUser
	 * @param
	 */

	void createUser(User user);

	/** Méthode pour chercher un user 
	 * @param login ,password
	 * return user
	 */
	User getUser(String login, String password);

}