package service;

import domaine.User;

public interface IUserServiceClient {

	User login(User user);

	User getUser();

}