<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Search product</title>
</head>
<body>
	<center>

		<h2>${login} Your search product</h2>

		<p>Quantity of products in your shopping cart: ${basket.size}</p>

		<input type="button" value="Log out"
			onclick="document.location.href='logOut.do'">
		<input
			type="button" value="Back"
			onclick="document.location.href='searchProductForm.do'">

		<input
				type="button" value="Go to Shop"
				onclick="document.location.href='shopper.do'">

		<table style="border-collapse: collapse;" border="1"
			   bordercolor="#006699" width="700">

			<tr bgcolor="lightblue">
				<th>Lp</th>
				<th>Name</th>
				<th>Category</th>
				<th>Clothing</th>
				<th>Price</th>
				<th>Size</th>
				<th>QuantityAvailable</th>
				<th>Description</th>

			</tr>

			<c:choose>
				<c:when test="${not empty searchedProduct}">
					<tr>
					<td><c:out value="${status.index+1}"></c:out></td>

					<td><c:out value="${searchedProduct.name}"></c:out></td>

						<td><c:out value="${searchedProduct.category}"></c:out></td>

						<td><c:out value="${searchedProduct.clothing}"></c:out></td>

						<td><c:out value="${searchedProduct.price}"></c:out></td>

						<td><c:out value="${searchedProduct.size}"></c:out></td>

						<td><c:out value="${searchedProduct.quantityAvailable}"></c:out></td>

						<td><c:out value="${searchedProduct.description}"></c:out></td>

						<td>
							&nbsp;&nbsp;<a href="BuyR.do?id=${searchedProduct.id}">Buy</a>
						</td>

					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<c:out value="No search results"></c:out>
					</tr>
				</c:otherwise>
			</c:choose>

		</table>

	</center>
</body>
</html>