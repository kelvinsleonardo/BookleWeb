<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaCurso" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Curso</h4>
      </div>
      <div class="modal-body">
        <form id="formcurso_adicionar" action="adicionacurso" method="POST">
                <div class="panel-body">  
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome do curso" name="nomeCurso" id="cursoadd_nome"/>
                    </div> 
                </div>
            <button class="btn btn-sm btn-success btn-block" type="submit" >
                <span class="glyphicon glyphicon-ok"></span>
                <strong>Salvar Novo Curso</strong>
            </button>
        </form>
    </div>
    </div>
  </div>
</div>