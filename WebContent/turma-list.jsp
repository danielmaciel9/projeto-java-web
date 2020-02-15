<%@include file="/WEB-INF/include/header.jsp"%>
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
			<table class="table table-bordered table-striped">
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
<%@include file="/WEB-INF/include/footer.jsp"%>