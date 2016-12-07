$(function(){
	/* EVENTO CLICAR NO BOTAO "EDITAR" LIVRO
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editarlivro]').click(function(){
        // Pegando id
        var id = $(this).closest("tr").find("td[name=tb_id]").html();  
        // Pegando isbn da tabela.
        var isbn = $(this).closest("tr").find("td[name=tb_isbn]").html(); 
        // Pegando nome do livro da tabela
        var tituloDoLivro = $(this).closest("tr").find("td[name=tb_titulo]").html();
        // Pegando autor do livro da tabela
        var autorDoLivro = $(this).closest("tr").find("td[name=tb_autor]").html();
        // Pegando descricao do livro da tabela
        var descDoLivro = $(this).closest("tr").find("td[name=tb_descricao]").html();
        // Pegando local do livro da tabela
        var localDoLivro = $(this).closest("tr").find("td[name=tb_local]").html();
        // Pegando exemplares do livro da tabela
        var exemplaresLivro = $(this).closest("tr").find("td[name=tb_exemplares]").html();
        // Pegando status do livro da tabela
        var statusLivro = $(this).closest("tr").find("td[name=tb_status]").html();
 
        // Setando ISBN no Modal de Editar
        $('#edit_id').val(id);
        // Setando ISBN no Modal de Editar
        $('#edit_isbn').val(isbn);
        // Setando Titulo no Modal de Editar
        $('#edit_titulo').val(tituloDoLivro);
        // Setando Autor no Modal de Editar
        $('#edit_autor').val(autorDoLivro);
        // Setando Descrição no Modal de Editar
        $('#edit_desc_livro').val(descDoLivro); 
        // Setando Local no Modal de Editar
        $('#edit_local').val(localDoLivro);
        // Setando Exemplares no Modal de Editar
        $('#edit_exemplares').val(exemplaresLivro);
        // Setando Status no Modal de Editar
        $('#edit_status').val(statusLivro);
        console.log(statusLivro);
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" LIVRO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * Para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha da tabela.
     */
    $('button[name=excluirlivro]').click(function(){
        // Pegando Codigo ISBN
        var isbn = $(this).closest("tr").find("td[name=tb_isbn]").html();
        // Pegando Codigo da Disciplina
        var codDisciplina = $(this).closest("tr").find("td[name=tb_livro_disciplina]").attr('id');
        // Pegando nome do Livro
        var nomeDoLivro = $(this).closest("tr").find("td[name=tb_titulo]").html(); 
        // Pegando This do excluir a linha do livro
        var $this = $(this);
        
        alertify.confirm(
                        "EXCLUSÃO DO LIVRO "
                        +nomeDoLivro, 
                        "Você tem certeza que deseja remover o livro <strong>"
                        +nomeDoLivro+"</strong> ?", "", "").
                        autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removelivro',
                        data: 'isbn='+isbn,
                        statusCode:{
                            404: function(){
                                alert("Erro 404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            //Remove linha do livro excluido 
                            $this.closest('tr').remove();
                            // Mostra mensagem de excluido
                            alertify.success("Livro "+ nomeDoLivro+" removido com sucesso!"); 
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "ISBN" LIVRO DE FILTRO DE PESQUISA
     * Após clicar no radio "ISBN" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_isbn').on('change',function(){
        $('#search_titulo').hide();
        $('#search_titulo').val("");
        $('#search_isbn').show();
    })
    
        /* EVENTO CLICAR NO RADIO "TITULO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "TITULO" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_titulo').on('change',function(){
        $('#search_isbn').hide();
        $('#search_isbn').val("");
        $('#search_titulo').show();
    })
    
});
