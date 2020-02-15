<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${turma != null}">
					<form action="updateTurma" method="post">
				</c:if>
				<c:if test="${turma == null}">
					<form action="insertTurma" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${turma != null}">
            			Editar Turma
            		</c:if>
						<c:if test="${turma == null}">
            			Adicionar um nova Turma
            		</c:if>
					</h2>
				</caption>

				<c:if test="${turma != null}">
					<input type="hidden" name="id" value="<c:out value='${turma.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Digite o ID do curso</label> <input type="input"
						value="<c:out value='${turma.cursos_id}' />" class="form-control"
						name="cursos_id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Digite o ID do instrutor</label> <input type="input"
						value="<c:out value='${turma.instrutores_id}' />" class="form-control"
						name="instrutores_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a data de início</label> <input type="input"
						value="<c:out value='${turma.data_inicio}' />" class="form-control"
						name="data_inicio" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a data final</label> <input type="input"
						value="<c:out value='${turma.data_final}' />" class="form-control"
						name="data_final">
				</fieldset>

				<fieldset class="form-group">
					<label>Digite a Carga horária</label> <input type="text"
						value="<c:out value='${turma.carga_horaria}' />" class="form-control"
						name="carga_horaria">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>