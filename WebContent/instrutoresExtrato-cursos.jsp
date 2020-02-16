<%@include file="/WEB-INF/include/header.jsp"%>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h2 class="text-center">Lista de valor total por Instrutor</h2>
			<hr>
			<br>
			<table class="table table-bordered table-dark table-striped">
				<thead>
					<tr>
						<th>Nome do Instrutor</th>
						<th>Curso do Curso</th>
						<th>Carga Horária</th>
						<th>Preço</th>
						<th>Valor Total a Receber</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="turma" items="${listTurmas}">
						<tr>
							<td><c:out value="${turma.getInstrutores().nome}" /></td>
							<td><c:out value="${turma.getCurso().nome}" /></td>
							<td><c:out value="${turma.getCurso().carga_horaria}" /></td>
							<td><c:out value="${turma.getCurso().preco}" /></td>
							<th>${turma.getCurso().preco * turma.getCurso().carga_horaria}</th>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>