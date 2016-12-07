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
    <title>BookleWeb 404</title>
    <!-- Importações de CSS com JSTL-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />
    <link href='http://fonts.googleapis.com/css?family=Capriola' rel='stylesheet' type='text/css'>
<style type="text/css">
body{
    
}
body{
    background:#DAD6CC;
}   

</style>
</head>


<body>


<div class="container">
    <div class="row">
        <div class="col-md-12">
                <div class="logo">
                    <h2>404</h2>
                    <p> Ops! - A página que você está procurando não foi encontrada.</p>
                    <div class="sub">
                       <p><a href="/admin"> Ir para Página Principal</a></p>
                    </div>
                </div>
        </div>
    </div>
</div>

    <!-- Javascript do bootstrap -->
    <script src="js/bootstrap.min.js"></script>

</body>    
</html>