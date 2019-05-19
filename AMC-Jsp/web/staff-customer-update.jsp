<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
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
		<div class="card-header">Update Customer</div>
		<div class="card-body">
			<form
				action="${pageContext.request.contextPath}/StaffServlet?action=update_customer&id=${editUser.userId}"
				method="post">
				
				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="userName" name="userName"
							class="form-control" placeholder="User name" required="required" value="${editUser.userName}">
						<label for="userName">User Name</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="password" id="password" name="password"
							class="form-control" placeholder="Password" required="required" value="${editUser.password}">
						<label for="password">Password</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="userfullname" name="name"
							class="form-control" placeholder="First Name" required="required" value="${editUser.name}">
						<label for="userfullname">First Name</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<select id="gender" name="gender" class="form-control"
							required="required">
							<option value="${editUser.gender}"></option>
							<option>Male</option>
							<option>Female</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="phone" name="phone" class="form-control"
							placeholder="Contact No" required="required" value="${editUser.phone}"> <label
							for="phone">Contact No</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="nic" name="nic" class="form-control"
							placeholder="NIC" required="required" value="${editUser.nic}"> <label for="nic">NIC</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="email" id="email" name="email" class="form-control"
							placeholder="Email address" required="required" value="${editUser.email}"> <label
							for="email">Email address</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input id="address" name="address" class="form-control"
							placeholder="Address" required="required" >"${editUser.address}">
						<label for="address">Address</label>
					</div>
				</div>

				

				<input type="submit" class="btn btn-primary btn-block"
					value="Update" />
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
