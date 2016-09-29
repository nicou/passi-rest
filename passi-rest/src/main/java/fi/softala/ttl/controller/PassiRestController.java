/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fi.softala.ttl.model.AnswerWorksheetDTO;
import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;
import fi.softala.ttl.service.PassiService;
import fi.softala.ttl.exception.StudentNotFoundException;
import fi.softala.ttl.exception.WorksheetsNotFoundException;

@RestController
public class PassiRestController {

	@Autowired
	PassiService passiService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "REST Web Service for Passi Application is running nice and smoothly!";
	}

	@RequestMapping(value = "/student/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable("username") String username) {
		Student student = passiService.findStudentByUsername(username);
		if (student == null) throw new StudentNotFoundException(username);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/worksheet/{group}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Worksheet>> getWorksheet(
			@PathVariable("group") String groupID) {
		ArrayList<Worksheet> worksheets = passiService.getWorksheets(groupID);
		if (worksheets.size() == 0) throw new WorksheetsNotFoundException(groupID);
		return new ResponseEntity<ArrayList<Worksheet>>(worksheets, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/answer/", method = RequestMethod.POST)
	public ResponseEntity<String> saveAnswer(
			@RequestBody AnswerWorksheetDTO answer,
			UriComponentsBuilder ucBuilder) {
		String message = new String("");
		if (passiService.isAnswerExist(answer)) {
			message = "Student [" + answer.getUsername() + "] has already answered to the worksheet ID: " + answer.getWorksheetID();
			return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
		}
		passiService.saveAnswer(answer);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/answer/{id}").buildAndExpand(answer.getAnswerID()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/answer/{worksheet}/{username}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAnswer(
			@PathVariable("worksheet") int worksheetID,
			@PathVariable("username") String username) {
		String message = new String("");
		if (!passiService.isAnswerExist(worksheetID)) {
			message = "Deleting failed. Required answers not found.";
			return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		}
		if (passiService.deleteAnswer(worksheetID, username)) {
			message = "Answers successfully deleted.";
			return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		} else {
			message = "Deleting answers interrupted for unknown reason. All data restored.";
			return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);
		}		
	}
	
	/*
	@RequestMapping(value="/upload/", method=RequestMethod.POST)
    public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file) {
    	String fileName = null;
    	if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + fileName);
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(dir));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }
    */

	@RequestMapping(value = "/upload/{file}", method = RequestMethod.POST, consumes = MediaType.IMAGE_JPEG_VALUE) // "image/jpeg"
	public ResponseEntity<String> uploadFileHandler(
			@PathVariable("file") String file,
			HttpEntity<byte[]> requestEntity) {
		String message = new String("");
		if (!file.isEmpty()) {
			try {
				byte[] payload = requestEntity.getBody();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file + ".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(payload);
				stream.close();
				message = "You successfully uploaded file " + file;
				return new ResponseEntity<String>(message, HttpStatus.OK);
			} catch (Exception e) {
				message = "You failed to upload file " + file;
				return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			}
		} else {
			message = "You failed to upload " + file + " because the file was empty.";
			return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
		}
	}

	// EXCEPTION HANDLING
	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error studentNotFound(StudentNotFoundException e) {
		String username = e.getStudentUsername();
		return new Error("Student [" + username + "] not found");
	}
	
	@ExceptionHandler(WorksheetsNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error worksheetNotFound(WorksheetsNotFoundException e) {
		String group = e.getGroupID();
		return new Error("Worksheets for the group [" + group + "] not found");
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
		
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = passiService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT); // or HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Updating User " + id);
		User currentUser = passiService.findById(id);
		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		currentUser.setUsername(user.getUsername());
		currentUser.setPassword(user.getPassword());
		passiService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		System.out.println("Deleting All Users");
		passiService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	*/
}