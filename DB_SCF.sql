CREATE DATABASE DB_SCF;

USE DB_SCF;

CREATE TABLE TblTipoPagamento
(
TIPO_PAGAMENTO TINYINT NOT NULL,
DESCRICAO VARCHAR(20) NOT NULL,
PRIMARY KEY (TIPO_PAGAMENTO)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE TblContasPagar 
(
ID_CONTA_PAGAR INT NOT NULL,
DESCRICAO VARCHAR(70) NOT NULL,
VALOR DECIMAL(8,2) NOT NULL,
DATA_VENCIMENTO DATE NOT NULL,
TIPO_PAGAMENTO TINYINT NOT NULL,
PRIMARY KEY (ID_CONTA_PAGAR),

CONSTRAINT FK_CONTAS_PAGAR_TIPO_PAGAMENTO
FOREIGN KEY (TIPO_PAGAMENTO) 
REFERENCES TblTipoPagamento (TIPO_PAGAMENTO)
ON DELETE NO ACTION 
ON UPDATE NO ACTION
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE TblContasReceber
(
ID_CONTA_RECEBER INT NOT NULL, 
DESCRICAO VARCHAR(70) NOT NULL,
VALOR DECIMAL(8,2) NOT NULL,
PRIMARY KEY (ID_CONTA_RECEBER)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;