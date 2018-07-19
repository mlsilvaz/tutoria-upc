package pe.com.upc.administrator.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/administrator")
public class AdministratorController {
	private static final Logger log = LogManager.getLogger(AdministratorController.class);


	@GetMapping("/info")
	public String info() {
		log.info("Into info()");
		return "Service Active";
	}
}
