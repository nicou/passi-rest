/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;
import fi.softala.ttl.service.UserService;
import fi.softala.ttl.exception.StudentNotFoundException;
import fi.softala.ttl.exception.WorksheetNotFoundException;

@RestController
public class PassiRestController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "<html><head><title>REST Web Service</title></head><body><p>REST Web Service for PASSI Application running nice and smoothly :)</p></body></html>";
	}

	@RequestMapping(value = "/student/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable("username") String username) {
		System.out.println("Fetching student with username = " + username);
		Student student = userService.findStudentByUsername(username);
		if (student == null) throw new StudentNotFoundException(username);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/worksheet/{group}/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Worksheet> getWorksheet(
			@PathVariable("group") String groupID,
			@PathVariable("username") String username) {
		System.out.println("Fetching worksheet with groupID = " + groupID + " and username = " + username);
		Worksheet ws = userService.getWorksheet(groupID, username);
		if (ws == null) throw new WorksheetNotFoundException(groupID, username);
		return new ResponseEntity<Worksheet>(ws, HttpStatus.OK);
	}
	
	// Exception handling
	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error studentNotFound(StudentNotFoundException e) {
		String username = e.getStudentUsername();
		return new Error("Student [" + username + "] not found");
	}
	
	@ExceptionHandler(WorksheetNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error worksheetNotFound(WorksheetNotFoundException e) {
		String group = e.getGroupID();
		String username = e.getUsername();
		return new Error("Worksheet for student [" + username + "] member of group [" + group + "] not found");
	}
	
	/* Use UriComponentBuilder to return resource URI for example when storing image on server
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Spittle> saveSpittle(
			@RequestBody Spittle spittle,
			UriComponentsBuilder ucb) {
		Spittle spittle = spittleRepository.save(spittle);
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/spittles/")
			.path(String.valueOf(spittle.getId()))
			.build()
			.toUri();
		headers.setLocation(locationUri);
		ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);
		return responseEntity;
	}
	*/
	
	/*
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT); // or HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getUsername());
		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getUsername() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Updating User " + id);
		User currentUser = userService.findById(id);
		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		currentUser.setUsername(user.getUsername());
		currentUser.setPassword(user.getPassword());
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		System.out.println("Deleting All Users");
		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	*/
}