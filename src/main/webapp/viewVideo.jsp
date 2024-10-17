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
	        <a class="navbar-brand" href="user.jsp">Online Video Browsing System</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ml-auto">
	            <% if(session.getAttribute("userUsername")==null){ %>
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
		
<br>
<p></p>
		<main class="login-form">
	        <div class="row justify-content-center">
	            <div class="col-md-10">
	                <div class="card">
	                    <div class="card-header">All Video</div>
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
	                    <div class="p-1" id="VideoDiv">
	                    	<table class="table">
			                    <thead>
					                <tr>
					                    <th class="tableTh">ID</th>
					                    <th class="tableTh">Title</th>
					                    <th class="tableTh">Duration</th>
					                    <th class="tableTh">Description</th>
					                    <th class="tableTh">Category ID</th>
					                    <th class="tableTh">Edit</th>
					                    <th class="tableTh">Remove</th>
					                </tr>
				                </thead>
			                <tbody>
	                	<%
	                		VideoService us = new VideoService();
							ArrayList<Video> arrayList = us.getVideo();
							
							for (Video video : arrayList) {
								
								
						%><tr>
							<td class="tableTh"><%=video.getId() %></td>
							<td class="tableTh"><%=video.getTitle() %></td>
							<td class="tableTh"><%=video.getDuration() %></td>
							<td class="tableTh"><%=video.getDescription() %></td>
							<td class="tableTh"><%=video.getCategory_id() %></td>
							<td class="tableTh"><a class="btn btn-info" href="getVideos?id=<%=video.getId() %>" >Edit</a></td>
							<td class="tableTh"><Button class="btn btn-warning" id="<%=video.getId() %>" onclick="clickDelete(this);">Delete</Button></td>
						  </tr>
						<%
							}
						%>
						</tbody>
	            </table>
	            </div>
	                </div>
	            </div>
	        </div>
		</main>
	</div>

	
	<div style="display: none;" >
    	<form action="removeVideo" method="post" id="settingsForm">
			<input name="deleteId" id="removeId" required>
		</form>
    </div>

</body>
</html>
<script>
	
	function clickDelete(id){
		
		var r = confirm("If you want remove data ?");
		
		if (r == true) {
		  
			var did = id.id;
		
			document.getElementById("removeId").value = did;
			
			document.getElementById("settingsForm").submit();
			
		}
		
	}

</script>