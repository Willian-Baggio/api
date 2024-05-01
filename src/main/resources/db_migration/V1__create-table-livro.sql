create table livro (

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    autor varchar(100) not null,
    numeroDePaginas int not null,
    anoDePublicacao DATETIME not null,
    genero varchar(100) not null,
    editora varchar(255) not null,

    primary key(id)
);