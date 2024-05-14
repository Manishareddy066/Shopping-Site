<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>Payment</title>
<style>
#PaymentType{
margin-top:10px;
margin-left:120px;
margin-bottom:300px;
margin-right:90px;
border: 1px solid #ccc;
padding-top:50px;
padding-bottom:60px;
padding-left:100px;
}
 body {
            font-family: Arial, sans-serif;
            background-image: linear-gradient(to right, #ffbb33, #ff6f91);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
</style>
</head>

<body>
<form method="GET" id="PaymentType">
    <label><b>Mode Of Payment:</b></label>
    <select class="btn btn-outline-dark" style="margin-right:40px;" name="category" id="PaymentSelect">
        <option value="">Choose Payment Type</option>
        <option value="cod">Cash On Delivery</option>
        <option value="razorpay">Online Payment</option>
    </select>
</form> 

<!-- Razorpay form -->
<div id="razorpayForm" style="display: none;">
    <form action="https://www.example.com/payment/success/" method="POST">
        <script
            src="https://checkout.razorpay.com/v1/checkout.js"
            data-key="rzp_test_GQJFfgO4pfnpIS"
            data-amount="29935"
            data-currency="INR"
            data-order_id="order_CgmcjRh9ti2lP7"
            data-buttontext="Pay with Razorpay"
            data-name="Acme Corp"
            data-image="https://example.com/your_logo.jpg"
            data-prefill.name="Manisha Reddy"
            data-prefill.email="manisha.reddy@gmail.com"
            data-theme.color="#F37254"
        ></script>
        <input type="hidden" custom="Hidden Element" name="hidden"/>
    </form>
</div>

<script>
    document.getElementById('PaymentSelect').addEventListener('change', function() {
        var selectedOption = this.value;
        if (selectedOption === 'razorpay') {
            document.getElementById('razorpayForm').style.display = 'block';
        } else {
            document.getElementById('razorpayForm').style.display = 'none';
        }
    });
</script>

</body>
</html>