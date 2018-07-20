package pe.com.upc.administrator.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.upc.administrator.application.dto.TutorDto;
import pe.com.upc.administrator.domain.entity.Tutor;
import pe.com.upc.administrator.domain.repository.CourseRepository;
import pe.com.upc.administrator.domain.repository.TutorRepository;
import pe.com.upc.common.application.Notification;

@Service
public class AdministratorService {
	
	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	public Boolean createTutor(TutorDto tutorDto) {
		Notification notification=this.createTutorValidation(tutorDto);
		if(notification.hasErrors())
			throw new IllegalArgumentException(notification.errorMessage());
		return tutorRepository.save(this.buildTutorResponse(tutorDto));
	}
	
	private Tutor buildTutorResponse(TutorDto tutorDto) {
		Tutor tutor= new Tutor();
		tutor.setId(tutorDto.getId());
		tutor.setName(tutorDto.getName());
		tutor.setApellidoPaterno(tutorDto.getApellidoPaterno());
		tutor.setDni(tutorDto.getDni());
		tutor.setPhone(tutorDto.getPhone());
		tutor.setState(tutorDto.getState());
		tutor.setUserId(tutorDto.getUserId());
		return tutor;
	}
	
	
	private Notification createTutorValidation(TutorDto tutorDto) {
		Notification notification = new Notification();
		if (tutorDto == null || tutorDto.getName().isEmpty() || tutorDto.getApellidoPaterno().isEmpty()) {
			notification.addError("Invalid JSON data in request body.");
		}
		Tutor tutor = tutorRepository.getByName(tutorDto.getName().trim(),tutorDto.getApellidoPaterno().trim());
		if (tutor != null) {
			notification.addError("User name is already registered");
		}
		return notification;
	}
	
	
	
}
