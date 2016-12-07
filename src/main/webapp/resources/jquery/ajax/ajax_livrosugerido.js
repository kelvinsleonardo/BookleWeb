$(function(){
    // Inicializando Combobox da Disciplina como oculto.
    $('select[name=codigoDisciplina]').hide();
    
    // Desabilitando botão de pesquisar
    $('button[name=btnpesquisar]').attr('disabled', 'disabled');
    
    /* Ao clicar no combobox do curso é efetuado algumas pesquisas com ajax.
     * para preencher o combobox da disciplina conforme o curso selecionado.
     */
    $('select[name=codigoCurso]').on('change',function(){
        var codigoDoCursoComboBox = $('select[name=codigoCurso]').val();
		$.ajax({
			type: 'POST',
			url: 'buscardisciplinas',
			data: 'codigoCurso=' +codigoDoCursoComboBox,
			statusCode:{
				404: function(){
					alert("Servidor não encontrado.");
				},
				500: function(){
					alert("Ocorreu um erro interno no servidor.");
				}
			},
			success: function(dados){
                $('select[name=codigoDisciplina]').fadeIn(1000).show();
				$('select[name=codigoDisciplina] option').remove();
				$('select[name=codigoDisciplina]').append('<option value="-1">Selecione a disciplina</option>')
				var pegadados = dados.split(":");
				for(var i = 0; i < pegadados.length - 1; i++){
					var codigoDisciplina = pegadados[i].split("-")[0];
					var nomeDisciplina = pegadados[i].split("-")[1];
					$('select[name=codigoDisciplina]').append(
                        '<option value="'+codigoDisciplina+'">'+nomeDisciplina+'</option>'
                    )
				}
			}
			
		});
	})
    
    /*
     * Ao selecionar o combobox da disicplina é verificado se foi de fato selecionado uma disciplina,
     * caso seja diferente de (-1) significa que não é a opção de "Selecione a Disciplina" então é 
     * liberado o botão de pesquisar, senão é bloqueado o botão de pesquisar.
     */
     $('select[name=codigoDisciplina]').on('change',function(){
        var codigoDaDisciplinaComboBox = $('select[name=codigoDisciplina]').val(); 
        if(codigoDaDisciplinaComboBox != -1){
            $('button[name=btnpesquisar]').removeAttr('disabled');
        }else{
            $('button[name=btnpesquisar]').attr('disabled', 'disabled');
        }		
	})
     
});
