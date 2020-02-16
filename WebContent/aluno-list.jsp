<%@include file="/WEB-INF/include/header.jsp"%>

	<br>
	
	<c:if test="${empty user}">
		<script>
			window.location.href = "./login.jsp";
		</script>
			
   </c:if>
   
   <c:if test="${tipo_acesso != 'administrador'}">
       	<script>
			window.location.href = "./loginsuccess.jsp";
		</script>
   	</c:if>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Alunos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newAluno" class="btn btn-success">Adicionar
					novo Aluno</a>
			</div>
			<br>
			<table class="table table-bordered table-responsive table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>CPF</th>
						<th>Nome</th>
						<th>Email</th>
						<th>celular</th>
						<th>Login</th>
						<th>Senha</th>
						<th>Endereco</th>
						<th>Cidade</th>
						<th>Bairro</th>
						<th>Cep</th>
						<th>Comentario</th>
						<th>Aprovado</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listAluno}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.cpf}" /></td>
							<td><c:out value="${user.nome}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.celular}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.senha}" /></td>
							<td><c:out value="${user.endereco}" /></td>
							<td><c:out value="${user.cidade}" /></td>
							<td><c:out value="${user.bairro}" /></td>
							<td><c:out value="${user.cep}" /></td>
							<td><c:out value="${user.comentario}" /></td>
							<td><c:out value="${user.aprovado}" /></td>
							<td><a href="editAluno?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteAluno?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>