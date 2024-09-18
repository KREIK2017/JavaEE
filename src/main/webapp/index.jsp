<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" language="java"%>
<jsp:useBean id="dateBean" class="com.example.demo1.DateBean" scope="page"/>
<jsp:useBean id="variableBean" class="com.example.demo1.VariableBean" scope="session"/>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello World!</h1>
<br/>
<%--<a href="first-servlet">Go to First Servlet</a>--%>
<%--<br/>--%>
<%--<a href="second-servlet">Go to Second Servlet</a>--%>
<%--<br/>--%>
<%--<a href="third-servlet">Go to Third Servlet</a>--%>
<%--<br/>--%>
<%--<a href="fourth-servlet">Go to Fourth Servlet</a>--%>

<h1>Current Date and Time</h1>
<p>The current date and time is: <strong><jsp:getProperty name="dateBean" property="currentDate" /></strong></p>

<h1>Set and Get Variable</h1>

<!-- Display current value -->
<p>Current value of message: <strong><jsp:getProperty name="variableBean" property="message" /></strong></p>

<!-- Form for setting new value -->
<form action="setVariable.jsp" method="post">
  <label for="message">Enter new message:</label>
  <input type="text" id="message" name="message">
  <input type="submit" value="Submit">
</form>
</body>
</html>
