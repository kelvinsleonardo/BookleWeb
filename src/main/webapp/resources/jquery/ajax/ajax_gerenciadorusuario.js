$(function(){
	/* EVENTO CLICAR NO BOTAO "EDITAR" USUARIO
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editarusuario]').click(function(){
        // Pegando nome do grupo - Role
        var nomeGrupoPermissao = $(this).closest("tr").find("td[name=tb_permissao]").html();
        // Pegando Codigo da Permissão
        var codigoPermissao = $(this).closest("tr").find("td[name=tb_permissao]").attr('id');
        // Pegando matricula
        var matricula = $(this).closest("tr").find("td[name=tb_matricula]").html();
        // Pegando Nome
        var nome = $(this).closest("tr").find("td[name=tb_nome]").html(); 
        // Pegando Email
        var email = $(this).closest("tr").find("td[name=tb_email]").html(); 
        
        // Setando atributos nos input do Modal
        $('#edit_permissao').val(codigoPermissao); 
        $('#edit_matricula').val(matricula); 
        $('#edit_nome').val(nome); 
        $('#edit_email').val(email); 
	})
    
    /* Ao clicar em nova senha é inserido os dados no modal de acordo com a linha selecionada
     * para editar a senha.
     */
    $('button[name=novasenha]').click(function(){
        var matricula = $(this).closest("tr").find("td[name=tb_matricula]").html();
        var nome = $(this).closest("tr").find("td[name=tb_nome]").html();
        var email = $(this).closest("tr").find("td[name=tb_email]").html();
        var perfil = $(this).closest("tr").find("td[name=tb_permissao]").attr('id');
        $('#novasenha_matricula').val(matricula); 
        $('#novasenha_nome').val(nome);
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" USUARIO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet.
     * Para excluir aquela matricula selecionada na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha da tabela.
     */
    $('button[name=excluirusuario]').click(function(){
        // Pegando matricula a excluir
        var matricula = $(this).closest("tr").find("td[name=tb_matricula]").html();
        // Pegando nome dessa matricula
        var nome = $(this).closest("tr").find("td[name=tb_nome]").html(); 
        // Pegando this do excluir a linha do usuario
        var $this = $(this); 
        alertify.confirm(
                        "EXCLUSÃO DO USUARIO "
                        +nome, "Você tem certeza que deseja remover o usuario <strong>"
                        +nome+"</strong> ?", "", "").
                        autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removeusuario',
                        data: 'matricula='+matricula,
                        statusCode:{
                            404: function(){
                                alert("/404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            //Remove linha do usuario excluido
                            $this.closest('tr').remove();
                            // Mostra mensagem de excluido
                            alertify.success("Opa! Usuario "+ nome+" removido com sucesso!"); 
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "MATRICULA" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "MATRICULA" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_matricula').on('change',function(){
        $('#search_nome').hide();
        $('#search_nome').val("");
        $('#search_matricula').show();
        
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_nome').on('change',function(){
        $('#search_matricula').hide();
        $('#search_matricula').val("");
        $('#search_nome').show();
    })
});
