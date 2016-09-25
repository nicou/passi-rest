package fi.softala.ttl.service;

import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;

public interface UserService {
	
	public Student findStudentByUsername(String username);
	
	public Worksheet getWorksheet(String groupID, String username);
	
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
