$(document).ready( function() {
    
// Validação do Formulário ADICIONAR livro pelo Modal    
  $("#formlivro_adicionar").validate({
    // Define as regras
    rules:{
      isbn:{
        required: true
      },
      titulo:{
        required: true
      },
      autor:{
        required: true
      },
      local:{
        required: true
      },
      exemplares:{
       required: true,
       number: true
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      isbn:{
        required: "O ISBN não pode ser vazio"
      },
      titulo:{
        required: "O Titulo não pode ser vazio"
      },
      autor:{
        required: "O campo Autor não pode ser vazio"
      },
      local:{
        required: "O local não pode ser vazio"
      }, 
      exemplares:{
        required: "O campo exemplares não pode ser vazio",
        number: "A quantidade de exemplares deve ser em números"
      }     
    }
  });

// Validação do Formulário EDITAR livro pelo Modal    
$("#formlivro_editar").validate({
    // Define as regras
    rules:{
      isbn:{
        required: true
      },
      titulo:{
        required: true
      },
      autor:{
        required: true
      },
      local:{
        required: true
      },
      exemplares:{
       required: true,
       number: true
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      isbn:{
        required: "O ISBN não pode ser vazio"
      },
      titulo:{
        required: "O ISBN não pode ser vazio"
      },
      autor:{
        required: "O campo Autor não pode ser vazio"
      },
      local:{
        required: "O local não pode ser vazio"
      }, 
      exemplares:{
        required: "O campo exemplares não pode ser vazio",
        number: "A quantidade de exemplares deve ser em números"
      }     
    }
  });        
});

