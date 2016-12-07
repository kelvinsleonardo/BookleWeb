<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalEditaUsuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Editar Usuario</h4>
      </div>
      <div class="modal-body">
        <form id="formusuario_editar" action="editausuario" method="POST">
                <div class="panel-body">   
                    
                    <div class="form-group">
                            <input type="number" class="form-control" placeholder="Matricula" name="matricula" id="edit_matricula" readonly/>
                    </div>
                    
                     <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome" name="nome" id="edit_nome"/>
                    </div>
                    
                     <div class="form-group">
                            <input type="text" class="form-control" placeholder="Email" name="email" id="edit_email"/>
                    </div> 
 
                    <div class="form-group">
                        <select name="perfil" class="form-control" id="edit_permissao">
                            Selecione o grupo: 
                            <option value="ADMIN">Administrador</option>
                            <option value="PROFESSOR">Professor</option>
                            <option value="ALUNO">Aluno</option>
                        </select>
                    </div>
                    
                </div>
            <div class="col-md-offset-7">
    
                   <button type="submit" class="btn btn-sm btn-success" >
                       <span class="glyphicon glyphicon-ok"></span>
                       <strong>Salvar Alterações</strong>
                    </button>
 

                   <button type="button" class="btn btn-sm btn-danger" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span>
                        <strong>Cancelar</strong>
                    </button>

            </div>
        </form>
    </div>
    </div>
  </div>
</div>