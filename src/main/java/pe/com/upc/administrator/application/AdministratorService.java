package pe.com.upc.administrator.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.upc.administrator.application.dto.CourseDto;
import pe.com.upc.administrator.application.dto.TutorDto;
import pe.com.upc.administrator.domain.entity.Course;
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
		Tutor tutor = tutorRepository.getByName(tutorDto.getName().toUpperCase().trim(),tutorDto.getApellidoPaterno().toUpperCase().trim());
		if (tutor != null) {
			notification.addError("Tutor name is already registered");
		}
		return notification;
	}
	
	public Boolean createCourse(CourseDto courseDto) {
		Notification notification=this.createCourseValidation(courseDto);
		if(notification.hasErrors())
			throw new IllegalArgumentException(notification.errorMessage());
		return courseRepository.save(this.buildCourseResponse(courseDto));
	}
	private Course buildCourseResponse(CourseDto courseDto) {
		Course course= new Course(); 
		course.setId(courseDto.getId());
		course.setName(courseDto.getName());
		course.setState(courseDto.getState());
		return course;
	}
	private Notification createCourseValidation(CourseDto courseDto) {
		Notification notification = new Notification();
		if (courseDto == null || courseDto.getName().isEmpty() ) {
			notification.addError("Invalid JSON data in request body.");
		}
		Course course = courseRepository.getByName(courseDto.getName().toUpperCase().trim() );
		if (course != null) {
			notification.addError("Course name is already registered");
		}
		return notification;
	}
}
