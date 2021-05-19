public static void addOrder(Order anOrder) throws Exception{
             PreparedStatement myStmt= null;

        try {
            //prepare statement
            myStmt = myConn.prepareStatement("insert into orders"
                    + " (orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber)" + "values (?,?,?,?,?,?,?)");


            //set params
            myStmt.setInt(1, anOrder.getOrderNumber());
            myStmt.setString(2, anOrder.getOrderdate());
            myStmt.setString(3, anOrder.getRequiredDate());
            myStmt.setString(4, anOrder.getShippedDate());
            myStmt.setString(5, anOrder.getStatus());
            myStmt.setString(6, anOrder.getComments());
            myStmt.setInt(7, anOrder.getCustomerNumber());
           

            //execute SQL
            myStmt.executeUpdate();
        }
        finally {
            close(myStmt);
            }
