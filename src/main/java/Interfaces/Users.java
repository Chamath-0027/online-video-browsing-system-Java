package Interfaces;

import java.util.ArrayList;

import Model.User;

public interface Users {

	public int addUser(User u);

	public int editUsers(User u);

	public User getUser(int u);

	public int deleteUser(int u);

	public ArrayList<User> getUsers();

}
