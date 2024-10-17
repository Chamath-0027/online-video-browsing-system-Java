package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBConnect;
import Interfaces.Categorys;
import Model.Category;

public class CategoryService implements Categorys{

	@Override
	public int addCategory(Category category) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//insert value
			preparedStatement = connection.prepareStatement("insert into category (name, description) values (?,?)");
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2,category.getDescription());
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
	public ArrayList<Category> getCategory() {

		ArrayList<Category> categoryList = new ArrayList<>();
		Connection connection;
		PreparedStatement preparedStatement;

		try {

			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM category");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Category category = new Category();

				category.setId(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				category.setDescription(resultSet.getString(3));

				categoryList.add(category);

			}

			preparedStatement.close();
			connection.close();

		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return categoryList;
	}

	@Override
	public int editCategory(Category category) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

				//update value
				preparedStatement = connection.prepareStatement("UPDATE category SET name=?, description=? where id=?");
				preparedStatement.setString(1, category.getName());
				preparedStatement.setString(2,category.getDescription());
				preparedStatement.setInt(3,category.getId());
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
	public int deleteCategory(int category) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//delete category
			preparedStatement = connection.prepareStatement("DELETE FROM category WHERE id=?");
			preparedStatement.setInt(1, category);
			preparedStatement.execute();

			return 1;

		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}

	@Override
	public Category getCategory(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Category category = new Category();

		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM category where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				category.setId(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				category.setDescription(resultSet.getString(3));

			}

		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return category;
	}

}
