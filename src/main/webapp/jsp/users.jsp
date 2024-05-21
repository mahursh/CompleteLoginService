<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <jsp:include page="css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../assets/css/users.css">
</head>

<body>



    <div id="users-table">
        <table class="table table-hover table-primary">
            <thead>
            <tr>
                <th>id</th>
                <th>userName</th>
                <th>password</th>
                <th>personId</th>
                <th>roleId</th>
                <th>operations</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${sessionScope.userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.person}</td>
                    <td>${user.role}</td>

                    <td>
                        <button class="btn btn-warning" onclick="edit(${user.id})"><i class="fa fa-edit"></i>
                            Edit
                        </button>

                        <button class="btn btn-danger" onclick="remove(${user.id})"><i class="fa fa-remove"></i>
                            Remove
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>




<jsp:include page="js-import.jsp"></jsp:include>
<script src="../assets/js/users.js"></script>
</body>

</html>
