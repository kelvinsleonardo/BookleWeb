<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login BookleWeb</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />   
    
<link href="https://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet">

<!-- Estilos do Alertfy -->
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/alertify.min.css"/>" />

<script src="<c:url value="/resources/jquery/alertifyjs/alertify.min.js" />"></script>
    
<!-- Jquery Validator Form -->
    <script src="resources/js/jquery-1.11.2.min.js"></script>   
<script src="<c:url value="/resources/jquery/validator/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/jquery/validator/views/login.js" />"></script> 
 
<script>
	$(window).load(function() {
		// Animate loader off screen
		$(".loading-page").delay(1000).fadeOut("fast",function(){
            $('.overlay').removeClass('overlay')
        });
	});    
</script>     
    
</head>
<body class="background-login">

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

    <c:if test="${not empty param.sucesso}">
        <script>
            alertify.success("${param.sucesso}");
        </script>
    </c:if>

    <c:if test="${not empty sucesso}">
        <script>
            alertify.success("${sucesso}");
        </script>
    </c:if>


<div class="login-page">

  <div class="overlay">  
    <div class="loading-page"></div>
  </div> 
  
  <div class="form">

    <form class="form-login" action="j_spring_security_check" method="POST">

      <div style="padding: 15px; margin-bottom: 20px;">  
        <img src="resources/img/logo.png" class="img-responsive center-block" alt="BookleWeb">
      </div>
      <input type="text" name="j_username" placeholder="Matricula" value="${param.usuario}"/>
      <input type="password" name="j_password" placeholder="Senha"/>
      <button>Entrar</button>
      <p class="message">Não tem uma conta? <a class="link-registrar" href="#">Criar uma</a></p>
      <p class="message">Esqueceu sua senha? <a class="link-resetar" href="#">Redefinir senha</a></p>
    </form>

    <form class="form-registrar" action="<c:url value='/adicionausuariologin' />" method="POST">
      <div style="padding: 15px; margin-bottom: 20px;">  
        <img src="resources/img/logo.png" class="img-responsive center-block" alt="BookleWeb">
      </div>
      <input type="text" name="matricula" placeholder="Matricula"/>
      <input type="text" name="nome" id="nome" placeholder="Nome completo"/>
      <input type="text" name="email" placeholder="Email"/>
      <input type="password" name="senha" placeholder="Senha"/>
      <button>Criar Conta</button>
      <p class="message">Já possui conta? <a class="link-login" href="#">Entrar</a></p>
      <p class="message">Esqueceu sua senha? <a class="link-resetar" href="#">Redefinir senha</a></p>
    </form>
    
    <form class="form-resetar" action="<c:url value='/solicitarsenha' />" method="POST">
      <div style="padding: 15px; margin-bottom: 20px;">  
        <img src="resources/img/logo.png" class="img-responsive center-block" alt="BookleWeb">
      </div>
      <input type="text" name="email" placeholder="Email"/>
      <button>Redefinir Senha</button>
      <p class="message">Já possui conta? <a class="link-login" href="#">Entrar</a></p>
      <p class="message">Não tem uma conta? <a class="link-registrar" href="#">Criar uma</a></p>
    </form>
  
  </div>
</div>

<script type="text/javascript">
    $('.link-registrar').click(function(){

        var isResetarVisivel = $('.form-resetar').is(":visible");
        var isLoginVisivel = $('.form-login').is(":visible");

        if(isResetarVisivel){
            $('.form-resetar').toggle("slow");
        }
        if(isLoginVisivel){
            $('.form-login').toggle("slow");
        }
        
        $('.form-registrar').toggle("slow");

        //$('.form-registrar').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

    $('.link-resetar').click(function(){
        
        var isRegistrarVisivel = $('.form-registrar').is(":visible");
        var isLoginVisivel = $('.form-login').is(":visible");

        if(isRegistrarVisivel){
            $('.form-registrar').toggle("slow");
        }
        if(isLoginVisivel){
            $('.form-login').toggle("slow");
        }
        
        $('.form-resetar').toggle("slow");
         
    });

    $('.link-login').click(function(){
        
        var isRegistrarVisivel = $('.form-registrar').is(":visible");
        var isResetarVisivel = $('.form-resetar').is(":visible");

        if(isRegistrarVisivel){
            $('.form-registrar').toggle("slow");
        }
        if(isResetarVisivel){
            $('.form-resetar').toggle("slow");
        }
        
        $('.form-login').toggle("slow");
         
         
    });

</script>


    <!-- Javascript do bootstrap -->
    <script src="resources/js/bootstrap.min.js"></script>
</body>
    
</html>
