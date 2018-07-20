package pe.com.upc.administrator.domain.repository;

import java.util.List;

import pe.com.upc.administrator.domain.entity.Course;

public interface CourseRepository {
	
	public Boolean save(Course course);

	public Course getById(long userId);

	public Course getByName(String name);

	public List<Course> getPaginated(int page, int pageSize);
}
