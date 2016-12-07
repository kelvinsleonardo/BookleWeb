<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalEditaLivro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Editar Livro</h4>
      </div>
      <div class="modal-body">
        <form id="formlivro_editar" action="editarlivro" method="POST">
                <div class="panel-body">

                    <input type="hidden" name="id" id="edit_id">

                    <div class="form-group">
                            <input type="text" class="form-control" name="isbn" id="edit_isbn" readonly/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="titulo" id="edit_titulo" placeholder="Titulo"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="autor" id="edit_autor" placeholder="Autor"/>
                    </div> 
                    
                     <div class="form-group">
                            <textarea class="form-control" rows="5" name="desc_livro" id="edit_desc_livro" placeholder="Descrição" ></textarea>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="local" id="edit_local" placeholder="Local"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="exemplares" id="edit_exemplares" placeholder="Exemplares"/>
                    </div>
                    
                    <div class="form-group">
                        <select name="status" class="form-control" id="edit_status">	
                            <option value="Disponível">Disponível</option>
                            <option value="Indisponível">Indisponível</option>
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