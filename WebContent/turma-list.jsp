<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Turmas</title>
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
			<h3 class="text-center">Lista de Turmas</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newTurma" class="btn btn-success">Adicionar
					nova Turma</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Data Início</th>
						<th>Data Final</th>
						<th>Carga horária</th>
						<th>Curso Id</th>
						<th>Instrutor Id</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listTurma}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.data_inicio}" /></td>
							<td><c:out value="${user.data_final}" /></td>
							<td><c:out value="${user.carga_horaria}" /></td>
							<td><c:out value="${user.cursos_id}" /></td>
							<td><c:out value="${user.instrutores_id}" /></td>
							<td><a href="editTurma?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteTurma?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>