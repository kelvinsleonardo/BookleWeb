$(function(){
    
	/* EVENTO CLICAR NO BOTAO "EDITAR" CURSO
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editarcurso]').click(function(){
        // Pegando Código do curso da tabela.
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_codigo]").html();
        // Pegando Nome do curso da tabela.
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_nome]").html();
        // Pegando Descrição do curso da tabela.
        var descDoCurso = $(this).closest("tr").find("td[name=tb_descricao_curso]").html(); 
        // Setando Código do curso no Modal
        $('#cursoedit_codigo').val(codigoDoCurso);
        // Setando Nome do curso no Modal
        $('#cursoedit_nome').val(nomeDoCurso);
        // Setando Descrição do curso no Modal
        $('#edit_desc_curso').val(descDoCurso); 
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" CURSO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet.
     * Para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha da tabela pelo ajax.
     */
    $('button[name=excluircurso]').click(function(){
        // Pegando codigo do curso da tabela 
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_codigo]").html();
        // Pegando nome do curso da tabela 
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_nome]").html();
        // Pegando this do excluir curso
        var $this = $(this); 
        alertify.confirm(
                        "EXCLUSÃO DO CURSO "
                        +nomeDoCurso, 
                        "Você tem certeza que deseja remover o curso <strong>"+nomeDoCurso+"</strong> ?",
                        "", "").
                        autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent){
                // Iniciando Ajax para chamar Servlet que Remove Curso
                $.ajax({
                        type: 'POST',
                        url: 'removecurso',
                        data: 'codigoCurso='+codigoDoCurso,
                        statusCode:{
                            404: function(){
                                alert("/404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            //Remove linha do curso excluido na tabela.
                            $this.closest('tr').remove(); 
                            // Mostra mensagem de excluído pelo Alertify.
                            alertify.success("Curso "+ nomeDoCurso+" removido com sucesso!"); 
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* Evento ao clicar no Radio Button Código da Busca
     * Após clicar no radio "Código" é mostrado um input para inserir os dados e oculta o input Nome.
     */
    $('#op_pesq_cod').on('change',function(){
        $('#search_nome').hide();
        $('#search_nome').val("");
        $('#search_codigo').show();
        
    })
    
    /* Evento ao clicar no Radio Button Nome da Busca
     * Após clicar no radio "Nome" é mostrado um input para inserir os dados e oculta o input Código.
     */
    $('#op_pesq_nome').on('change',function(){
        $('#search_codigo').hide();
        $('#search_codigo').val(null);
        $('#search_nome').show();
    })
});
