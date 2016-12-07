<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaLivro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Livro</h4>
      </div>
      <div class="modal-body">
        <form id="formlivro_adicionar" action="adicionalivro" method="POST">
                <div class="panel-body">  

                  <div class="form-group">
                          <input type="text" class="form-control" placeholder="ISBN" name="isbn" id="add_isbn"/>
                  </div>

                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Titulo" name="titulo" id="add_titulo"/>
                    </div>

                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Autor" name="autor" id="add_autor"/>
                    </div> 
                    
                     <div class="form-group">
                        <textarea class="form-control" rows="5" placeholder="Descrição sobre o Livro" name="desc_livro"
                                      id="add_desc_livro"></textarea>
                    </div>
                
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Local" name="local" id="add_local"/>
                    </div>
                    
                    <div class="form-group">
                        <input type="number" class="form-control" placeholder="Exemplares" name="exemplares" id="add_exemplares"/>
                    </div>
                    
                    <div class="form-group">
                        <select name="status" class="form-control">	
                            <option value="Disponível">Disponível</option>
                            <option value="Indisponível">Indisponível</option>
                        </select>
                    </div>
                </div>
            <button class="btn btn-sm btn-success btn-block" type="submit" >
                <span class="glyphicon glyphicon-ok"></span>
                <strong>Salvar Novo Livro</strong></button>
            </button>
        </form>
    </div>
    </div>
  </div>
</div>