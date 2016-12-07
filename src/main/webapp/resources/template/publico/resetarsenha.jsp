<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center" id="myModalLabel">
                    <a class="logos" href="#">BOOKLEWEB</a>
                </h4>
            </div>
            <div class="modal-body">
                <form id="formlogin" action="login?sucesso=A nova senha foi enviada no email informado! " method="POST">
                    <div class="panel-body">
                        <label class="text-center">Olá, se você já cadastrou sua conta em nosso sistema, e precisa efetuar a alteração de senha, informe seus dados de matrícula e email que logo enviaremos sua senha no email informado.
                        </label>
                        <form class="form form-signup" role="form">
                            <!-- Campo de Matrícula -->
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Matrícula" name="matricula"/>
                            </div>

                            <!-- Campo de Email -->
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Email" name="email"/>
                            </div>

                            <button class="btn btn-sm btn-success btn-block" type="submit">
                                <strong>Enviar Solicitação</strong>
                            </button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">
                            <span class="glyphicon glyphicon-remove"></span>
                            Cancelar
                        </button>
                    </div>
            </div>
        </div>
    </div>