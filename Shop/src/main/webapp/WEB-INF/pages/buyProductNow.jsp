<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Hello in Clothing Shop:</title>
</head>
<body>
<center>

    <h1>Hello ${login} in Clothing Shop: </h1>

    <p>Quantity of products in your shopping cart: ${basket.size}</p>

    <input type="button" value="Log out" onclick="document.location.href='logOut.do'">

    <input type="button" value="Search product" onclick="document.location.href='searchProductForm.do'">

    <input type="button" value="Back" onclick="document.location.href='shopper.do'">

    <input type="button" value="Buy now" onclick="document.location.href='buyNow.do'">

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
        <c:forEach var="product" items="${BUYED_PRODUCT}" varStatus="status">
            <tr>
                <td><c:out value="${status.index+1}"></c:out></td>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.category}"></c:out></td>
                <td><c:out value="${product.clothing}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td><c:out value="${product.size}"></c:out></td>
                <td><c:out value="${product.quantityAvailable}"></c:out></td>
                <td><c:out value="${product.description}"></c:out></td>

                <td>
                    &nbsp;&nbsp;<a href="deleteProductFromCart.do?id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>