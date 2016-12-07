<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaDisciplina" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Disciplina</h4>
      </div>
      <div class="modal-body">
        <form id="formdisciplina_adicionar" action="adicionadisciplina" method="POST">
                <div class="panel-body">  
                    
                    <div class="form-group">
                        
                        <select name="codigoCurso" class="form-control">
                            <c:forEach items="${listacursos}" var="curso" >		
                                Selecione o curso: <option value="${curso.codigoCurso}">${curso.nomeCurso}</option>
                            </c:forEach> 
                        </select>
                        
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome da disciplina" name="nomeDisciplina" id="add_nome_disciplina"/>
                    </div>  
                    

                </div>
            <button class="btn btn-sm btn-success btn-block" type="submit" >
                <span class="glyphicon glyphicon-ok"></span>
                <strong>Salvar Nova Disciplina</strong>
            </button>
        </form>
    </div>
    </div>
  </div>
</div>