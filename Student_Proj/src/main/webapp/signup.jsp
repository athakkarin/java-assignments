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
                           <input type="text" placeholder="Enter First Name" name="fname" required />
                           <input type="text" placeholder="Enter Last Name" name="lname" required />
                           <input type="email" placeholder="Enter Email" name="email" required />
                           <input type="text" placeholder="Enter Mobile" name="mobile" required />
                           <input type="submit" name="action" value="Sign Up" />
                        </fieldset>
                     </form>  
   </body>
</html>