package com.exam.OOPGroup14;

public class Employee {
	private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String jobTitle;
    private String officeCode;
    private String email;
    private int reportsTo;

    public Employee(int employeeNumber,String lastName,String firstName, String extension,String email,String officeCode,int reportsTo,String jobTitle) {
        super();
        this.employeeNumber=employeeNumber;
        this.lastName=lastName;
        this.firstName=firstName;
        this.extension=extension;
        this.jobTitle=jobTitle;
        this.email=email;
        this.reportsTo=reportsTo;
        this.officeCode=officeCode;
    }
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int id) {
        this.employeeNumber = id;
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
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getOfficeCode() {
        return officeCode;
    }


    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
    public int getReportto() {
        return reportsTo;
    }

    public void setReportto(int reportsTo) {
        this.reportsTo = reportsTo;
    }
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
   @Override
   public String toString() {
		return String.format("Employee[ EmployeeNumber: " + this.getEmployeeNumber() + ", lastName: " + this.getLastName() + ", firstName: " + this.getFirstName() + ", extension: " + this.getExtension() + ", email: " + this.getEmail() + ", officeCode: " + this.getOfficeCode()  +   ", reportsTo: " + this.getReportto()+ ", jobTitle: " + this.getJobTitle());
		
	}


}
