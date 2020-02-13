<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Admin Form</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Administrador Form </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${admin != null}">
					<form action="updateAdmin" method="post">
				</c:if>
				<c:if test="${admin == null}">
					<form action="insertAdmin" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${admin != null}">
            			Editar Administrador
            		</c:if>
						<c:if test="${admin == null}">
            			Adicionar um novo Administrador
            		</c:if>
					</h2>
				</caption>

				<c:if test="${admin != null}">
					<input type="hidden" name="id" value="<c:out value='${admin.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Digite o nome</label> <input type="text"
						value="<c:out value='${admin.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o login</label> <input type="text"
						value="<c:out value='${admin.login}' />" class="form-control"
						name="login">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a senha</label> <input type="text"
						value="<c:out value='${admin.senha}' />" class="form-control"
						name="senha">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>