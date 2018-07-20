package pe.com.upc.administrator.domain.infrastructure.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.upc.administrator.domain.entity.Course;
import pe.com.upc.administrator.domain.repository.CourseRepository;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
	
	private static final Logger log = LogManager.getLogger(CourseRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Boolean save(Course course) {
		log.info("Into save(Course course)");
		String sql = "INSERT INTO course(COURSE_NAME, STATE_ACTIVE ) VALUES( ? , ? )";
		int num = jdbcTemplate.update(sql, new Object[] 
				{	course.getName(),
					course.getState() 
				 });
		return (num > 0); 
	}

	@Override
	public Course getById(long userId) {
		log.info("Into getById(long userId)");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getByName(String name) {
		log.info("Into getByName(String name)");
		String sql=" select c.course_id, c.course_name, c.state_active from course c where UPPER(c.course_name) = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rownum) throws SQLException {
				Course course = new Course();
				course.setId(rs.getLong("course_id"));
				course.setName(rs.getString("course_name")); 
				course.setState(rs.getString("state_active")); 
				return course;
			}
		});
	}

	@Override
	public List<Course> getPaginated(int page, int pageSize) { 
		log.info("Into getPaginated(int page, int pageSize)");
		return null;
	}

}
