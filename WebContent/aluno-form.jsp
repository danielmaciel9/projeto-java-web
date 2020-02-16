<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${aluno != null}">
					<form action="updateAluno" method="post">
				</c:if>
				<c:if test="${aluno == null}">
					<form action="insertAluno" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${aluno != null}">
            			Editar Aluno
            		</c:if>
						<c:if test="${aluno == null}">
            			Cadastro de novo Aluno
            		</c:if>
					</h2>
				</caption>

				<c:if test="${aluno != null}">
					<input type="hidden" name="id" value="<c:out value='${aluno.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Digite o CPF</label> <input type="text"
						value="<c:out value='${aluno.cpf}' />" class="form-control"
						name="cpf" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o nome</label> <input type="text"
						value="<c:out value='${aluno.nome}' />" class="form-control"
						name="nome">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a email</label> <input type="text"
						value="<c:out value='${aluno.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o celular</label> <input type="text"
						value="<c:out value='${aluno.celular}' />" class="form-control"
						name="celular" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o login</label> <input type="text"
						value="<c:out value='${aluno.login}' />" class="form-control"
						name="login">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a senha</label> <input type="text"
						value="<c:out value='${aluno.senha}' />" class="form-control"
						name="senha">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o endereco</label> <input type="text"
						value="<c:out value='${aluno.endereco}' />" class="form-control"
						name="endereco" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite a cidade</label> <input type="text"
						value="<c:out value='${aluno.cidade}' />" class="form-control"
						name="cidade">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o bairro</label> <input type="text"
						value="<c:out value='${aluno.bairro}' />" class="form-control"
						name="bairro">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a cep</label> <input type="text"
						value="<c:out value='${aluno.cep}' />" class="form-control"
						name="cep">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o comentario</label> <input type="text"
						value="<c:out value='${aluno.comentario}' />" class="form-control"
						name="comentario" required="required">
				</fieldset>

				<fieldset class="form-group">
					<input type="hidden"
						value="<c:out value='${aluno.aprovado}' />" class="form-control"
						name="aprovado">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>