<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/theme.css"/>
<title>World Adventures Airlines</title>
</head>
<body>
	<div class="container">
		<div class="title">Add a passanger</div>

         <%
             if(request.getAttribute("errors") != null){
          %>
            <fieldset>
                <legend>Errors</legend>
                <ul>
                	<% if(request.getAttribute("firstName error") != null) { %>
                	       <li>Empty first name field</li>
                	<% } %>
                </ul>
                <ul>
                	<% if(request.getAttribute("lastName error") != null) { %>
                	       <li>Empty last name field</li>    
                	<% } %>
                </ul>
                <ul>
                	<% if(request.getAttribute("date error") != null) { %>
                	       <li>Error in date field</li>
                	<% } %>
                </ul>
            </fieldset>
          <%
               }
           %>
		<fieldset class="fieldset">
			<legend align="center" class="legend">Passanger details</legend>
			<form action="AddPassanger" method="post" id="form1">
				<div class="inputField">
					<label for="first-name" class="inputLabel">First name:</label> <input
						name="first-name" type="text" />
				</div>

				<div class="inputField">
					<label for="last-name" class="inputLabel">Last name:</label> <input
						name="last-name" type="text" />
				</div>

				<div class="inputField">
					<label for="dob" class="inputLabel">Date of birth:</label> <input
						name="dob" type="text" />
				</div>

				<div class="inputField">
					<label for="gender" class="inputLabel">Gender:</label> <select
						name="gender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
			</form>
		</fieldset>

		<div class="inputField2" id="submitField">
			<input id="submitBtn" type="submit" form="form1"
				value="Add new passanger" />
		</div>

	</div>

</body>
</html>