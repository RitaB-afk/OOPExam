package Classes;

public class Employee{

	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;

	public Employee(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, int reportsTo, String jobTitle){
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
	}


	public int getEmployeeNumber() {
		return employeeNumber;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String toString() {
		return String.format("Employee[ EmployeeNumber: " + this.getEmployeeNumber() + ", lastName: " + this.getLastName() + ", firstName: " + this.getFirstName() + ", extension: " + this.getExtension() + ", email: " + this.getEmail() + ", officeCode: " + this.getOfficeCode()  +   ", reportsTo: " + this.getReportsTo()+ ", jobTitle: " + this.getJobTitle());
		
	}

}