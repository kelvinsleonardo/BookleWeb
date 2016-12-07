$(document).ready( function() {

// Verificando e convertendo UPPERCASE do campo
$("#add_nome_disciplina,#edit_nome_disciplina").bind('keyup', function (e) {
    if (e.which >= 97 && e.which <= 122) {
        var newKey = e.which - 32;
        e.keyCode = newKey;
        e.charCode = newKey;
    }
    $("#add_nome_disciplina").val(($("#add_nome_disciplina").val()).toUpperCase());
    $("#edit_nome_disciplina").val(($("#edit_nome_disciplina").val()).toUpperCase());
});
    

    
// Validação do Formulário adicionar disciplina pelo Modal    
$("#formdisciplina_adicionar").validate({
    // Define as regras
    rules:{
      nomeDisciplina:{
        required: true, minlength: 3
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      nomeDisciplina:{
        required: "O nome da disciplina não pode ser vazio",
        minlength: "O nome da disciplina deve conter, no mínimo, 3 caracteres"
      }
    }
  });

// Validação do Formulário editar curso pelo Modal
 $("#formdisciplina_editar").validate({
    // Define as regras
    rules:{
      nomeDisciplina:{
        required: true, minlength: 3
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      nomeDisciplina:{
        required: "O nome da disciplina não pode ser vazio",
        minlength: "O nome da disciplina deve conter, no mínimo, 3 caracteres"
      }
    }
  });        
});

