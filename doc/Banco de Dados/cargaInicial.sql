-- Script de criação da base de dados e criação da tabela usuário
-- Data de criação: 18-11-2016
-- SGBD: Mysql
-- @Author: Kelvin Santiago


--
-- Criando banco de dados bookleweb se não existir.
--

CREATE DATABASE IF NOT EXISTS bookleweb;


--
-- Utilizando banco de dados bookleweb
--

USE bookleweb;

--
-- Criando estrutura da tabela `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Criando usuário default do sistema bookle: Usuário: 123456 Senha: 123456
--
INSERT INTO `tb_usuario` (`matricula`, `nome`, `perfil`, `senha`, `email`) VALUES
(123456, 'ADMINISTRADOR BOOKLE', '2', '$2a$10$MgXLgxj8JDMD9/HL15Wltu53Csvkr6k0lIVYLoYZ2qyTRtKVap4BK', 'bookleweb@kelvinsantiago.com.br');
