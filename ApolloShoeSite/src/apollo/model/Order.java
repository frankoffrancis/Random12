package apollo.model;

public class Order {

	private Integer OrderID;
	private Integer orderQuantity;
	private Double subTotal;
	private Double price;
	private Integer shoe_ID;
	private Integer customer_ID;


	public Integer getShoe_ID() {
		return shoe_ID;
	}

	public void setShoe_ID(Integer shoe_ID) {
		this.shoe_ID = shoe_ID;
	}

	public Integer getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(Integer customer_ID) {
		this.customer_ID = customer_ID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal ;
	}
}
