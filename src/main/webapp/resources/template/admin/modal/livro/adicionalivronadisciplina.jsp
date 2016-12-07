<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalVinculaLivroNaDisciplina" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Livro na Disciplina</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="salvarvinculo" method="POST">
                <div class="panel-body">  
                    
                <div class="form-group">
                    <div class="form-group">    
                        <select name="codigoDisciplina" class="form-control">
                            <c:forEach items="${listadisciplinas}" var="disciplina" >		
                                <option value="${disciplina.codigoDisciplina}">${disciplina.nomeDisciplina}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <select name="isbn" class="form-control">
                            <c:forEach items="${listalivros}" var="livro" >		
                                <option value="${livro.isbn}">${livro.titulo}</option>
                            </c:forEach> 
                        </select>
                    </div>
                        
                        
                </div>
                        
                    
                    
                </div>
            <button class="btn btn-sm btn-success btn-block" type="submit" >
                <span class="glyphicon glyphicon-ok"></span>
                <strong> Salvar Livro Na Disciplina</strong></button>
            </button>
        </form>
    </div>
    </div>
  </div>
</div>