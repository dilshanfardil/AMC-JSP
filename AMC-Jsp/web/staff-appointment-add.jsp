<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>AMC</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body style="background-color: aliceblue">

	<!--nav bar-->
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="staff-dashboard.jsp">Dashboard</a>



		<!-- Navbar -->
		<ul class="nav navbar-nav navbar-right" style="margin-left: 1050px">

			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">

					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/LoginServlet?action=logout">Logout</a>
				</div></li>
		</ul>

	</nav>

	<!--div class="container"-->
	<div class="card card-register mx-auto mt-5">
		<div class="card-header">Add Appointment</div>
		<div class="card-body">
			<form
				action="${pageContext.request.contextPath}/StaffServlet?action=add_appointment"
				method="post">
				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="appId" name="appointmentId"
							class="form-control" placeholder="Appointmet Id"
							required="required" autofocus="autofocus"> <label
							for="appId">Appointment Id</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<select id="cusId" name="customerId" class="form-control"
							required="required">
							<option>Select Customer</option>
							<c:forEach items="${cusList}" var="custId">
								<option value="${custId}">${custId}</option>
							</c:forEach>

						</select>
					</div>
				</div>
				
				<div class="form-group">
					<div class="form-label-group">
						<select id="docId" name="doctorId" class="form-control"
							required="required">
							<option>Select Doctor</option>
							<c:forEach items="${docList}" var="doctId">
								<option value="${doctId}">${doctId}</option>
							</c:forEach>

						</select>
					</div>
				</div>
				
				

				<div class="form-group">
					<div class="form-label-group">
						<input type="date" id="date" name="date"
							class="form-control" placeholder="Date" required="required">
						<label for="date">Date : YYYY-MM-DD</label>
					</div>
				</div>

				<input type="submit" class="btn btn-primary btn-block"
					value="Add Appointment" />
			</form>

		</div>
	</div>
	<!--/div-->

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
