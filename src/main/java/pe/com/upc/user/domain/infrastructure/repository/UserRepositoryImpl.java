package pe.com.upc.user.domain.infrastructure.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.upc.user.domain.entity.User;
import pe.com.upc.user.domain.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(long userId) {
		String sql = "select u.user_id, u.user_name, u.password from user u where u.user_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { userId }, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rownum) throws SQLException {
				User emp = new User();
				emp.setId(rs.getLong("user_id"));
				emp.setName(rs.getString("user_name"));
				emp.setPassword(rs.getString("password"));
				return emp;
			}
		}); 
	}

	@Override
	public User getByName(String name) {
		String sql = "select u.user_id, u.user_name, u.password from user u where u.user_name = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rownum) throws SQLException {
				User emp = new User();
				emp.setId(rs.getLong("user_id"));
				emp.setName(rs.getString("user_name"));
				emp.setPassword(rs.getString("password"));
				return emp;
			}
		});
	}

	@Override
	public List<User> getPaginated(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
