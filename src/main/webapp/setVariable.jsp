<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" language="java" %>
<jsp:useBean id="variableBean" class="com.example.demo1.VariableBean" scope="session"/>
<jsp:setProperty name="variableBean" property="message" param="message"/>
<!DOCTYPE html>
<html>
<head>
    <title>Set Variable</title>
</head>
<body>
<h1>Message Set</h1>
<p>The new message has been set to: <strong><jsp:getProperty name="variableBean" property="message" /></strong></p>
<br/>
<a href="index.jsp">Back to Input Form</a>
</body>
</html>
