<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${admin != null}">
					<form action="updateAdmin" method="post">
				</c:if>
				<c:if test="${admin == null}">
					<form action="insertAdmin" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${admin != null}">
            			Editar Administrador
            		</c:if>
						<c:if test="${admin == null}">
            			Adicionar um novo Administrador
            		</c:if>
					</h2>
				</caption>

				<c:if test="${admin != null}">
					<input type="hidden" name="id" value="<c:out value='${admin.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Digite o nome</label> <input type="text"
						value="<c:out value='${admin.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o login</label> <input type="text"
						value="<c:out value='${admin.login}' />" class="form-control"
						name="login">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a senha</label> <input type="text"
						value="<c:out value='${admin.senha}' />" class="form-control"
						name="senha">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>