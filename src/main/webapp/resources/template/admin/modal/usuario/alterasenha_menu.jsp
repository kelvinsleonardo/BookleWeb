<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Import do Security Context -->    
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>  
<!-- Taglib security -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Jquery Validator Form --> 
 <script src="<c:url value="/resources/jquery/validator/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/jquery/validator/views/gerenciadorusuario.js" />"></script> 
<!-- Modal -->
<div class="modal fade" id="modalNovaSenhaMenu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4><strong>Alterar Senha</strong></h4>
      </div>
      <div class="modal-body">
        <form id="formusuario_alterasenha_menu" action="alterasenhamenu" method="POST">
                <div class="panel-body">   
        
                  <!-- Se estiver autenticado -->
                  <c:set var="matricula"> </c:set>
                  <c:if test="${not empty pageContext.request.userPrincipal}">  
                    <c:set var="matricula">
                        <sec:authentication property="principal.matricula" />
                    </c:set>              
                   </c:if>

                    <input type="hidden" class="form-control" placeholder="Matricula" name="matricula" id="novasenha_menu_matricula" value="${matricula}" readonly/>
                    <h5>Olá <strong>${nome_usuario_sessao}</strong> sua matrícula é <strong>${matricula}</strong>, se deseja alterar a senha desta conta, preencha os campos abaixo informando a nova senha.</h5>
                    <br>
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Nova senha" name="senha" id="novasenha_senha_menu"/>
                    </div> 
                    
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Confirme a nova senha" name="senhaconfirmacao" id="novasenha_confirmacao_menu"/>
                    </div> 
                    

                </div>
            <div class="col-md-offset-6">
    
                <button type="submit" class="btn btn-sm btn-success" >
                    <span class="glyphicon glyphicon-ok"></span>
                   <strong> Salvar Nova Senha</strong>
                </button>
 

                 <button type="button" class="btn btn-sm btn-danger" data-dismiss="modal">
                     <span class="glyphicon glyphicon-remove"></span>
                       <strong> Cancelar</strong>
                 </button>

            </div>
        </form>
    </div>
    </div>
  </div>
</div>