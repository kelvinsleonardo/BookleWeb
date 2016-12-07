$(document).ready( function() {

// Verificando e convertendo UPPERCASE do campo
$("#nome").bind('keyup', function (e) {
    if (e.which >= 97 && e.which <= 122) {
        var newKey = e.which - 32;
        e.keyCode = newKey;
        e.charCode = newKey;
    }
    $("#nome").val(($("#nome").val()).toUpperCase());
});  
    
    
/**
 * Novo Método para validação de Full Name(Nome Completo)
 * @author Kelvin Santiago
 */
jQuery.validator.addMethod( "fullname", function(value, element) {
    
    if (/\w+\s+\w+/.test(value)) {
        return true;
    } else {
        return false;
    }
}, "O nome deve ser completo." );       
    
$(".form-registrar").validate({
    // Define as regras
    rules:{
      matricula:{
        required: true, minlength: 5, number: true
      },
      nome:{
        required: true,
        fullname: true
      },
      email:{
        required: true, email: true
      },
      senha:{
        required: true, minlength: 6  
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      matricula:{
        required: "A matrícula é obrigatória.",
        number: "A matrícula deve conter somente números inteiros.",
        minlength: "A matrícula deve conter, no mínimo, 5 dígitos."
      },
      nome:{
        required: "O nome é obrigatório",
        fullname: "O nome deve ser completo. Exemplo: Kélvin Santiago" 
      },
      email:{
        required: "O email é obrigatório",
        email: "Insira um email válido"
      },
      senha:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo 6 caracteres"
      }
    }
  });

$(".form-login").validate({
    // Define as regras
    rules:{
      j_username:{
        required: true, minlength: 5, number: true
      },
      j_password:{
        required: true
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      j_username:{
        required: "O campo matrícula não pode ser vazio",
        number: "A matrícula deve conter somente números.",
        minlength: "A matrícula deve conter, no mínimo, 5 dígitos."
      },
      j_password:{
        required: "O campo senha não pode ser vazio"
      }
    }
  });

});