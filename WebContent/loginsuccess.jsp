<%@include file="/WEB-INF/include/header.jsp"%>

<%@page import="net.javaguides.usermanagement.dao.*"%>

	<c:if test="${tipo_acesso == 'aluno'}">
	
		<c:if test="${user.getAprovado() != 'true' }">
			<script>
				alert("Voce ainda não foi aprovado pelo administrador!");
				window.location.href = "./logout.jsp";
			</script>
		</c:if>
	 
	 </c:if>

	<section id="thankSection">
           <div class="container">
                <i class="far fa-smile-wink"></i>
                <h1>Seja Bem-Vindo <c:out value="${user.getNome()}" />!</h1>
                <h2>Tipo de acesso: <c:out value="${tipo_acesso}" /></h2>
                <p>Seu login foi efetuado com sucesso.</p>
           </div>
        </section>
<%@include file="/WEB-INF/include/footer.jsp"%>

