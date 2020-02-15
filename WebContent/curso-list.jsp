<%@include file="/WEB-INF/include/header.jsp"%>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista dos Cursos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newCurso" class="btn btn-success">Adicionar novo curso</a>
			</div>
			<br>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Requisito</th>
						<th>Ementa</th>
						<th>Carga Horária</th>
						<th>Preço</th>
						<th>Alunos e notas do curso</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listCurso}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.nome}" /></td>
							<td><c:out value="${user.requisito}" /></td>
							<td><c:out value="${user.ementa}" /></td>
							<td><c:out value="${user.carga_horaria}" /></td>
							<td><c:out value="${user.preco}" /></td>
							<td><a href="listAlunosFromCurso?id=<c:out value='${user.id}' />">Visualizar alunos e notas</a></td>
							<td>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="editCurso?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="deleteCurso?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>