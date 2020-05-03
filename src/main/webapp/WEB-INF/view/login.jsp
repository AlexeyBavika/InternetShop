<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login page</h1>
<h4 style="color:red">${errorMessage}</h4>
<form name="/login" method="post">
    Enter your login <input type="text" name="login">
    Enter your password <input type="password" name="password">
    <button type="submit">Login</button>
</form>
</body>
</html>
