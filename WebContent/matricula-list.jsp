<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Matriculas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listAdmin"
					class="nav-link">Administradores</a></li>
				<li><a href="<%=request.getContextPath()%>/listInstrutores"
					class="nav-link">Instrutores</a></li>
				<li><a href="<%=request.getContextPath()%>/listCursos"
					class="nav-link">Cursos</a></li>
				<li><a href="<%=request.getContextPath()%>/listAlunos"
					class="nav-link">Alunos</a></li>
				<li><a href="<%=request.getContextPath()%>/listTurmas"
					class="nav-link">Turmas</a></li>
				<li><a href="<%=request.getContextPath()%>/listMatriculas"
					class="nav-link">Matriculas</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Matriculas</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newMatricula" class="btn btn-success">Adicionar
					nova Matricula</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Turma ID</th>
						<th>Aluno ID</th>
						<th>Data da Matricula</th>
						<th>Nota</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listMatricula}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.turmas_id}" /></td>
							<td><c:out value="${user.alunos_id}" /></td>
							<td><c:out value="${user.data_matricula}" /></td>
							<td><c:out value="${user.nota}" /></td>
							<td><a href="editMatricula?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteMatricula?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>