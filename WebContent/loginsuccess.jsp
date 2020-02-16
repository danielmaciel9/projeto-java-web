<%@include file="/WEB-INF/include/header.jsp"%>

<%@page import="net.javaguides.usermanagement.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section id="thankSection">
           <div class="container">
                <i class="far fa-smile-wink"></i>
                <h1>Seja Bem-Vindo <c:out value="${username}" />!</h1>
                <p>Seu login foi efetuado com sucesso.</p>
           </div>
        </section>
</body>
</html>
<%@include file="/WEB-INF/include/footer.jsp"%>

