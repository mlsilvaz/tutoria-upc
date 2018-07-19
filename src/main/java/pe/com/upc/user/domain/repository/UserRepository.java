package pe.com.upc.user.domain.repository;

import java.util.List;

import pe.com.upc.user.domain.entity.User;

public interface UserRepository {
	public User save();
	public User getById(long userId);
	public User getByName(String name);
	public List<User> getPaginated(int page, int pageSize);
}
