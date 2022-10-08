<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person new</title>
</head>
<body>
<%--<h1>Welcome</h1>--%>
<%--<h2>${message}</h2>--%>
<%--<a href="${pageContext.request.contextPath}/personList">Person List</a>--%>

<br/><br/>
<div align="center">
    <h2>New Person</h2>
    <%--@elvariable id="personDTO" type="personDTO"--%>
    <form:form action="savePerson" method="post" modelAttribute="personDTO">
        <table border="0" cellpadding="5">
            <tr>
                <td>First name: </td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>E-Mail: </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
<%--                <form:button>Register</form:button>--%>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>