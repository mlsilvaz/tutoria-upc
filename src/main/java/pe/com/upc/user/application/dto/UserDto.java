package pe.com.upc.user.application.dto;

import java.util.Set;

public class UserDto {
	private long id;
	private String name;
	private String password;
	private Set<UserClaimDto> claims;
	
	public UserDto() {
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserClaimDto> getClaims() {
		return claims;
	}

	public void setClaims(Set<UserClaimDto> claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", password=" + password + ", claims=" + claims + "]";
	} 
	
	
	
}
