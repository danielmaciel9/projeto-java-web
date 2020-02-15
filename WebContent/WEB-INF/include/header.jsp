<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Cursos Lero Lero</title>
	<style>
		<%@include file="/WEB-INF/css/bootstrap.min.css"%>
	</style>
	<style>
		<%@include file="/WEB-INF/css/all.min.css"%>
	</style>
	<style>
		<%@include file="/WEB-INF/css/geral.css"%>
	</style>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:100,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
</head>

    <body>        
        <header>
        	<a href="<%=request.getContextPath()%>/">
        		<img src="imagens/marca.png" alt="Lero Lero"/> 
            </a>
            <nav class="navbarLeroLero">
                <div id="menuMobile" style="display: none;">
                    <i class="fas fa-bars"></i>
                </div>
                <ul class="menuDesktop">
                    <div style="display:none" class="closeMobMenu"><i class="fas fa-times"></i></div>
                    <li>
                        <a href="<%=request.getContextPath()%>/listAdmin"
						class="nav-link">Administradores</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/listInstrutores"
						class="nav-link">Instrutores</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/listCursos"
						class="nav-link">Cursos</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/listAlunos"
						class="nav-link">Alunos</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/listTurmas"
						class="nav-link">Turmas</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/listMatriculas"
						class="nav-link">Matriculas</a>
                    </li>
                </ul>
            </nav>
        </header>