package com.ensup.partielwebservice.dao;

import com.ensup.partielwebservice.domaine.User;

public interface IUserDao {

	void createUser(User user);

	void getUser();

	void getAllUser();

	void updateUser();

	void deleteUser();

	User getUser(String login, String password);

}