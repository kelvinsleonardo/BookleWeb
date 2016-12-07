<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Spring Famework -->
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BookleWeb - Pesquisar</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />

<!-- Javascript do bootstrap -->
<script src="resources/js/jquery-1.11.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>    
    
<!-- Fontes do Google -->
<link href='http://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
    
<!-- Estilos do Alertfy -->
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/alertify.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/css/themes/default.min.css"/>" /> 
<script src="<c:url value="/resources/jquery/alertifyjs/alertify.min.js" />"></script>

<!-- Importação do arquivo Ajax -->
<script type="text/javascript" charset="utf-8"  src="<c:url value="/resources/jquery/ajax/ajax_livrosugerido.js" />"></script> 
    
    
</head>
<body class="background-sistema">
    <div class="container-fluid">
        
        <!-- MENSAGENS ALERTIFY-->
        <c:if test="${not empty param.error}">
            <script>
                alertify.error("${param.error}");
            </script>
        </c:if>
        
        <c:if test="${not empty erro}">
            <script>
                alertify.error("${erro}");
            </script>
        </c:if>
        
        <c:if test="${not empty sucesso}">
            <script>
                alertify.success("${sucesso}");
            </script>
        </c:if>
             
        <!-- CABEÇALHO -->
        <header class="row">
            <jsp:include page="/resources/template/admin/menu.jsp">
                <jsp:param name="active" value="pesquisa" />
            </jsp:include> 
        </header>

        <!-- BREADCRUMB -->
        <ul class="breadcrumb">
           <li><a href="admin">Home</a></li>
           <li class="active">Pesquisar</li>
        </ul>
        
        <!-- CONTEÚDO -->
        <div class="row">
            <div role="main">
                <div class="col-md-12 col-md-offset-0">
                    <form action="resultado" method="POST">
                    <div class="form-group">
                        <select name="codigoCurso" class="form-control">
                            <option value="-1" selected >Selecione o curso</option>
                            <c:forEach items="${listacursos}" var="curso" >		
                                Selecione o curso: <option value="${curso.codigoCurso}">${curso.nomeCurso}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <select name="codigoDisciplina" class="form-control">
                            <option value="-1" selected >Selecione a disciplina</option>
                        </select>
                    </div>
                    
                    <div class="col-md-offset-9">
                        <br>
                        <button type="submit" class="btn btn-success btn-sm form-control btn-pesquisar" name="btnpesquisar"/>
                        <span class="glyphicon glyphicon-search"></span><strong> &nbsp;Pesquisar</strong></button>
                    </div>
                    </form>
                    
            </div>
        </div>  
    </div>
</div>
        <!-- RODAPÉ --> 
        <footer class="row">
            <c:import url="/resources/template/admin/rodape.jsp"></c:import> 
        </footer>
    
        <!-- MODAL PARA RESETAR SENHA -->
        <c:import url="/resources/template/publico/resetarsenha.jsp"></c:import> 
        
    <!--FIM DIV CONTAINER-->
    </div>
</body>
</html>