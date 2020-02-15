<%@include file="/WEB-INF/include/header.jsp"%>
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
			<table class="table table-bordered table-striped">
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
<%@include file="/WEB-INF/include/footer.jsp"%>