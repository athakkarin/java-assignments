<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<!-- inner page section -->
      <section class="inner_page_head">
         <div class="container_fuild">
            <div class="row">
               <div class="col-md-12">
                  <div class="full">
                     <h3>Login</h3>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- end inner page section -->
      <!-- why section -->
      <section class="why_section layout_padding">
         <div class="container">
         
            <div class="row">
               <div class="col-lg-8 offset-lg-2">
                  <div class="full">
                  	 <b style="color: blue">
                 	 <%
                  		 if(request.getAttribute("msg") != null){
                  			 out.println(request.getAttribute("msg"));
                  		 }
                 	 
                 	 %>
                 	 </b>
                     <form action="UserController" method="post">
                        <fieldset>
                           <input type="email" placeholder="Enter Email Address" name="email" required />
                           <input type="password" placeholder="Enter Password" name="password" required />
                           <input type="submit" value="Login" />
                           <input type="button" value="Forgot Password" />
                        </fieldset>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- end why section -->
	</body>
</html>