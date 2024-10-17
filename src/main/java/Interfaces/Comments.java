package Interfaces;

import java.util.ArrayList;

import Model.Comment;

public interface Comments {

	public int addComment(Comment c);

	public int editComment(Comment c);

	public Comment getComment(int c);

	public int deleteComment(int c);

	public ArrayList<Comment> getComment();
}
