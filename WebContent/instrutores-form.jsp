<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Instrutores Form</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Instrutores Form </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
				<li><a href="<%=request.getContextPath()%>/listAdmin"
					class="nav-link">Administradores</a></li>
				<li><a href="<%=request.getContextPath()%>/listInstrutores"
					class="nav-link">Instrutores</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${instrutores != null}">
					<form action="updateInstrutor" method="post">
				</c:if>
				<c:if test="${instrutores == null}">
					<form action="insertInstrutor" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${instrutores != null}">
            			Editar Instrutor
            		</c:if>
						<c:if test="${instrutores == null}">
            			Adicionar um novo Instrutor
            		</c:if>
					</h2>
				</caption>

				<c:if test="${instrutores != null}">
					<input type="hidden" name="id" value="<c:out value='${instrutores.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Digite o nome</label> <input type="text"
						value="<c:out value='${instrutores.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o email</label> <input type="text"
						value="<c:out value='${instrutores.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o valor hora</label> <input type="text"
						value="<c:out value='${instrutores.valor_hora}' />" class="form-control"
						name="valor_hora">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o login</label> <input type="text"
						value="<c:out value='${instrutores.login}' />" class="form-control"
						name="login" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a senha</label> <input type="text"
						value="<c:out value='${instrutores.senha}' />" class="form-control"
						name="senha">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a sua experiencia</label> <input type="text"
						value="<c:out value='${instrutores.experiencia}' />" class="form-control"
						name="experiencia">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>