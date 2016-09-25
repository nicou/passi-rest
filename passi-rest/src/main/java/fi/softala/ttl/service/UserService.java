package fi.softala.ttl.service;

import java.util.List;

import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.User;
import fi.softala.ttl.model.WorksheetDTO;

public interface UserService {
	
	public Student findStudentByUsername(String username);
	
	public WorksheetDTO getWorksheetByGroupAndUsername(String groupID, String username);
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
