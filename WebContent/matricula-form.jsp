<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Matricula Form</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Matricula Form </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${matricula != null}">
					<form action="updateMatricula" method="post">
				</c:if>
				<c:if test="${matricula == null}">
					<form action="insertMatricula" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${matricula != null}">
            			Editar Matricula
            		</c:if>
						<c:if test="${matricula == null}">
            			Adicionar uma nova Matricula
            		</c:if>
					</h2>
				</caption>
				<c:if test="${matricula != null}">
					<input type="hidden" name="id" value="<c:out value='${matricula.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Digite a turma ID</label> <input type="text"
						value="<c:out value='${matricula.turmas_id}' />" class="form-control"
						name="turmas_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o Aluno ID</label> <input type="text"
						value="<c:out value='${matricula.alunos_id}' />" class="form-control"
						name="alunos_id">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a data da matricula</label> <input type="text"
						value="<c:out value='${matricula.data_matricula}' />" class="form-control"
						name="data_matricula">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite a nota da matricula</label> <input type="text"
						value="<c:out value='${matricula.nota}' />" class="form-control"
						name="nota">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>