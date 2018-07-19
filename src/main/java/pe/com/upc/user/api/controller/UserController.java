package pe.com.upc.user.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.upc.common.api.controller.ResponseHandler;
import pe.com.upc.user.application.UserApplicationService;
import pe.com.upc.user.application.dto.UserAuthDto;
import pe.com.upc.user.application.dto.UserDto;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(value = "*")
public class UserController {
	private static final Logger log = LogManager.getLogger(UserController.class);

	@Autowired
	UserApplicationService userApplicationService;
	
	@Autowired
	ResponseHandler responseHandler;

	@GetMapping("/info")
	public String info() {
		log.info("Into info()");
		return "Service Active";
	}

	@PostMapping(
			value = "/login", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> login2(@RequestBody UserDto userDto) {
		log.info("Into login()");
		try {
			UserAuthDto userAuthDto = userApplicationService.validateUser(userDto);
			if (userAuthDto.isAuthenticated())
				return new ResponseEntity<Object>(userAuthDto, HttpStatus.OK);
			return this.responseHandler.getResponse("Invalid User Name / Password", HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		}catch (Exception ex) {
			ex.printStackTrace();
			return this.responseHandler.getAppExceptionResponse();
		}
		
	}

}
