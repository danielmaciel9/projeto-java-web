<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Aluno Form</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Aluno Form </a>
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
				<c:if test="${aluno != null}">
					<form action="updateAluno" method="post">
				</c:if>
				<c:if test="${aluno == null}">
					<form action="insertAluno" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${aluno != null}">
            			Editar Aluno
            		</c:if>
						<c:if test="${aluno == null}">
            			Adicionar um novo Aluno
            		</c:if>
					</h2>
				</caption>

				<c:if test="${aluno != null}">
					<input type="hidden" name="id" value="<c:out value='${aluno.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Digite o CPF</label> <input type="text"
						value="<c:out value='${aluno.cpf}' />" class="form-control"
						name="cpf" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o nome</label> <input type="text"
						value="<c:out value='${aluno.nome}' />" class="form-control"
						name="nome">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a email</label> <input type="text"
						value="<c:out value='${aluno.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o celular</label> <input type="text"
						value="<c:out value='${aluno.celular}' />" class="form-control"
						name="celular" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o login</label> <input type="text"
						value="<c:out value='${aluno.login}' />" class="form-control"
						name="login">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a senha</label> <input type="text"
						value="<c:out value='${aluno.senha}' />" class="form-control"
						name="senha">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o endereco</label> <input type="text"
						value="<c:out value='${aluno.endereco}' />" class="form-control"
						name="endereco" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite a cidade</label> <input type="text"
						value="<c:out value='${aluno.cidade}' />" class="form-control"
						name="cidade">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o bairro</label> <input type="text"
						value="<c:out value='${aluno.bairro}' />" class="form-control"
						name="bairro">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a cep</label> <input type="text"
						value="<c:out value='${aluno.cep}' />" class="form-control"
						name="cep">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o comentario</label> <input type="text"
						value="<c:out value='${aluno.comentario}' />" class="form-control"
						name="comentario" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o aprovado</label> <input type="radio"
						value="<c:out value='${aluno.aprovado}' />" class="form-control"
						name="aprovado">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>