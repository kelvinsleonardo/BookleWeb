$(function(){
    
	/* Evento ao clicar no botão Editar 
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editardisciplina]').click(function(){
        // Pegando nome do curso da tabela 
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_curso_disciplina]").html();
        // Pegando codigo do curso da tabela 
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_curso_disciplina]").attr('id');
        // Pegando codigo da disciplina da tabela 
        var codigoDaDisc = $(this).closest("tr").find("td[name=tb_cod_disciplina]").html(); 
        // Pegando nome da disciplina da tabela 
        var nomeDaDisc = $(this).closest("tr").find("td[name=tb_nome_disciplina]").html();
        
        // Setando Curso referente a disciplina da tabela pelo código.
        $('#edit_nome_curso').val(codigoDoCurso);
        // Setando codigo da disciplina da tabela.
        $('#edit_cod_disciplina').val(codigoDaDisc);
        // Setando nome da disciplina da tabela.
        $('#edit_nome_disciplina').val(nomeDaDisc); 
	})
    
    /* Evento ao clicar no botão Excluir
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação Alertify, caso true é chamado o servlet.
     * Para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha da tabela.
     */
    $('button[name=excluirdisciplina]').click(function(){
        // Pegando codigo da disciplina da tabela 
        var codigoDaDisc = $(this).closest("tr").find("td[name=tb_cod_disciplina]").html(); 
         // Pegando nome da disciplina da tabela 
        var nomeDaDisc = $(this).closest("tr").find("td[name=tb_nome_disciplina]").html();
        // Pegando this do excluir a linah da disciplina
        var $this = $(this); 
        alertify.confirm(
                        "EXCLUSÃO DA DISCIPLINA "
                        +nomeDaDisc, 
                        "Você tem certeza que deseja remover a disciplina  <strong>"
                        +nomeDaDisc+
                        "</strong> ?", "", "").
                        autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removedisciplina',
                        data: 'codigoDisciplina='+codigoDaDisc,
                        statusCode:{
                            404: function(){
                                alert("/404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            //Remove linha do curso excluido
                            $this.closest('tr').remove(); 
                            // Mostra mensagem de excluido
                            alertify.success("Opa! Disciplina "+ nomeDaDisc+" removida com sucesso!"); 
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "CODIGO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "CODIGO" é mostrado um input para inserir os dados e oculta o input Nome.
     */
    $('#op_pesq_cod').on('change',function(){
        $('#search_nome_disciplina').hide();
        $('#search_nome_disciplina').val("");
        $('#search_cod_disciplina').show();
        
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input Codigo.
     */
    $('#op_pesq_nome').on('change',function(){
        $('#search_cod_disciplina').hide();
        $('#search_cod_disciplina').val("");
        $('#search_nome_disciplina').show();
    })
    
});
