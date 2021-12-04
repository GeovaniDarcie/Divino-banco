CREATE TABLE IF NOT EXISTS CLIENTES(
    codigo  INT             NOT NULL,
    nome    VARCHAR(30)     NOT NULL,
    cpf     VARCHAR(18)     NOT NULL, 

    PRIMARY KEY(codigo)
)