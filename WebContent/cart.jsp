<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h3>Here is your shopping Cart</h3>

	<%
		ArrayList<String> cartCaketype = (ArrayList<String>) session.getAttribute("cartCaketype");
		String qty[] = (String[]) session.getAttribute("cartQty");

		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		//for(String ct: qty){
		//	System.out.println(ct+"2");
		//}
		if (cartCaketype != null) {
			int i = 0, j = 0;
			for (String ct : cartCaketype) {
				System.out.println(ct);
	%>
	<li><%=cartCaketype.get(i)%> :</li>
	<%
		i++;
				while (Integer.parseInt(qty[j]) == 0) {
					j++;
				}
	%>
	<li><%=qty[j]%> :</li>

	<a href="login.html"><input id="wishList" type="submit"
		value="Save in WishList" /></a>

	<%
		}
		} else {
			if (userName == null) {
	%>
	<div class="alert alert-danger" role="alert">
		<strong>Oh oops!</strong> Your Cart is Empty!
		<hr>
		<a href="index.html">Back to Home Page.</a>
	</div>
	</form>
	<%
		} else {
	%>
	<div class="alert alert-danger" role="alert">
		<strong>Oh oops!</strong> Your Cart is Empty!
		<hr>
		<a href="cart.html">Back to Home Page.</a>
	</div>
	<%
		}
		}
	%>


</body>
</html>