package mvc;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    ShoppingDAO sd;
    ShoppingBLL sb;

    public void init() {
        sd = new ServiceDAL();
        sb = new ShoppingBLL();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProductModel> cartItems = (List<ProductModel>) request.getSession().getAttribute("cartItems");
        List<OrderModel> orderDetails = new ArrayList<>();
        double orderTotal = 0.0;

        if (cartItems != null) {
            // Calculate order total for all items
            for (ProductModel item : cartItems) {
                orderTotal += item.getProd_price();
                
            }

            for (ProductModel item : cartItems) {
                // Create a new OrderModel for each item
                OrderModel orderModel = new OrderModel();
                orderModel.setPm(item);

                // Calculate shipping charges for each item
                double shippingCharges = sd.calShipping(item.getProd_price(), orderTotal);
                orderModel.setShippingCharges(shippingCharges);
             // Calculate GST on shipping charges for each item
                double gstShippingCharges = sd.calGstShipping(shippingCharges, item.getProd_hsn());
                orderModel.setGSTOnShippingCharges(gstShippingCharges);
                // Set the same order total for all items
                orderModel.setOrderTotal(orderTotal);

                // Add the orderModel to the list
                orderDetails.add(orderModel);
            }
        }

        // Set the list of order details in request attribute
        request.setAttribute("orderDetails", orderDetails);

        // Forward the request to checkout.jsp
        request.getRequestDispatcher("/checkout.jsp").forward(request, response);
    }
}
