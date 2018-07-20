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

import pe.com.upc.administrator.domain.entity.Tutor;
import pe.com.upc.administrator.domain.repository.TutorRepository;

@Repository
public class TutorRepositoryImpl implements TutorRepository {

	private static final Logger log = LogManager.getLogger(TutorRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean save(Tutor tutor)  {
		log.info("Into save(Tutor tutor)");
		String sql = "INSERT INTO tutor(  tutor_name, tutor_ape_paterno, dni, phone, state_value ) "
				+ "VALUES( ? , ? , ? , ? , ? )";
		int num = jdbcTemplate.update(sql, new Object[] 
				{	
						tutor.getName(), 
						tutor.getApellidoPaterno(), 
						tutor.getDni(), 
						tutor.getPhone(), 
						tutor.getState() });
		return (num > 0);
	}

	@Override
	public Tutor getById(long tutorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tutor getByName(String name, String lastName) {
		String sql = "select t.tutor_id, t.tutor_name, t.tutor_ape_paterno, t.dni ,t.phone ,t.state_value "
				+ "s,t.userid from tutor t where t.tutor_name= ? and t.tutor_ape_paterno = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { name,lastName },
				new RowMapper<Tutor>() {
			public Tutor mapRow(ResultSet rs, int rownum) throws SQLException {
				Tutor tu = new Tutor();
				tu.setId(rs.getLong("tutor_id"));
				tu.setName(rs.getString("tutor_name"));
				tu.setApellidoPaterno( rs.getString("tutor_ape_paterno"));
				tu.setDni(rs.getString("dni"));
				tu.setPhone(rs.getString("phone"));
				tu.setState(rs.getString("state_value"));
				tu.setUserId(rs.getLong("userid"));
				return tu;
			}
		});
	}

	@Override
	public List<Tutor> getPaginated(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
