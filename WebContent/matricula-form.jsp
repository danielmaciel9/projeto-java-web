<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${matricula != null}">
					<form action="updateMatricula" method="post">
				</c:if>
				<c:if test="${matricula == null}">
					<form action="insertMatricula" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${matricula != null}">
            			Editar Matricula
            		</c:if>
						<c:if test="${matricula == null}">
            			Adicionar uma nova Matricula
            		</c:if>
					</h2>
				</caption>
				<c:if test="${matricula != null}">
					<input type="hidden" name="id" value="<c:out value='${matricula.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Digite a turma ID</label> <input type="text"
						value="<c:out value='${matricula.turmas_id}' />" class="form-control"
						name="turmas_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite o Aluno ID</label> <input type="text"
						value="<c:out value='${matricula.alunos_id}' />" class="form-control"
						name="alunos_id">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a data da matricula</label> <input type="text"
						value="<c:out value='${matricula.data_matricula}' />" class="form-control"
						name="data_matricula">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite a nota da matricula</label> <input type="text"
						value="<c:out value='${matricula.nota}' />" class="form-control"
						name="nota">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>