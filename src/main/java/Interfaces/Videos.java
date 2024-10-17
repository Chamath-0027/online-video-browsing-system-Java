package Interfaces;

import java.util.ArrayList;

import Model.Video;

public interface Videos {

	public int addVideo(Video c);

	public int editVideo(Video c);

	public Video getVideo(int c);

	public int deleteVideo(int c);

	public ArrayList<Video> getVideo();
}
