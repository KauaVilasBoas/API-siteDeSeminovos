create table veiculos
(

    id            SERIAL       not null,
    marca          varchar(30) not null,
    modelo         varchar(30) not null ,
    ano_fab_e_mod           varchar(9)   not null,
    versao varchar(100) not null,
    cambio    varchar(15) not null,
    qtdePortas        integer not null,
    combustivel           varchar(15)   not null,
    km   integer,
    placa        varchar(8),
    preco            double precision      not null,
    descricao        varchar(800) not null,
    url varchar(350) not null,

    primary key (id)

);