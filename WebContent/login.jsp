<%@include file="/WEB-INF/include/header.jsp"%>
	<section id="loginSection">
        <div class="container">
             <div class="wrapper fadeInDown">
                 <div id="formContent">
                     <h4 class="fadeIn second">Faça seu login</h4>
			<form action="<%=request.getContextPath()%>/login" method="post">
				<input type="text" name="username" id="login" class="fadeIn second" placeholder="Login" required/>
				<input type="text" id="password" class="fadeIn third"  name="password" placeholder="Senha" required/>
				<input type="submit" class="fadeIn fourth" value="Entrar" />
			</form>
		</div>
             </div>
        </div>
     </section>
<%@include file="/WEB-INF/include/footer.jsp"%>