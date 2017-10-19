<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Log In page</title>
</head>
<body style="font-family: Arial; font-size:smaller;">
<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
    <tr>
        <td align="center"><h3>Log In</h3></td>
    </tr>

    <tr valign="top" align="center">
        <td align="center">
            <form:form method="post" action="login.do">

                <table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">
                    <tr>
                        <td width="100" align="right">Login</td>
                        <td width="150">
                            <input type="text" name="login" />
                        <td align="left"/>
                    </tr>

                    <tr>
                        <td width="100" align="right">Password</td>
                        <td width="150">
                            <input type="password" name="password" />
                        <td align="left"/>
                    </tr>
                    <tr>
                        <td colspan="3" align="center">
                            <input type="submit" name="" value="Log In">
                            &nbsp;&nbsp;
                            <input type="button" value="Create a New Account" onclick="document.location.href='newShopperForm.do'">
                        </td>
                    </tr>
                </table>
            </form:form>
        </td>
    </tr>
</table>
</body>

</html>



