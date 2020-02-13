<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Administradores</title>
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
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
				<li><a href="<%=request.getContextPath()%>/listAdmin"
					class="nav-link">Administradores</a></li>
				<li><a href="<%=request.getContextPath()%>/listInstrutores"
					class="nav-link">Instrutores</a></li>
				<li><a href="<%=request.getContextPath()%>/listCursos"
					class="nav-link">Cursos</a></li>
				<li><a href="<%=request.getContextPath()%>/listAlunos"
					class="nav-link">Alunos</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Alunos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newAluno" class="btn btn-success">Adicionar
					novo Aluno</a>
			</div>
			<br>
			<table class="table table-bordered table-responsive">
				<thead>
					<tr>
						<th>ID</th>
						<th>CPF</th>
						<th>Nome</th>
						<th>Email</th>
						<th>celular</th>
						<th>Login</th>
						<th>Senha</th>
						<th>Endereco</th>
						<th>Cidade</th>
						<th>Bairro</th>
						<th>Cep</th>
						<th>Comentario</th>
						<th>Aprovado</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listAluno}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.cpf}" /></td>
							<td><c:out value="${user.nome}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.celular}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.senha}" /></td>
							<td><c:out value="${user.endereco}" /></td>
							<td><c:out value="${user.cidade}" /></td>
							<td><c:out value="${user.bairro}" /></td>
							<td><c:out value="${user.cep}" /></td>
							<td><c:out value="${user.comentario}" /></td>
							<td><c:out value="${user.aprovado}" /></td>
							<td><a href="editAluno?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteAluno?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>