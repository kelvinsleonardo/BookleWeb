<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Refefinição Senha - BookleWeb</title>
<link type="text/css" rel="stylesheet" href="<c:url value="../resources/css/bootstrap.min.css" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="../resources/css/estilo.css" />" />   
    
<link href="https://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet">
    
<!-- Jquery Validator Form -->
<script src="/resources/js/jquery-1.11.2.min.js" />""></script>   

<!-- Importação do arquivo Ajax -->
<script src="<c:url value="/resources/jquery/validator/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/jquery/validator/views/gerenciadorusuario.js" />"></script>  
 
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


<div class="login-page">

  <div class="overlay">  
    <div class="loading-page"></div>
  </div> 
  
  <div class="form">
        
        <c:if test="${senhaalterada}">
                        <h2 style="color:#49c593; font-size: 38px; margin-bottom:33px; font-family: 'Roboto'">Senha alterada com sucesso!</h2>
                          <div class="sub">
                               <p>
                                   
                               </p>
                               <button>
                                    <span class="glyphicon glyphicon-home" style="color:#FFFFFF">
                                       <a style="color: #FFFFFF;" href="/">Ir para login</a>
                                   </span>
                                </button>
                          </div>   
        </c:if>

        <c:if test="${!senhaalterada}">
            <form class="form-login" id="formusuario_alterasenha" action="/redefinirsenha" method="POST">
                  <input type="hidden" name="matricula" value="${usuario.matricula}">   
                  <div style="padding: 15px; margin-bottom: 15px;">  
                    <h2 style="font-weight:bold; font-size:40px">Redefinição de Senha</h2>
                  </div>
                  <p style="font-size: 0.7em; margin-bottom:30px;">Olá ${usuario.nome} preencha o campo senha com a nova senha, e confirme a nova senha.</p>
                  <input type="password" name="senha" id="novasenha_senha" placeholder="Nova senha"/>
                  <input type="password" name="senhaconfirmacao" id="novasenha_confirmacao" placeholder="Repita a nova senha"/>
                  <button>Redefinir Senha</button>
            </form>
        </c:if>
  
  </div>
</div>


    <!-- Javascript do bootstrap -->
    <script src="/resources/js/bootstrap.min.js"></script>
</body>
    
</html>
