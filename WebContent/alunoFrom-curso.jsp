<%@include file="/WEB-INF/include/header.jsp"%>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h2 class="text-center">Lista de Alunos por curso e suas notas</h2>
			<hr>
			<br>
			<table class="table table-bordered table-dark table-striped">
				<thead>
					<tr>
						<th>Nome do Aluno</th>
						<th>Curso do Aluno</th>
						<th>Nota do Aluno</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listAlunos}">

						<tr>
							<td><c:out value="${user.nome}" /></td>
							<td><c:out value="${user.getMatricula().getTurma().getCurso().nome}" /></td>
							<td><c:out value="${user.getMatricula().nota}" /></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>