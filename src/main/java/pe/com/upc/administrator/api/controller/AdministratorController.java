package pe.com.upc.administrator.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.upc.administrator.application.AdministratorService;
import pe.com.upc.administrator.application.dto.CourseDto;
import pe.com.upc.administrator.application.dto.TutorDto;
import pe.com.upc.common.api.controller.ResponseHandler;

@RestController
@RequestMapping("/api/administrator")
public class AdministratorController {
	private static final Logger log = LogManager.getLogger(AdministratorController.class);

	@Autowired
	AdministratorService administratorService;
	 
	
	@Autowired
	ResponseHandler responseHandler;

	@GetMapping("/info")
	public String info() {
		log.info("Into info()");
		return "No te olvides de mis 20 soles freddy";
//		return "Service Active";
	}

	@PostMapping(value = "/tutor/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addTutor(@RequestBody TutorDto tutorDto) {
		log.info("Into addTutor(@RequestBody TutorDto tutorDto)");
		try {
			Boolean insert = administratorService.createTutor(tutorDto);
			return new ResponseEntity<Object>(insert, HttpStatus.OK);
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
	}

	@PostMapping(value = "/course/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addCourse(@RequestBody CourseDto courseDto) {
		log.info("Into addCourse(@RequestBody TutorDto tutorDto)");
		try {
			Boolean insert = administratorService.createCourse(courseDto);
			return new ResponseEntity<Object>(insert, HttpStatus.OK);
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
		 
	}

}
