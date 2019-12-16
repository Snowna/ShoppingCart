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
		String caketypes[] = request.getParameterValues("caketype");
		String qty[] = request.getParameterValues("qty");

		ArrayList<String> cartCaketype = (ArrayList<String>) session.getAttribute("cartCaketype");
		ArrayList<String> cartQty = (ArrayList<String>) session.getAttribute("cartQty");

		if (cartCaketype == null) {
			cartCaketype = new ArrayList<String>();
		}
		if (cartQty == null) {
			cartQty = new ArrayList<String>();
		}
		if (caketypes != null) {
			for (String caketype : caketypes) {
				cartCaketype.add(caketype);
			}

			for (String st : qty) {
				//System.out.println(st);
				cartQty.add(st);

			}

			//System.out.println(qty.length + "size");

			session.setAttribute("cartCaketype", cartCaketype);
			session.setAttribute("cartqty", qty);

			for (int i = 0, j = 0; i < caketypes.length; i++) {
				//System.out.println(caketypes[i]);
	%>
	<li><%=caketypes[i]%> :</li>
	<%
		while (Integer.parseInt(qty[j]) == 0) {
					j++;
				}
	%>
	<li><%=qty[j]%> :</li>
	<a href="login.html"><input id="wishList" type="submit"
		value="Save in WishList" /></a>

	<%
		j++;
				//}else continue;
			}
		} else {
	%>
	<div class="alert alert-danger" role="alert">
		<strong>Oh oops!</strong> Your Cart is Empty!
		<hr>
		<a href="index.html">Back to Home Page.</a>
	</div>
	<%
		}
	%>

</body>
</html>