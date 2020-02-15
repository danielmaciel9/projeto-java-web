<%@include file="/WEB-INF/include/header.jsp"%>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Administradores</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newAdmin" class="btn btn-success">Adicionar
					novo Administrador</a>
			</div>
			<br>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Login</th>
						<th>Senha</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listAdministrador}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.nome}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.senha}" /></td>
							<td><a href="editAdmin?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteAdmin?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>