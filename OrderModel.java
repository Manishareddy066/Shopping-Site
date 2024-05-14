package mvc;

public class OrderModel {
	private String orderId;
	private String orderDate;
	private double orderTotal;
	private double totalGSTOnProducts;
	private double shippingCharges;
	
	private double GSTOnShippingCharges;
	private double grandTotal;
	private ProductModel pm;
	// Constructor
	// public OrderModel(String orderId, String orderDate, double orderTotal) {
	// this.orderId = orderId;
	// this.orderDate = orderDate;
	// this.orderTotal = orderTotal;
	// }

	// Getters and setters
	public ProductModel getPm() {
		return pm;
	}

	public void setPm(ProductModel pm) {
		this.pm = pm;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getTotalGSTOnProducts() {
		return totalGSTOnProducts;
	}

	public void setTotalGSTOnProducts(double totalGSTOnProducts) {
		this.totalGSTOnProducts = totalGSTOnProducts;
	}

	public double getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	public double getGSTOnShippingCharges() {
		return GSTOnShippingCharges;
	}

	public void setGSTOnShippingCharges(double GSTOnShippingCharges) {
		this.GSTOnShippingCharges = GSTOnShippingCharges;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

}