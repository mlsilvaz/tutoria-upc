package pe.com.upc.user.application;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import pe.com.upc.user.application.dto.UserAuthDto;
import pe.com.upc.user.application.dto.UserClaimDto;
import pe.com.upc.user.application.dto.UserDto;
import pe.com.upc.user.domain.entity.User;
import pe.com.upc.user.domain.entity.UserClaim;
import pe.com.upc.user.domain.repository.UserRepository;
import pe.com.upc.user.domain.repository.UserClaimRepository;

@Service
public class UserApplicationService {
	private static final Logger log = LogManager.getLogger(UserApplicationService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserClaimRepository userClaimRepository;
	
	
	public UserAuthDto validateUser(UserDto userDto) throws Exception {
		log.info("Into validateUser()");
		User user=userRepository.getByName(userDto.getName());
		UserAuthDto userAuth= new UserAuthDto();
		if(user==null)
			return userAuth;
		if(!userDto.getPassword().equals(user.getPassword()))
			return userAuth;
		userAuth=this.builderUserAuthDto(user); 
		return userAuth;
	}
	private UserAuthDto builderUserAuthDto(User user) throws Exception {
		log.info("Into builderUserAuthDto(User user)");
		UserAuthDto userAuth= new UserAuthDto();
		userAuth.setId(user.getId());
		userAuth.setName(user.getName());
		userAuth.setAuthenticated(true);
		userAuth.setBearToken(new UUID(0L, 0L).toString());
		userAuth.setClaims(this.getUserClaims(user));
		
		return userAuth;
	}
	private List<UserClaimDto> getUserClaims(User authUser) throws Exception  {
		log.info("Into getUserClaims(User authUser)");
		List<UserClaim>  claims=userClaimRepository.findByUserId(authUser.getId());
		return this.builderClaimsDto(claims);
	}
	
	private List<UserClaimDto> builderClaimsDto(List<UserClaim> claims){
		log.info("Into builderClaimsDto()");
		List<UserClaimDto> claimsDto = new ArrayList<>();
		for (UserClaim uc : claims) {
			UserClaimDto ucd = new UserClaimDto();
			ucd.setId(uc.getId());
			ucd.setType(uc.getType());
			ucd.setValue(uc.getValue());
			claimsDto.add(ucd);
		}
		return claimsDto;
	}
}


