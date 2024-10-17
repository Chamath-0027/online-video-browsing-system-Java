package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBConnect;
import Interfaces.Videos;
import Model.Video;

public class VideoService implements Videos{

	@Override
	public int addVideo(Video video) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//insert value
			preparedStatement = connection.prepareStatement("insert into video (title , date , duration , description , category_id) values (?,?,?,?,?)");
			preparedStatement.setString(1, video.getTitle());
			preparedStatement.setString(2,video.getDate());
			preparedStatement.setInt(3,video.getDuration());
			preparedStatement.setString(4,video.getDescription());
			preparedStatement.setInt(5,video.getCategory_id());
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
	public ArrayList<Video> getVideo() {

		ArrayList<Video> videoList = new ArrayList<>();
		Connection connection;
		PreparedStatement preparedStatement;

		try {

			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM video");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Video video = new Video();

				video.setId(resultSet.getInt(1));
				video.setTitle(resultSet.getString(2));
				video.setDate(resultSet.getString(3));
				video.setDuration(resultSet.getInt(4));
				video.setDescription(resultSet.getString(5));
				video.setCategory_id(resultSet.getInt(6));

				videoList.add(video);

			}

			preparedStatement.close();
			connection.close();

		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return videoList;
	}

	@Override
	public int editVideo(Video video) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

				//update value
				preparedStatement = connection.prepareStatement("UPDATE video SET title=?, date=?, duration=?, description=?, category_id=? where id=?");
				preparedStatement.setString(1, video.getTitle());
				preparedStatement.setString(2,video.getDate());
				preparedStatement.setInt(3,video.getDuration());
				preparedStatement.setString(4,video.getDescription());
				preparedStatement.setInt(5,video.getCategory_id());
				preparedStatement.setInt(6,video.getId());
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
	public int deleteVideo(int video) {
		Connection connection;
		PreparedStatement preparedStatement;

		try {
			connection = DBConnect.getDBConnection();

			//delete video
			preparedStatement = connection.prepareStatement("DELETE FROM video WHERE id=?");
			preparedStatement.setInt(1, video);
			preparedStatement.execute();

			return 1;

		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}

	@Override
	public Video getVideo(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		Video video = new Video();

		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM video where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				video.setId(resultSet.getInt(1));
				video.setTitle(resultSet.getString(2));
				video.setDate(resultSet.getString(3));
				video.setDuration(resultSet.getInt(4));
				video.setDescription(resultSet.getString(5));
				video.setCategory_id(resultSet.getInt(6));

			}

		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
		return video;
	}

}
