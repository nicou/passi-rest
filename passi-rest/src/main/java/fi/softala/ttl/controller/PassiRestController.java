/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
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

import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.Category;
import fi.softala.ttl.model.User;
import fi.softala.ttl.service.PassiService;
import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.exception.EmptyAnswerContentException;
import fi.softala.ttl.exception.UserNotFoundException;
import fi.softala.ttl.exception.WorksheetNotFoundException;

@RestController
public class PassiRestController {
	
	@Inject
	private PassiDAO dao;

	public PassiDAO getDao() {
		return dao;
	}

	public void setDao(PassiDAO dao) {
		this.dao = dao;
	}
	
	@Autowired
	PassiService passiService;
	
	// Service start up
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "REST Web Service for Passi Application is running nice and smoothly!";
	}

	// Find and get user with all related data
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		User user = dao.findUser(username);
		if (user == null) throw new UserNotFoundException(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// Get worksheets by group ID
	@RequestMapping(value = "/worksheet/{group}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getWorksheets(
			@PathVariable("group") int groupID) {
		List<Category> categorizedWorksheets = dao.getWorksheets(groupID);
		if (categorizedWorksheets.size() == 0) throw new WorksheetNotFoundException(groupID);
		return new ResponseEntity<List<Category>>(categorizedWorksheets, HttpStatus.OK);
	}
	
	// Save student answers
	@RequestMapping(value = "/answer/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveAnswer(
			@RequestBody Answersheet answersheet,
			UriComponentsBuilder ucBuilder) {
		String message = new String("");
		if (dao.isAnswerExist(answersheet.getWorksheetID(), answersheet.getUserID())) {
			message = "User [" + answersheet.getUserID() + "] has already answered to the worksheet [" + answersheet.getWorksheetID() + "].";
			return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
		}
		if (dao.saveAnswer(answersheet)) {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/answer/{id}").buildAndExpand(answersheet.getAnswersheetID()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		} else {
			message = "Save answers interrupted for unknown reason. No changes to database.";
			return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	// Get student answers
	@RequestMapping(value = "/answer/{worksheet}/{group}/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Answersheet> getAnswers(
			@PathVariable("worksheet") int worksheetID,
			@PathVariable("group") int groupID,
			@PathVariable("user") int userID) {
		Answersheet answersheet = passiService.getAnswers(worksheetID, groupID, userID);
		if (answersheet == null) throw new EmptyAnswerContentException(worksheetID, groupID, userID);
		return new ResponseEntity<Answersheet>(answersheet, HttpStatus.OK);
	}
	
	// Delete student answers
	@RequestMapping(value = "/answer/{worksheet}/{user}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAnswer(
			@PathVariable("worksheet") int worksheetID,
			@PathVariable("user") int userID) {
		String message = new String("");
		if (!dao.isAnswerExist(worksheetID, userID)) {
			message = "Deleting failed. Required answers not found.";
			return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		}
		if (dao.deleteAnswer(worksheetID, userID)) {
			message = "Answers successfully deleted.";
			return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		} else {
			message = "Deleting answers interrupted for unknown reason. All data restored.";
			return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);
		}		
	}
	
	// Single image file upload as raw binary
	@RequestMapping(value = "/upload/{file}", method = RequestMethod.POST, consumes = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<String> uploadFileHandler(
			@PathVariable("file") String file,
			HttpEntity<byte[]> requestEntity) {
		String message = new String("");
		if (!file.isEmpty()) {
			BufferedOutputStream stream = null;
			try {
				byte[] payload = requestEntity.getBody();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				if (!dir.exists()) { dir.mkdirs(); }
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file + ".jpg");
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(payload));
				ImageIO.write(image, "JPG", serverFile);
				/*
				stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(payload);
				*/				
				message = "You successfully uploaded file " + file + ".";
				return new ResponseEntity<String>(message, HttpStatus.OK);
			} catch (Exception e) {
				message = "You failed to upload file " + file + ".";
				return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			} finally {
				IOUtils.closeQuietly(stream);
			}
		} else {
			message = "You failed to upload " + file + " because the file was empty.";
			return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	// Exception handlers	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error studentNotFound(UserNotFoundException e) {
		String username = e.getStudentUsername();
		return new Error("User [" + username + "] not found");
	}
	
	@ExceptionHandler(WorksheetNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error worksheetNotFound(WorksheetNotFoundException e) {
		int group = e.getGroupID();
		return new Error("Worksheets for the group [" + group + "] not found.");
	}
	
	@ExceptionHandler(EmptyAnswerContentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error emptyAnswerContent(EmptyAnswerContentException e) {
		int worksheet = e.getWorksheetID();
		int group = e.getGroupID();
		int user = e.getUserID();
		return new Error("Answers for worksheet [" + worksheet + "], group [" + group + "] and user [" + user + "] not found.");
	}
	
	/* Image file upload - multipart version
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
	*/
}