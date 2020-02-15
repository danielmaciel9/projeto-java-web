<%@include file="/WEB-INF/include/header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${curso != null}">
					<form action="updateCurso" method="post">
				</c:if>
				<c:if test="${curso == null}">
					<form action="insertCurso" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${curso != null}">
            			Editar Curso
            		</c:if>
						<c:if test="${curso == null}">
            			Adicionar novo curso
            		</c:if>
					</h2>
				</caption>

				<c:if test="${curso != null}">
					<input type="hidden" name="id" value="<c:out value='${curso.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nome do Curso</label> <input type="text"
						value="<c:out value='${curso.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Requisito do Curso</label> <input type="text"
						value="<c:out value='${curso.requisito}' />" class="form-control"
						name="requisito">
				</fieldset>

				<fieldset class="form-group">
					<label>Ementa do curso</label> <input type="text"
						value="<c:out value='${curso.ementa}' />" class="form-control"
						name="ementa">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Carga Horária</label> <input type="text"
						value="<c:out value='${curso.carga_horaria}' />" class="form-control"
						name="carga_horaria">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Preço</label> <input type="text"
						value="<c:out value='${curso.preco}' />" class="form-control"
						name="preco">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/include/footer.jsp"%>