CREATE TABLE filmes (
    id varchar(255) not null primary key,
    titulo varchar(100) not null,
    descricao varchar(500),
    ano_lancamento int,
    genero varchar(50) not null
);

INSERT INTO filmes (id, titulo, descricao, ano_lancamento, genero)
VALUES ('1', 'O Senhor dos Anéis', 'A sociedade do anel inicia a jornada para destruir o Um Anel.', 2001, 'Fantasia');

INSERT INTO filmes (id, titulo, descricao, ano_lancamento, genero)
VALUES ('2', 'Matrix', 'Um hacker descobre a verdade sobre sua realidade.', 1999, 'Ficção Científica');
