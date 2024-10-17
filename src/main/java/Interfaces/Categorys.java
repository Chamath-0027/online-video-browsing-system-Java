package Interfaces;

import java.util.ArrayList;

import Model.Category;

public interface Categorys {

	public int addCategory(Category c);

	public int editCategory(Category c);

	public Category getCategory(int c);

	public int deleteCategory(int c);

	public ArrayList<Category> getCategory();
}
