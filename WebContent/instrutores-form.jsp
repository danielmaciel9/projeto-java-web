<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${instrutores != null}">
					<form action="updateInstrutor" method="post">
				</c:if>
				<c:if test="${instrutores == null}">
					<form action="insertInstrutor" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${instrutores != null}">
            			Editar Instrutor
            		</c:if>
						<c:if test="${instrutores == null}">
            			Adicionar um novo Instrutor
            		</c:if>
					</h2>
				</caption>

				<c:if test="${instrutores != null}">
					<input type="hidden" name="id" value="<c:out value='${instrutores.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Digite o nome</label> <input type="text"
						value="<c:out value='${instrutores.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o email</label> <input type="text"
						value="<c:out value='${instrutores.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o valor hora</label> <input type="text"
						value="<c:out value='${instrutores.valor_hora}' />" class="form-control"
						name="valor_hora">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o login</label> <input type="text"
						value="<c:out value='${instrutores.login}' />" class="form-control"
						name="login" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a senha</label> <input type="text"
						value="<c:out value='${instrutores.senha}' />" class="form-control"
						name="senha">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a sua experiencia</label> <input type="text"
						value="<c:out value='${instrutores.experiencia}' />" class="form-control"
						name="experiencia">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>