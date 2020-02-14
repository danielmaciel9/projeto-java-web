<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Turma Form</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Turma Form </a>
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
				<c:if test="${turma != null}">
					<form action="updateTurma" method="post">
				</c:if>
				<c:if test="${turma == null}">
					<form action="insertTurma" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${turma != null}">
            			Editar Turma
            		</c:if>
						<c:if test="${turma == null}">
            			Adicionar um nova Turma
            		</c:if>
					</h2>
				</caption>

				<c:if test="${turma != null}">
					<input type="hidden" name="id" value="<c:out value='${turma.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Digite o ID do curso</label> <input type="input"
						value="<c:out value='${turma.cursos_id}' />" class="form-control"
						name="cursos_id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o ID do instrutor</label> <input type="input"
						value="<c:out value='${turma.instrutores_id}' />" class="form-control"
						name="instrutores_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a data de início</label> <input type="input"
						value="<c:out value='${turma.data_inicio}' />" class="form-control"
						name="data_inicio" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a data final</label> <input type="input"
						value="<c:out value='${turma.data_final}' />" class="form-control"
						name="data_final">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a Carga horária</label> <input type="text"
						value="<c:out value='${turma.carga_horaria}' />" class="form-control"
						name="carga_horaria">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>