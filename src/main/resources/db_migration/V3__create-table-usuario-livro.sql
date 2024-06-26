create table usuario_livro (

    id bigint not null auto_increment,
    nomeDoUsuario varchar(100) not null,
    email varchar(255) not null unique,
    telefone varchar(20) not null,
    cpf varchar(14) not null unique,
    dataDeRegistro DATETIME not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)
);
