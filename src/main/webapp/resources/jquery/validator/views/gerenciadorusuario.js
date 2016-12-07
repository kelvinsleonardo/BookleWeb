$(document).ready( function() {
    
// Verificando e convertendo UPPERCASE do campo
$("#add_nome,#edit_nome").bind('keyup', function (e) {
    if (e.which >= 97 && e.which <= 122) {
        var newKey = e.which - 32;
        e.keyCode = newKey;
        e.charCode = newKey;
    }
    $("#add_nome").val(($("#add_nome").val()).toUpperCase());
    $("#edit_nome").val(($("#edit_nome").val()).toUpperCase());
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
    
  $("#formusuario_adicionar").validate({
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
        required: "A matrícula é obrigatória",
        number: "A matrícula deve conter somente números",
        minlength: "A matrícula deve conter, no mínimo, 5 números"
      },
      nome:{
        required: "O nome é obrigatório",
        fullname: "O nome deve ser completo. Exemplo: Fulano Alves"  
      },
      email:{
        required: "O email é obrigatório",
        email: "Insira um email válido"
      },
      senha:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres"
      }
    }
  });
    
 $("#formusuario_editar").validate({
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
        required: "A matrícula é obrigatória",
        number: "A matrícula deve conter somente números",
        minlength: "A matrícula deve conter, no mínimo, 5 números"
      },
      nome:{
        required: "O nome é obrigatório",
        fullname: "O nome deve ser completo. Exemplo: Fulano Alves"   
      },
      email:{
        required: "O email é obrigatório",
        email: "Insira um email válido"
      },
      senha:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres"
      }
    }
  }); 
    
 $("#formusuario_alterasenha").validate({
    // Define as regras
    rules:{
      senha:{
        required: true, minlength: 6
      },
      senhaconfirmacao:{
        equalTo: "#novasenha_senha",   
        required: true, minlength: 6
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      senha:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres"
      },
      senhaconfirmacao:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres",
        equalTo: "A senha de confirmação não está igual a nova senha"  
      }
    }
  });
    
 $("#formusuario_alterasenha_menu").validate({
    // Define as regras
    rules:{
      senha:{
        required: true, minlength: 6
      },
      senhaconfirmacao:{
        equalTo: "#novasenha_senha_menu",   
        required: true, minlength: 6
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      senha:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres"
      },
      senhaconfirmacao:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres",
        equalTo: "A senha de confirmação não está igual a nova senha"  
      }
    }
  });    
    
});