package data;

public class WritePojoToJson {

	private String employeeName;
	private String city;
	private String department;
	private String designation;
	
	public WritePojoToJson()
	{
		super();
	}

	public WritePojoToJson(String employeeName, String city, String department, String designation) {
		this.employeeName = employeeName;
		this.city = city;
		this.department = department;
		this.designation = designation;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getCity() {
		return city;
	}

	public String getDepartment() {
		return department;
	}

	public String getDesignation() {
		return designation;
	}
	
	
	
	
}
