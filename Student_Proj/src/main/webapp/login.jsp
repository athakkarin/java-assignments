<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      
   </head>
   		<body>
                  		<%
                  			if(request.getAttribute("msg")!=null)
                  			{
                  				out.println(request.getAttribute("msg"));
                  			}
                  		%>
                     <form action="UserController" method="post">
                        <fieldset>
                           <input type="email" placeholder="Enter Email" name="email" required />
                           <input type="text" placeholder="Enter mobile" name="mobile" required /> 
                           <input type="submit" name="action" value="Login"/>
                        </fieldset>
                     </form>
   </body>
</html>