package pe.com.upc.user.application.dto;

import java.util.List;

public class UserAuthDto {
	private long id;
	private String name;
	private String bearToken;
	private boolean isAuthenticated;
	private List<UserClaimDto> claims;
	
	public UserAuthDto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBearToken() {
		return bearToken;
	}

	public void setBearToken(String bearToken) {
		this.bearToken = bearToken;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public List<UserClaimDto> getClaims() {
		return claims;
	}

	public void setClaims(List<UserClaimDto> claims) {
		this.claims = claims;
	}
	

}
