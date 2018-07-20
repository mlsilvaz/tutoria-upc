package pe.com.upc.administrator.domain.repository;

import java.util.List;

import pe.com.upc.administrator.domain.entity.Tutor;
 

public interface TutorRepository  {
	
	public Boolean save(Tutor tutor)  ;
	public Tutor getById(long id);
	public Tutor getByName(String name, String lastName);
	public List<Tutor> getPaginated(int page, int pageSize);
	
	
	
	
}
