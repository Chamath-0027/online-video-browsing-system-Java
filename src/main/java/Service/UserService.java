package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBConnect;
import Interfaces.Users;
import Model.User;

public class UserService implements Users{

	@Override
	public int addUser(User user) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//insert value
			preparedStatement = connection.prepareStatement("insert into users (name, username, phone, password) values (?,?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPhone());
			preparedStatement.setString(4,user.getPassword());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();

			return 1;

		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public ArrayList<User> getUsers() {

		ArrayList<User> userList = new ArrayList<>();
		Connection connection;
		PreparedStatement preparedStatement;

		try {

			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM users");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				User user = new User();

				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setUsername(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));

				userList.add(user);

			}

			preparedStatement.close();
			connection.close();

		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return userList;
	}

	@Override
	public int editUsers(User user) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

				//update value
				preparedStatement = connection.prepareStatement("UPDATE users SET name=?, username=?, phone=?, password=? where id=?");
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2,user.getUsername());
				preparedStatement.setString(3,user.getPhone());
				preparedStatement.setString(4,user.getPassword());
				preparedStatement.setInt(5,user.getId());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				return 1;


		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public int deleteUser(int user) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//delete user
			preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
			preparedStatement.setInt(1, user);
			preparedStatement.execute();

			return 1;

		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}

	@Override
	public User getUser(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		User user = new User();

		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM users where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setUsername(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));

			}

		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

}
