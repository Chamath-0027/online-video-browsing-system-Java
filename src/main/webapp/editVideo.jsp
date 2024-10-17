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
	        <a class="navbar-brand" href="video.jsp">Online Video Browsing System</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ml-auto">
	                <% if(session.getAttribute("videoEmail")==null){ %>
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
		Video video = (Video) request.getAttribute("video");
		%>
<br>
<p></p>
		<main class="login-form">
	        <div class="row justify-content-center">
	            <div class="col-md-8">
	                <div class="card">
	                    <div class="card-header">Videos</div>
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
	                        <form action="updateVideo" method="post">
	                        	<input type="hidden" name="id" value="<%=video.getId() %>" >
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Title</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="title" class="form-control" name="title" value="<%=video.getTitle() %>" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Duration</label>
	                                <div class="col-md-6">
	                                    <input type="number" id="duration" class="form-control" name="duration" value="<%=video.getDuration() %>" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Description</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="description" class="form-control" name="description" value="<%=video.getDescription() %>" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Date</label>
	                                <div class="col-md-6">
	                                    <input type="date" id="date" class="form-control" name="date" value="<%=video.getDate() %>" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Category</label>
	                                <div class="col-md-6">
	                                    <select id="category_id" class="form-control" name="category_id" required>
	                                    <%
	                		CategoryService v = new CategoryService();
							ArrayList<Category> arrayList1 = v.getCategory();
							
							for (Category c : arrayList1) {
								
								
						%>
							<option value="<%=c.getId() %>"><%=c.getName() %></option>
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