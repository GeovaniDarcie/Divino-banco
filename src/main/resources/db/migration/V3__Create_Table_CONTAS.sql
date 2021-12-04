CREATE TABLE IF NOT EXISTS CONTAS(
    numeroDaConta  INT       NOT NULL,
    saldo    NUMERIC(6,2)     NOT NULL,
    tipoDaConta  VARCHAR(8) NOT NULL,
    dataDaConta DATE NOT NULL,
    codigo_cliente INT NOT NULL,
    codigo_banco INT NOT NULL,

    PRIMARY KEY(numeroDaConta),

    FOREIGN KEY(codigo_cliente) REFERENCES PUBLIC.CLIENTES(codigo),
    FOREIGN KEY(codigo_banco) REFERENCES PUBLIC.BANCOS(codigo)
)