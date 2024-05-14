package mvc;

import java.util.List;

public class ShoppingBLL {
	public double calculateGST(int price, int gst, double ot, int ship_amt) {
		// Implement GST calculation logic
		double actual_price = (price) / (1 + (gst / 100));
		System.out.println("ap " + actual_price);
		double prod_gst = price - actual_price;
		System.out.println("pg " + prod_gst);
		double shipping_charges = (((actual_price) / ot) * ship_amt) * prod_gst;
		System.out.println("sc " + shipping_charges);
		return shipping_charges;
	}

	public double calculateGrandTotal(List<Double> prod_ship, double ot) {
		// TODO Auto-generated method stub
		double total = ot;
		for (int i = 0; i < prod_ship.size(); i++) {
			System.out.println("to " + total);
			total = total + prod_ship.get(i);
		}
		return total;
	}

	public double calculateShipping(double prod_price, double orderTotal, int shippingAmt) {
		double shipping =(prod_price/orderTotal)*shippingAmt;
		return shipping;
	}

	public double calculateGSTShipping(double shippingCharges, int gst) {
		// TODO Auto-generated method stub
		double gst_shipping=(gst/100)*shippingCharges;
		return gst_shipping;
	}
}