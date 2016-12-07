<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="modalEditaCurso" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Editar Curso</h4>
      </div>
      <div class="modal-body">
        <form id="formcurso_editar" action="editacurso" method="POST">
                <div class="panel-body">  
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="codigoCurso" id="cursoedit_codigo" readonly/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="nomeCurso" id="cursoedit_nome"/>
                    </div>  
                </div>
            <div class="col-md-offset-7">
    
                   <button type="submit" class="btn btn-sm btn-success">
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