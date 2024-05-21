<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>

    <jsp:include page="css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../assets/css/users.css">
</head>
<body>

<div class="container-fluid">
    <div id="signUp-form">

        <form action="/signup.do" method="post">

<%--            <div class="row mb-4">--%>
<%--                <label class="col form-label" for="name">Name</label>--%>
<%--                <input id="name" class="col form-control" type="text" name="name">--%>
<%--            </div>--%>

<%--            <div class="row mb-4">--%>
<%--                <label class="col form-label" for="family">Family</label>--%>
<%--                <input id="family" class="col form-control" type="text" name="family">--%>
<%--            </div>--%>

<%--            <div id="role-form">--%>
<%--                <label class="col form-label" for="role">Role</label>--%>
<%--                <select id="role">--%>
<%--                    <option>Person</option>--%>
<%--                    <option>Admin</option>--%>
<%--                </select>--%>
<%--            </div>--%>

            <div class="row mb-4">
                <label class="col form-label" for="username">Username</label>
                <input id="username" class="col form-control" type="text" name="username">
            </div>

            <div class="row mb-4">
                <label class="col form-label" for="password">Password</label>
                <input id="password" class="col form-control" type="password" name="password">
            </div>

            <div class="row mb-4">
                <input id="user-btn" type="submit" class="btn btn-primary" value="Save">
            </div>

        </form>


    </div>
</div>



<jsp:include page="js-import.jsp"></jsp:include>

</body>
</html>
