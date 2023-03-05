<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="public/bootstrap.min.css">
<link rel="stylesheet" href="public/bootstrap.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.html" />
	<div class="container">
		<div class="row">
			<div class="col-6 mt-4">
			   <p>ESPACE STUDENTS</p>
				<form action="student.do" method="post">
				   <div class="form-group">
						<label for="firstname">Firstname:</label> <input type="text" class="form-control" id="firstname" name="firstname">
					</div>
					<div class="form-group">
						<label for="lastname">Lastname:</label> <input type="text" class="form-control" id="lastname" name="lastname">
					</div>
					<div class="form-group">
						<label for="birthdate">Birthdate:</label> <input type="date" class="form-control" id="birthdate" name="birthdate">
					</div>
					<div class="form-group">
						<label for="phone">Phone:</label> <input type="text" class="form-control" id="phone" name="phone">
					</div>
					<div></div>
					<div class="form-group">
						<button type="submit" class="btn btn-info" name="action" value="Enregistrer">Enregistrer</button>
					</div>
				</form>
			</div>
			<div class="col-6 mt-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="card text-white bg-info mb-3" style="max-width: 20rem;" align="center">
							<div class="card-header" align="center">STUDENTS</div>
						</div>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-hover   table-bordered">
							<thead>
								<tr class="table-warning">
									<th>#</th>
									<th>Fistname</th>
									<th>Lastname</th>
									<th>Phone</th>
									<th>Date</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
							 <c:forEach items="${studentList}" var="s">
							  <tr class="text-center"> 
							     <td> <c:out value="${s.id}" /></td>
							     <td> <c:out value="${s.firstname}" /></td>
							    <td> <c:out value="${s.lastname}" /></td>
							    <td> <c:out value="${s.phone}" /></td>
							     <td> <c:out value="${s.birthdate}" /></td>
							    <td><button type="button" class="btn btn-info">Info</button></td>
							   <td> <button type="button" class="btn btn-danger">Danger</button></td>
							  </tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="footer.html" />
</body>
</html>