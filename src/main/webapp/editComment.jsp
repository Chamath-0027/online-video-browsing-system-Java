<%@page import="Model.*"%>
<%@page import="Service.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Online Video Browsing System</title>
	
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/croppie.js"></script>
    <link rel="stylesheet" href="assets/css/croppie.css" />

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <script src="assets/js/sweetalert.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
	<style type="text/css">
        .my-error-class {
            color:red;
        }
        .my-valid-class {
            color:green;
        }
    </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
    	<div class="container">
	        <a class="navbar-brand" href="comment.jsp">Online Video Browsing System</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ml-auto">
	                <% if(session.getAttribute("commentEmail")==null){ %>
	                <li class="nav-item">
	                    <a class="nav-link" href="login.jsp">Login</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="register.jsp">Register</a>
	                </li>
	                <%}else{ %>
	                <li class="nav-item">
	                    <a class="nav-link" href="logoutServlet">Logout</a>
	                </li>
	                <%} %>
	            </ul>
	
	        </div>
        </div>
	</nav>
    <div class="container">
		<%
		Comment comment = (Comment) request.getAttribute("comment");
		%>
<br>
<p></p>
		<main class="login-form">
	        <div class="row justify-content-center">
	            <div class="col-md-8">
	                <div class="card">
	                    <div class="card-header">Comments</div>
	                    <div class="card-body">
	                    <%
							if(request.getAttribute("errors_success")!=null){
								if(request.getAttribute("errors_success").equals(1)){
									%>	<div class="alert alert-success">
										  Successful!
										</div>	<%
								}else{
									%>	<div class="alert alert-danger">
										  Unsuccessful!
										</div>	<%
								}
							}
						%>
	                        <form action="updateComment" method="post">
	                        	<input type="hidden" name="id" value="<%=comment.getId() %>" >
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Comment</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="text" class="form-control" name="text" value="<%=comment.getText() %>" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Date</label>
	                                <div class="col-md-6">
	                                    <input type="date" id="date" class="form-control" name="date" value="<%=comment.getDate() %>" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">User</label>
	                                <div class="col-md-6">
	                                    <select id="user_id" class="form-control" name="user_id" required>
	                                    <%
	                		UserService us = new UserService();
							ArrayList<User> arrayList = us.getUsers();
							
							for (User users : arrayList) {
								
								
						%>
							<option value="<%=users.getId() %>"><%=users.getName() %></option>
							<%
							}
						%>
	                                    </select>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Video</label>
	                                <div class="col-md-6">
	                                    <select id="video_id" class="form-control" name="video_id" required>
	                                    <%
	                		VideoService v = new VideoService();
							ArrayList<Video> arrayList1 = v.getVideo();
							
							for (Video video : arrayList1) {
								
								
						%>
							<option value="<%=video.getId() %>"><%=video.getTitle() %></option>
							<%
							}
						%>
	                                    </select>
	                                </div>
	                            </div>
	                            
	                            <div class="col-md-6 offset-md-4">
	                                <button type="submit" class="btn btn-primary">
	                                    Edit
	                                </button>
	                            </div>
	                    	</form>
	                    </div>
	                </div>
	            </div>
	        </div>
		</main>
	</div>

</body>
</html>