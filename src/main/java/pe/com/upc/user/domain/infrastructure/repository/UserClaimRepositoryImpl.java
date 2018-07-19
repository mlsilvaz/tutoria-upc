package pe.com.upc.user.domain.infrastructure.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.upc.user.domain.entity.User;
import pe.com.upc.user.domain.entity.UserClaim;
import pe.com.upc.user.domain.repository.UserClaimRepository;
import pe.com.upc.user.domain.repository.UserRepository;

@Repository
public class UserClaimRepositoryImpl implements UserClaimRepository {

	private static final Logger log = LogManager.getLogger(UserClaimRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public List<UserClaim> findByUserId(Long userId) throws Exception {
		log.info("Into findByUserId(Long userId)");
		User user=UserRepository.getById(userId);
		String sql = "select user_claim_id, claim_type, claim_value,  user_id from user_claim   where  user_id = ?";
 			List<UserClaim> claims = jdbcTemplate.query(
					sql,
				    new Object[] {userId },
				    new RowMapper<UserClaim>() {
				        public UserClaim mapRow(ResultSet rs, int rowNum) throws SQLException {
				        	UserClaim claim = new UserClaim();
							claim.setId(rs.getLong(1));
							claim.setType(rs.getString(2));
							claim.setValue(rs.getString(3));
							claim.setUser(user);
							return claim;
				        }
				    });
 			return claims;
		}
		
	 
}
