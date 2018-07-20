package pe.com.upc.administrator.domain.entity;

public class Course {

	private long id;
	private String name;
	private String state;

	public Course(long id, String name, String state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public Course() {

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
