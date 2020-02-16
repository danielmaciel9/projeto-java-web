<%@include file="/WEB-INF/include/header.jsp"%>

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
   	
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Instrutores</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newInstrutor" class="btn btn-success">Adicionar
					novo Instrutor</a>
			</div>
			<br>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Valor Hora</th>
						<th>Login</th>
						<th>Senha</th>
						<th>Experiencia</th>
						<th>Extrato do Instrutor</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listInstrutores}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.nome}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.valor_hora}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.senha}" /></td>
							<td><c:out value="${user.experiencia}" /></td>
							<td><a href="listInstrutoresValoresCursos?id=<c:out value='${user.id}' />">Visualizar Extrato Geral</a></td>
							<td><a href="editInstrutor?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteInstrutor?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>