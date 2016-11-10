package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private int categoryID;
	private String categoryName;
	private ArrayList<Worksheet> categoryWorksheets;
	
	public Category() {
		super();
		categoryID = 0;
		categoryName = "";
		categoryWorksheets = new ArrayList<>();
	}

	public Category(int categoryID, String categoryName, ArrayList<Worksheet> categoryWorksheets) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.categoryWorksheets = categoryWorksheets;
	}
	
	public void reset() {
		categoryID = 0;
		categoryName = "";
		categoryWorksheets.clear();
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ArrayList<Worksheet> getCategoryWorksheets() {
		return categoryWorksheets;
	}

	public void setCategoryWorksheets(ArrayList<Worksheet> categoryWorksheets) {
		this.categoryWorksheets = categoryWorksheets;
	}
	
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryWorksheets="
				+ categoryWorksheets + "]";
	}

}
