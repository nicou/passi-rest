package fi.softala.ttl.service;

import java.util.ArrayList;

import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;

public interface PassiService {
	
	public Student findStudentByUsername(String username);
	
	public ArrayList<Worksheet> getWorksheets(String groupID);
	
	/*
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	*/
}
