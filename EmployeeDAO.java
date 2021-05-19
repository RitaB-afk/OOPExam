public static void addEmployee(Employee anEmployee) throws Exception{
        PreparedStatement myStmt= null;

        try {
            //prepare statement
            myStmt = myConn.prepareStatement("insert into employees"
                    + " (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)" + "values (?,?,?,?,?,?,?,?)");


            //set params
            myStmt.setInt(1, anEmployee.getEmployeeNumber());
            myStmt.setString(2, anEmployee.getLastName());
            myStmt.setString(3, anEmployee.getFirstName());
            myStmt.setString(4, anEmployee.getExtension());
            myStmt.setString(5, anEmployee.getEmail());
            myStmt.setString(6, anEmployee.getOfficeCode());
            myStmt.setInt(7, anEmployee.getReportto());
            myStmt.setString(8, anEmployee.getJobTitle());

            //execute SQL
            myStmt.executeUpdate();
        }
        finally {
            close(myStmt);
            }
			}
			
