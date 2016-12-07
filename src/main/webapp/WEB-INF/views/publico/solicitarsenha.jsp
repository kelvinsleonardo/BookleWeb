<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Solicitação de Senha - BookleWeb</title>
    <!-- Importações de CSS com JSTL-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet">
<style type="text/css">
body{
    background:#DAD6CC;
}   
</style>
</head>


<body>


<div class="container">
    <div class="row">
        <div class="col-md-12">
                <div class="emailsolicitacao">

                    <c:if test="${retorno}">
                        <h2>Email Enviado</h2>
                        <p>Um email foi enviado para <label>${email}</label> para a redefinição de senha.</p>
                        <p>Acesse o email e siga as instruções.</p>
                    </c:if>
                    <c:if test="${!retorno}">
                        <h2 class="tituloNaoEncontrado" >Ops.</h2>
                        <p>Não foi encontrado um usuário com o email <label>${email}</label> </p>
                    </c:if>     
                    
                    
                    <div class="sub">
                       <p><a href="/admin"> Ir para Página Principal</a></p>
                    </div>
                </div>
        </div>
    </div>
</div>

</body>    
</html>