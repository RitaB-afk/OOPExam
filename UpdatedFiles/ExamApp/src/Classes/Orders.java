package Classes;

import java.util.Date;


	public class Orders {
		
	    private final int orderNumber;
	    private String orderDate;
	    private String requiredDate;
	    private String shippedDate;
	    private String status;
	    private String comments;
	    private final int customerNumber;

    public Orders(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
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
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    @Override
    public String toString() {
		return String.format("Order[ OrderNumber: " + this.getOrderNumber() + ", OrderDate: " + this.getOrderDate() + ", Required Date: " + this.getRequiredDate() + ", Shipped Date: " + this.getShippedDate() + ", Status: " + this.getStatus() + ", Comments: " + this.getComments()  +   ", CustomerNumber: " + this.getCustomerNumber());
		
	}
}
