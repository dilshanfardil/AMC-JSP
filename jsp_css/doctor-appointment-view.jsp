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

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="doctor-dashboard.jsp">Dashboard</a>



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
						href="${pageContext.request.contextPath}/LoginServlet?action=load_profile">Edit
						Profile</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/LoginServlet?action=logout">Logout</a>
				</div></li>
		</ul>

	</nav>


	<!-- Sidebar -->


	<div id="content-wrapper">

		<div class="container-fluid">



			<!--DataTables Example-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> Appointments
				</div>
				<div class="card-body">
					<div>
						<table class="table table-bordered" id="dataTable"
							style="overflow-x: auto; width: 100%; cellspacing: 0">
							<thead>
								<tr>

									<th>App ID</th>
									<th>Customer ID</th>
									<th>Date</th>
									<th>Medicine</th>
									<th>Feedback</th>
									<th>Charge</th>
									<th>Comment</th>
									<th>Is Paid</th>
									<th>Action</th>
								
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>App ID</th>
									<th>Customer ID</th>
									<th>Date</th>
									<th>Medicine</th>
									<th>Feedback</th>
									<th>Charge</th>
									<th>Comment</th>
									<th>Is Paid</th>
									<th>Action</th>


								</tr>
							</tfoot>

							<c:forEach items="${list}" var="appointment">

								<tr>
									<td>${appointment.appointmentId}</td>
									<td>${appointment.customerId}</td>
									<td>${appointment.date}</td>
									<td>${appointment.medicine}</td>
									<td>${appointment.feedback}</td>
									<td>${appointment.charge}</td>
									<td>${appointment.comment}</td>
									<td>${appointment.isPaid}</td>


									<td><a
										href="${pageContext.request.contextPath}/DoctorServlet?action=load_appointment&id=${appointment.appointmentId}"
										class="btn btn-primary">Edit</a></td>
								</tr>

							</c:forEach>
							<tbody>

							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>

		</div>


	</div>


	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="js/demo/datatables-demo.js"></script>
	<script src="js/demo/chart-area-demo.js"></script>

</body>

</html>
