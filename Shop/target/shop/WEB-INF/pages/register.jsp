<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Add new product </title>
</head>
<body style="font-family: Arial; font-size:smaller">
<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
    <tr>
        <td align="center"><h2>Register page:</h2></td>
    </tr>
    <tr valign="top" align="center">
        <td align="center">
            <form:form action="register.do" method="post" commandName="newShopper">

                <table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">
                    <tr>
                        <td width="100" align="right">Name: </td>
                        <td width="150">
                            <input type="name" name="name" />
                        <td align="left"/>
                    </tr>
                    <tr>
                        <td width="100" align="right">Surname: </td>
                        <td width="150">
                            <input type="surname" name="surname" />
                        <td align="left"/>
                    </tr>
                    <tr>
                        <td width="100" align="right">Login: </td>
                        <td width="150">
                            <input type="login" name="login" />
                        <td align="left"/>
                    </tr>
                    <tr>
                        <td width="100" align="right">Password: </td>
                        <td width="200">
                            <input type="password" name="password" />
                        <td align="left"/>
                    </tr>

                    <tr>
                        <td colspan="3" align="center">
                            <input type="submit" name="" value="Save">
                            &nbsp;&nbsp;
                            <input type="reset" name="" value="Reset">
                            &nbsp;&nbsp;
                            <input type="button" value="Back" onclick="document.location.href='newLogin.do'">
                        </td>
                    </tr>
                </table>
            </form:form>
        </td>
    </tr>
</table>
</body>
</html>