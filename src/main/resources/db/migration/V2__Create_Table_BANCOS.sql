CREATE TABLE IF NOT EXISTS BANCOS(
    codigo  INT       NOT NULL,
    nome    VARCHAR(40)     NOT NULL,
    agencia INT NOT NULL,

    PRIMARY KEY(codigo)
)