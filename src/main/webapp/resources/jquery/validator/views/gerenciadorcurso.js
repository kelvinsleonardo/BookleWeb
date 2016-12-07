$(document).ready( function() {

// Verificando e convertendo para UPPERCASE do campo
$("#cursoadd_nome,#cursoedit_nome").bind('keyup', function (e) {
    if (e.which >= 97 && e.which <= 122) {
        var newKey = e.which - 32;
        e.keyCode = newKey;
        e.charCode = newKey;
    }
    $("#cursoadd_nome").val(($("#cursoadd_nome").val()).toUpperCase());
    $("#cursoedit_nome").val(($("#cursoedit_nome").val()).toUpperCase());
});
    

    
// Validação do Formulário adicionar curso pelo Modal    
$("#formcurso_adicionar").validate({
    // Define as regras
    rules:{
      nomeCurso:{
        required: true, minlength: 3
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      nomeCurso:{
        required: "O nome do curso não pode ser vazio",
        minlength: "O nome do curso deve conter, no mínimo, 3 caracteres"
      }
    }
  });

// Validação do Formulário editar curso pelo Modal
 $("#formcurso_editar").validate({
    // Define as regras
    rules:{
      nomeCurso:{
        required: true, minlength: 3
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      nomeCurso:{
        required: "O nome do curso não pode ser vazio",
        minlength: "O nome do curso deve conter, no mínimo, 3 caracteres"
      }
    }
  });        
});

