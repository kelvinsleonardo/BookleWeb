$(function(){
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" LIVRO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha
     * da tabela.
     */
    $('button[name=excluirlivrodadisciplina]').click(function(){
        // Pegando isbn da disciplina da tabela
        var isbn = $(this).closest("tr").find("td[name=tb_isbn]").html();
        // Pegando codigo da disciplina da tabela 
        var codDisciplina = $(this).closest("tr").find("td[name=tb_cod_disciplina]").html(); 
        // Pegando nome do livro na tabela 
        var nomeDoLivro = $(this).closest("tr").find("td[name=tb_titulo]").html(); 
        // Pegando nome da disciplina da tabela 
        var nomeDaDisciplina = $(this).closest("tr").find("td[name=tb_nome_disciplina]").html(); 
        // Pegando this do excluir a linha do livro
        var $this = $(this); 
        
        alertify.confirm(
                        "EXCLUSÃO DO LIVRO "
                        +nomeDoLivro, 
                        "Você tem certeza que deseja remover o livro <strong>"
                        +nomeDoLivro+"</strong> da disciplina <strong>"
                        +nomeDaDisciplina+"</strong> ?", "", "").
                        autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removervinculo',
                        data: {isbn:isbn,codigoDisciplina:codDisciplina},
                        statusCode:{
                            404: function(){
                                alert("Erro 404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            //Remove linha do curso excluido 
                            $this.closest('tr').remove();
                            // Mostra mensagem de excluido
                            alertify.success("Livro "+ nomeDoLivro+" foi removido da disciplina "+nomeDaDisciplina+" com sucesso!"); 
                        }
                    });
            }// Fim IF   
        } );   
	})
});
