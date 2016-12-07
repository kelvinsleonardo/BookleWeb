# BookleWeb
Sistema Bookle Web - Gerenciador Acadêmico 

Sistema destinado a fornecer métodos de pesquisa de livros sugeridos na ementa da disciplina.

# Arquitetura - Desenvolvido em Java EE (Web)
1. JPA - Framework para a persistencia dos dados.
2. Framework Spring MVC - Framework para utilização do Design Pattern MVC (Model And View), e injeção de dependencias.
  1. Model - Criação das classes modelo
  2. View - Utilizado JSP com outros frameworks.
  3. Control - Servlets do pŕoprio Spring
3. Framework Spring Security - Framework para gerenciamento de autenticação, e criação de sessão.
4. JasperReport - Geração de relatórios.
6. Bootstrap - Criação do Front-end reponsível.
7. SGBD MySQL - Sistema gerenciador de banco de dados
8. Ajax - AJAX carregar e renderizar uma página, utilizando recursos de scripts rodando pelo lado cliente.
9. Jquery Validator - Validação de campos.
10. JSP - Páginas geradas dinamicamente.

# Módulos do sistema
1. Pesquisa Livros Sugeridos
2. CRUD Curso - Gerenciador Curso
3. CRUD Disciplina - Gerenciador Disciplina
4. CRUD Livro - Gerenciador Livro
5. Vincular Livro na Disciplina
6. CRUD Usuário - Gerenciador Usuário
7. Relatório de Cursos.
8. Relatório de Disciplinas.
9. Relatório de Livros.
10. Relatório de Usuários.


# Design Responsive
Design Responsivo é uma técnica de estruturação HTML e CSS, em que o site se adapta ao browser do usuário sem precisar definir diversas folhas de estilos para cada resolução, então juntamente com o bootstrap, customizamos todo o sistema para adaptar aos diferentes tamanhos de tela.


# Instalação
1. Abra o IDE Eclipse EE, caso não tenha instalado faça o download no link abaixo.
  Link: https://www.eclipse.org/downloads/

2. Vamos clonar o projeto do Github no Eclipse.
  1. Clique em "File > Import" e procure por GIT, selecione "Projects from Git" e clique em Next.
  2. Selecione Clone URL e clique em Next.
  3. Em URL coloque https://github.com/kelvinsleonardo/BookleWeb.git .
  4. Você necessita ter uma conta no Github para clonar o projeto, será solicitado as credenciais de autenticação.
  5. Selecione "master" e clique em Next.

3. O banco de dados utilizado para a persistencia dos dados foi o SGBD Mysql, faça a instalação dele, o sistema bookleweb ultiliza o usuário "root" e senha "root" para logar no mysql, caso seu mysql foi criado com outros dados de login, escolha uma das opções abaixo: 
  * Edite os arquivos do sistema bookleweb com seus dados de login do mysql nos campos correspondentes.
        * src/main/resources/META-INF/persistence.xml 
        * src/main/webapp/WEB-INF/applicationContext.xml
  * Crie um novo usuário no banco de dados com o comando abaixo.
        * CREATE USER 'root'@'%' IDENTIFIED BY 'root';
        * GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;

4. Importe o arquivo configurarDatabase.sql no Mysql que está dentro da pasta Doc na raiz do projeto BookleWeb, feito isso será criado o banco de dados e a tabela tb_usuario, contendo apenas um usuário padrão cadastrado, segue dados desse usuário para utilizar no login do sistema:    
    - Matrícula: 123456
    - Senha: 123456
    
5. Este sistema utiliza o Maven que é um software de gerenciamento de projetos, então todas as dependencias que o sistema usa o maven baixa automaticamente, conforme definimos no POM.xml que é o arquivo de configuração dele. 

6. Vamos atualizar o projeto com Maven:
  1. Clique sobre o projeto do BookleWeb, selecione a opção Maven > Update Project.
  2. Selecione o projeto BookleWeb e clique em ok.
  3. E aguarde a atualização do projeto.

7. Vamos inicializar o sistema no eclipse 
    1. Clique em cima do projeto BookleWeb com o botão direito e selecione, Run as > Maven Build...
    2. Em Goals coloque o seguinte comando: tomcat7:run, com esse comando o TomCat será inicializado.

8. Se a inicialização do sistema com o TomCat foi feita da maneira correta, o sistema já está online, a URL para ao acesso ao sistema é:
    - URL: http://localhost/9090/BookleWeb
    - Usuario: 123456
    - Senha: 123456

# Testando aplicação BookleWeb
Acesse: http://localhost:9090/BookleWeb

# Javadoc
Para visualizar o javadoc do sistema acesse: http://rawgit.com/kelvinsleonardo/BookleWeb/master/src/main/javadoc/site/apidocs/index.html

