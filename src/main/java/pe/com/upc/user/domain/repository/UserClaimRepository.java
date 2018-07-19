package pe.com.upc.user.domain.repository;

import java.util.List;

import pe.com.upc.user.domain.entity.UserClaim; 
public interface UserClaimRepository {
	public List<UserClaim> findByUserId(Long userId) throws Exception;
}
