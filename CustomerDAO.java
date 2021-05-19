public void addCustomer(Customer theCustomer) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("insert into customers"
                    + "(customerNumber,customerName,contactLastName,contactFirstName," +
                    "phone, addressLine1, addressLine2, city,state, postalCode, country," +
                    "salesRepEmployeeNumber, creditLimit)"

                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // set params
            myStmt.setInt(1, theCustomer.getCustomerNumber());
            myStmt.setString(2, theCustomer.getCustomerName());
            myStmt.setString(3, theCustomer.getContactLastName());
            myStmt.setString(4, theCustomer.getContactFirstName());
            myStmt.setString(5, theCustomer.getPhone());
            myStmt.setString(6, theCustomer.getAddressLine1());
            myStmt.setString(7, theCustomer.getAddressLine2());
            myStmt.setString(8, theCustomer.getCity());
            myStmt.setString(9, theCustomer.getState());
            myStmt.setString(10, theCustomer.getPostalCode());
            myStmt.setString(11, theCustomer.getCountry());
            myStmt.setInt(12, theCustomer.getSalesRepEmployeeNumber());
            myStmt.setBigDecimal(13, theCustomer.getCreditLimit());

            // execute SQL
            myStmt.executeUpdate();

        } finally {
            close(myStmt);
        }

    }
