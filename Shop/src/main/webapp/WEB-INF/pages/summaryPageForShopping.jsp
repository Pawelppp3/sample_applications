<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>summary page for shopping</title>
</head>
<body>
<center>

    <h1>Thank you, ${login}, for shopping!</h1>

    <p>You have just bought ${counter} things:</p>

    <input type="button" value="Back" onclick="document.location.href='shopper.do'">
    <input type="button" value="Log out" onclick="document.location.href='logOut.do'">

    <table style="border-collapse: collapse;" border="1"
           bordercolor="#006699" width="700">
        <tr bgcolor="lightblue">

        <c:forEach var="inscription" items="${PRODUCT_CART}" varStatus="status">
            <tr>
                <td><c:out value="${inscription}"></c:out></td>

            </tr>
        </c:forEach>
        </tr>
    </table>

</center>
</body>
</html>
