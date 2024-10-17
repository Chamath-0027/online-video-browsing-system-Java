package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBConnect;
import Interfaces.Comments;
import Model.Comment;

public class CommentService implements Comments{

	@Override
	public int addComment(Comment comment) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//insert value
			preparedStatement = connection.prepareStatement("insert into comment (text, date, user_id, video_id) values (?,?,?,?)");
			preparedStatement.setString(1, comment.getText());
			preparedStatement.setString(2,comment.getDate());
			preparedStatement.setInt(3,comment.getUser_id());
			preparedStatement.setInt(4,comment.getVideo_id());
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
	public ArrayList<Comment> getComment() {

		ArrayList<Comment> commentList = new ArrayList<>();
		Connection connection;
		PreparedStatement preparedStatement;

		try {

			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM comment");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Comment comment = new Comment();

				comment.setId(resultSet.getInt(1));
				comment.setText(resultSet.getString(2));
				comment.setDate(resultSet.getString(3));
				comment.setUser_id(resultSet.getInt(4));
				comment.setVideo_id(resultSet.getInt(5));

				commentList.add(comment);

			}

			preparedStatement.close();
			connection.close();

		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return commentList;
	}

	@Override
	public int editComment(Comment comment) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

				//update value
				preparedStatement = connection.prepareStatement("UPDATE comment SET text=?, date=?, user_id=?, video_id=? where id=?");
				preparedStatement.setString(1, comment.getText());
				preparedStatement.setString(2,comment.getDate());
				preparedStatement.setInt(3,comment.getUser_id());
				preparedStatement.setInt(4,comment.getVideo_id());
				preparedStatement.setInt(5,comment.getId());
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
	public int deleteComment(int comment) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//delete comment
			preparedStatement = connection.prepareStatement("DELETE FROM comment WHERE id=?");
			preparedStatement.setInt(1, comment);
			preparedStatement.execute();

			return 1;

		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}

	@Override
	public Comment getComment(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Comment comment = new Comment();

		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM comment where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				comment.setId(resultSet.getInt(1));
				comment.setText(resultSet.getString(2));
				comment.setDate(resultSet.getString(3));
				comment.setUser_id(resultSet.getInt(4));
				comment.setVideo_id(resultSet.getInt(5));

			}

		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return comment;
	}

}
