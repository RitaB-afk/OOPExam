package db;

public class Employee {
	
	private int employeeNumber;
	private int reportsTo;
	private String lastName, firstName, extention, email, officeCode, jobTitle;


	public Employee(int empoyeeNumber, String lastName, String firstName, String jobTitle, String extention, String email, String officeCode, int reportsTo, int employeeNumber) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.jobTitle = jobTitle;
		this.extention = extention;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
	}
	
	public int getempolyeeNumber() {
		return employeeNumber;
	}
	
	public void setemployeeNumber(int emplyeeNumber, int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getjobTitle() {
		return jobTitle;
	}

	public void setjobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getextention() {
		return extention;
	}

	public void setextention(String extention) {
		this.extention = extention;
	}
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getofficeCode() {
		return officeCode;
	}
	
	public void setofficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	public int getreportsTo() {
		return reportsTo;
	}
	
	public void setreportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	

}