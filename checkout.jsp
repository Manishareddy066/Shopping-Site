<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="mvc.ProductModel" %>
<%@ page import="mvc.OrderModel" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <style>
        /* Styles for the table */
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        /* Other styles */
        body {
            background-image: linear-gradient(to right, #ffbb33, #ff6f91);
        }

        .back-to-cart {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        .back-to-cart:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>Order Summary</h2>

    <table>
        <tr>
            <th>Product Name</th>
            <th>Product ID</th>
            <th>Price</th>
            <th>Order Total</th>
            <th>Shipping Charges</th>
            
            
        </tr>
        <% 
            List<OrderModel> orderDetails = (List<OrderModel>) request.getAttribute("orderDetails");
            if (orderDetails != null) {
                for (OrderModel orderModel : orderDetails) {
        %>
        <tr>
            <td><%= orderModel.getPm().getProd_name() %></td>
            <td><%= orderModel.getPm().getProd_ID() %></td>
            <td><%= orderModel.getPm().getProd_price() %></td>
            <td><%= orderModel.getOrderTotal() %></td>
            <td><%= orderModel.getShippingCharges() %></td>
         
           
        </tr>
        <% 
                }
            }
        %>
    </table>

    <a href="cart.jsp" class="back-to-cart">Back to Cart</a>
    <a href="payment.jsp" class="back-to-cart">Proceed To Payment</a>
</body>
</html>
