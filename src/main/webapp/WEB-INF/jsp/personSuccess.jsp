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
    <h2>Person entity created success</h2>
    <%--@elvariable id="person" type="edu.avo.hillel_j2ee_hw_06.model.Person"--%>
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${person.id}</td>
            </tr>
            <tr>
                <td>First name: </td>
                <td>${person.firstName}</td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td>${person.lastName}</td>
            </tr>
            <tr>
                <td>E-Mail: </td>
                <td>${person.email}</td>
            </tr>
        </table>

    <br/>
    <a href="/">Main menu</a>
</div>


</body>
</html>