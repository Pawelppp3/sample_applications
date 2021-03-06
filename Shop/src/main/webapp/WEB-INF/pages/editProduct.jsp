<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Edit</title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
    <tr>
        <td align="center"><h3>Edit product</h3></td>
    </tr>
    <tr valign="top" align="center">
        <td align="center">
            <form:form action="updateProduct.do" method="post" commandName="editProduct">
                <table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">

                    <form:input type="hidden" path="id"/>
                    <tr>
                        <td width="100" align="right">Name: </td>
                        <td width="150">
                            <input type="name" name="name" />
                        <td align="left">
                        </td>
                    </tr>
                    <tr>
                        <td>Categories: </td>
                        <td>
                            <form:select path="category">
                                <form:option value="NONE" label="--- Select ---"></form:option>
                                <form:options items="${categories}"></form:options>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Clothing: </td>
                        <td>
                            <form:select path="clothing">
                                <form:option value="NONE" label="--- Select ---"></form:option>
                                <form:options items="${clothings}"></form:options>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td width="100" align="right">Price: </td>
                        <td width="150">
                            <input type="price" name="price" />
                        <td align="left"/>
                    </tr>
                    <tr>
                        <td>Size: </td>
                        <td>
                            <form:select path="size">
                                <form:option value="NONE" label="--- Select ---"></form:option>
                                <form:options items="${sizes}"></form:options>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td width="100" align="right">QuantityAvailable: </td>
                        <td width="150">
                            <input type="quantityAvailable" name="quantityAvailable" />
                        <td align="left"/>
                    </tr>
                    <tr>
                        <td width="100" align="right">Description: </td>
                        <td width="200">
                            <input type="description" name="description" />
                        <td align="left"/>
                    </tr>
                    <tr valign="bottom">
                        <td colspan="3" align="center">
                            <input type="submit" name="" value="Save">
                            &nbsp;&nbsp;
                            <input type="button" value="Back" onclick="document.location.href='product.do'">
                        </td>
                    </tr>
                </table>
            </form:form>
        </td>
    </tr>
</table>
</body>
</html>