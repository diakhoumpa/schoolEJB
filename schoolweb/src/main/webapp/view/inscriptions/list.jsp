<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="public/bootstrap.css">
<link rel="stylesheet" href="public/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../../header.html" />
	<div class="container">
		<div class="row mb-4">
			<div class="col-4 mt-4">
				<div class="alert alert-dismissible alert-dark">
					<strong>INSCRIPTION STUDENTS</strong> 
				</div>
				<form action="Inscription" method="post">
					<div class="form-group">
						<label for="details">details:</label> <input type="text" class="form-control" id="details" name="details">
					</div>
					<div class="form-group">
						<label for="student">select student:</label> 
						<select class="form-control" name="studentID">
									<option value="0">Faites un choix</option>
									<c:forEach var="item" items="${studentList}">
									<option value="${item.id}"  ${item.id ==  inscription.studentID? 'selected' : ''}>${item.firstname} ${item.lastname}</option>
									</c:forEach>
						 </select>
					    </div>
					<div class="form-group">
						<label for="cours">select courses:</label> 
						<select class="form-control" name="coursID">
						       <option value="0">Faites un choix</option>
								<c:forEach var="item" items="${couresList}">
									<option value="${item.id}"  ${item.id == inscription.coursID ? 'selected' : ''}>${item.name}</option>
								</c:forEach>
						 </select>
					    </div>
					<div class="form-group">
						<label for="years">select years:</label> 
						<select class="form-control" name="yearsID">
						       <option value="0">Faites un choix</option>
								<c:forEach var="item" items="${yearList}">
									<option value="${item.id}"  ${item.id == inscription.yearsID ? 'selected' : ''}>${item.name}</option>
								</c:forEach>
						 </select>
					    </div>
					<div></div>
					<div class="form-group mt-2">
						<button type="submit" class="btn btn-info" name="action" value="Inscrire">Inscrire</button>
					</div>
				</form>
			</div>
			<div class="col-8 mt-4">
				<div class="panel ">
					<div class="panel-heading">
						<div class="card text-white bg-info mb-3" style="max-width: 20rem;" align="center">
							<div class="card-header" align="center">LES INSCRITS</div>
						</div>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-bordered ">
							<thead>
								<tr class="table-warning">
									<th>#Firstname Lastmame</th>
									<th>#Courses</th>
									<th>#Details</th>
									<th>#Years</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${inscriptionList}" var="s">
									<tr class="text-center">
										<td>${s.student.firstname} ${s.student.lastname}</td>
										<td>${s.courses.name}</td>
										<td>${s.details}</td>
										<td>${s.years.name}</td>
										<td class="table-dark"><button type="button" class="btn btn-info" >Edit</button></td>
										<td class="table-dark"><button type="button" class="btn btn-danger">Delete</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="../../footer.html" />
</body>
</html>