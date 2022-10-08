<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person list</title>
</head>
<body>
<%--<h1>Welcome</h1>--%>
<h2>${message}</h2>
<%--<a href="${pageContext.request.contextPath}/personList">Person List</a>--%>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach  items="${persons}" var ="person">
            <tr>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>