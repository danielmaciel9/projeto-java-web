<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
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
				<c:if test="${curso != null}">
					<form action="updateCurso" method="post">
				</c:if>
				<c:if test="${curso == null}">
					<form action="insertCurso" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${curso != null}">
            			Editar Curso
            		</c:if>
						<c:if test="${curso == null}">
            			Adicionar novo curso
            		</c:if>
					</h2>
				</caption>

				<c:if test="${curso != null}">
					<input type="hidden" name="id" value="<c:out value='${curso.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nome do Curso</label> <input type="text"
						value="<c:out value='${curso.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Requisito do Curso</label> <input type="text"
						value="<c:out value='${curso.requisito}' />" class="form-control"
						name="requisito">
				</fieldset>

				<fieldset class="form-group">
					<label>Ementa do curso</label> <input type="text"
						value="<c:out value='${curso.ementa}' />" class="form-control"
						name="ementa">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Carga Horária</label> <input type="text"
						value="<c:out value='${curso.carga_horaria}' />" class="form-control"
						name="carga_horaria">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Preço</label> <input type="text"
						value="<c:out value='${curso.preco}' />" class="form-control"
						name="preco">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>