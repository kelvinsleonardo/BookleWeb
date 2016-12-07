<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaUsuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Usuario</h4>
      </div>
      <div class="modal-body">
        <form id="formusuario_adicionar" action="adicionausuario" method="POST">
                <div class="panel-body">  
                    
                    <div class="form-group">
                            <input type="number" class="form-control" placeholder="Matricula" name="matricula" id="add_matricula"/>
                    </div>
                    
                     <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome" name="nome" id="add_nome"/>
                    </div>
                    
                     <div class="form-group">
                            <input type="text" class="form-control" placeholder="Email" name="email" id="add_email"/>
                    </div> 
                    
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Senha" name="senha" id="add_senha"/>
                    </div>
 
                    <div class="form-group">
                        <select name="perfil" class="form-control">
                            Selecione o grupo: 
                            <option value="ADMIN">Administrador</option>
                            <option value="PROFESSOR">Professor</option>
                            <option value="ALUNO">Aluno</option>
                        </select>
                    </div>
                    

                </div>
            <button class="btn btn-sm btn-success btn-block" type="submit" >
                <span class="glyphicon glyphicon-ok"></span>
                <strong>Salvar Novo Usuário</strong>
            </button>
        </form>
    </div>
    </div>
  </div>
</div>