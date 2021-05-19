package com.exam.OOPGroup14;

	
	public class Order {
	    private int orderNumber;
	    private String orderDate;
	    private String requiredDate;
	    private String shippedDate;
	    private String status;
	    private String comments;
	    private int customerNumber;

	    public Order (int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber){
	        super();
	        this.orderNumber=orderNumber;
	        this.orderDate= orderDate;
	        this.requiredDate= requiredDate;
	        this.shippedDate= shippedDate;
	        this.status=status;
	        this.comments=comments;
	        this.customerNumber=customerNumber;

	    }
	    public int getOrderNumber() {
	        return orderNumber;
	    }

	    public void setOrderNumber(int orderNumber) {
	        this.orderNumber=orderNumber;
	    }

	    public String getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(String orderDate) {
	        this.orderDate= orderDate;
	    }

	    public String getRequiredDate() {
	        return requiredDate;
	    }

	    public void setRequiredDate (String requiredDate) {
	        this.requiredDate= requiredDate;
	    }

	    public String getShippedDate() {
	        return shippedDate;
	    }

	    public void setShippedDate(String shippedDate) {
	        this.shippedDate = shippedDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status=status;
	    }

	    public String getComments() {
	        return comments;
	    }
	    public void setComments(String comments){
	        this.comments=comments;

	    }
	    public int getCustomerNumber() {
	    	return customerNumber;
	    	
	    }
	    
	    public void setCustomerNumber(int customerNumber) {
	    	this.customerNumber= customerNumber;
	    }
	    
	    @Override
	    public String toString() {
			return String.format("Order[ OrderNumber: " + this.getOrderNumber() + ", OrderDate: " + this.getOrderDate() + ", Required Date: " + this.getRequiredDate() + ", Shipped Date: " + this.getShippedDate() + ", Status: " + this.getStatus() + ", Comments: " + this.getComments()  +   ", CustomerNumber: " + this.getCustomerNumber());
			
		}


	}
