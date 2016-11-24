package fi.softala.ttl.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.AuthUser;
import fi.softala.ttl.model.Category;
import fi.softala.ttl.model.User;
import fi.softala.ttl.service.PassiService;
import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.exception.EmptyAnswerContentException;
import fi.softala.ttl.exception.UserNotFoundException;
import fi.softala.ttl.exception.WorksheetNotFoundException;

/**
 * @author Mika Ropponen | mika.ropponen@gmail.com
 * 
 * The main controller of Passi REST Service for Android mobile client. Due to
 * absence of SSL/TLS secured connection and light authentication all CRUD
 * methods are not available. Update and delete methods are available only if
 * they are necessary for the mobile client.
 */
@RestController
public class PassiRestController {

	private static final Logger log = LoggerFactory.getLogger(PassiRestController.class);

	@Inject
	private PassiDAO dao;

	public PassiDAO getDao() {
		return dao;
	}

	public void setDao(PassiDAO dao) {
		this.dao = dao;
	}

	// Injected service accountable for data persistence.
	@Autowired
	PassiService passiService;

	/**
	 * Service start up.
	 * 
	 * @return This is the flag showing the service is up and running
	 * http://server/passi-rest
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init() {
		return "<html><head><title>Passi REST Service</title></head><body>REST Web Service for Passi Application is running nice and smoothly!</body></html>";
	}

	/**
	 * Find and get user by username with all related data at once.
	 * 
	 * @param username
	 * @return User as JSON including user data, user's groups, groups'
	 * instructors; HttpStatus
	 */
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		User user = passiService.findUser(username);
		if (user == null)
			throw new UserNotFoundException(username);
		log.debug("getUser() : Requested user found for JSON response - User: {}", user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registerUser(@RequestBody AuthUser user) {
		User userData = passiService.findUser(user.getUsername());
		if (userData != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		if (!passiService.addUser(user)) {
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
		log.debug("registerUser() : User successfully registered - User: {}", user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Get worksheets by group ID. Worksheets are sorted into categories.
	 * 
	 * @param groupID
	 * @return List<Category> as JSON including Worksheets, Waypoints, Options; HttpStatus
	 */
	@RequestMapping(value = "/worksheet/{group}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getWorksheets(@PathVariable("group") int groupID) {
		List<Category> categorizedWorksheets = passiService.getWorksheets(groupID);
		if (categorizedWorksheets.size() == 0)
			throw new WorksheetNotFoundException(groupID);
		log.debug("getWorksheets() : Requested categorized worksheets List<Category> found for JSON response");
		return new ResponseEntity<List<Category>>(categorizedWorksheets, HttpStatus.OK);
	}

	/**
	 * Save student answers.
	 * 
	 * @param answersheet JSON from the client
	 * @return String message, HttpStatus
	 */
	@RequestMapping(value = "/answer/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveAnswer(@RequestBody Answersheet answersheet) {
		String message = new String("");
		if (passiService.isAnswerExist(answersheet.getWorksheetID(), answersheet.getUserID())) {
			message = "User [" + answersheet.getUserID() + "] has already answered to the worksheet ["
					+ answersheet.getWorksheetID() + "].";
			return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
		}
		if (passiService.saveAnswer(answersheet)) {
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else {
			message = "Save answers interrupted for unknown reason. No changes to database.";
			return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * Get student answers by worksheetID, groupID and userID.
	 * 
	 * @param worksheetID
	 * @param groupID
	 * @param userID
	 * @return Answersheet as JSON, HttpStatus
	 */
	@RequestMapping(value = "/answer/{worksheet}/{group}/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Answersheet> getAnswers(@PathVariable("worksheet") int worksheetID,
			@PathVariable("group") int groupID, @PathVariable("user") int userID) {
		Answersheet answersheet = passiService.getAnswers(worksheetID, groupID, userID);
		if (answersheet == null)
			throw new EmptyAnswerContentException(worksheetID, groupID, userID);
		return new ResponseEntity<Answersheet>(answersheet, HttpStatus.OK);
	}

	/**
	 * Delete student answers. Tool for mobile client development. Supposed to
	 * be removed when not needed anymore.
	 * 
	 * @param worksheetID
	 * @param userID
	 * @return Sring message, HttpStatus
	 */
	@RequestMapping(value = "/answer/{worksheet}/{user}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAnswer(@PathVariable("worksheet") int worksheetID,
			@PathVariable("user") int userID) {
		String message = new String("");
		if (!passiService.isAnswerExist(worksheetID, userID)) {
			message = "Deleting failed. Required answers not found.";
			return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		}
		if (passiService.deleteAnswer(worksheetID, userID)) {
			message = "Answers successfully deleted.";
			return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		} else {
			message = "Deleting answers interrupted for unknown reason. All data restored.";
			return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	/**
	 * Join group with key string
	 * 
	 * @param key String to join a group, given by group instructor 
	 * @return HttpStatus
	 */
	@RequestMapping(value = "/join/{key}/{user}", method = RequestMethod.GET)
	public ResponseEntity<Void> joinGroup(
			@PathVariable("user") int userID,
			@PathVariable("key") String key) {
		if (!passiService.isGroupExist(key)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		if (!passiService.joinUserIntoGroup(key, userID)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Single JPEG image file upload as raw binary for hign-performance upload
	 * from mobile client
	 * 
	 * @param file name without extension (.jpg)
	 * @param requestEntity raw image binary body content
	 * @return String message, HttpStatus
	 */
	@RequestMapping(value = "/upload/{file}", method = RequestMethod.POST, consumes = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<String> uploadFileHandler(@PathVariable("file") String file,
			HttpEntity<byte[]> requestEntity) {
		String message = new String("");
		if (!file.isEmpty()) {
			BufferedOutputStream stream = null;
			try {
				byte[] payload = requestEntity.getBody();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file + ".jpg");
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(payload));
				ImageIO.write(image, "JPG", serverFile);
				message = "You successfully uploaded file " + file + ".jpg.";
				return new ResponseEntity<String>(message, HttpStatus.OK);
			} catch (Exception e) {
				message = "You failed to upload file " + file + ".jpg.";
				return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
			} finally {
				IOUtils.closeQuietly(stream);
			}
		} else {
			message = "You failed to upload " + file + ".jpg because the file was empty.";
			return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Exception handlers for common runtime exceptions
	 * 
	 * @param e
	 * @return String message, HttpStatus
	 */
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
}