-- CRIAÇÃO DO BANCO DE DADOS.
CREATE DATABASE DB_SCF;

-- USANDO O BANCO DE DADOS.
USE DB_SCF;

-- CRIAÇÃO DAS TABELAS.
CREATE TABLE DB_SCF.TblTipoPagamento
(
TIPO_PAGAMENTO TINYINT NOT NULL,
DESCRICAO VARCHAR(20) NOT NULL,
PRIMARY KEY (TIPO_PAGAMENTO)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE DB_SCF.TblContasPagar 
(
ID_CONTA_PAGAR INT NOT NULL AUTO_INCREMENT,
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

CREATE TABLE DB_SCF.TblContasReceber
(
ID_CONTA_RECEBER INT NOT NULL AUTO_INCREMENT, 
DESCRICAO VARCHAR(70) NOT NULL,
VALOR DECIMAL(8,2) NOT NULL,
PRIMARY KEY (ID_CONTA_RECEBER)
)
ENGINE = INNODB DEFAULT CHARSET = UTF8;


-- INSERTS.
INSERT INTO DB_SCF.TblTipoPagamento VALUES (1, 'VALOR TOTAL');
INSERT INTO DB_SCF.TblTipoPagamento VALUES (2, 'VALOR PARCIAL');


-- SELECTS.
SELECT * FROM DB_SCF.TblTipoPagamento;
SELECT * FROM DB_SCF.TblContasPagar;
SELECT * FROM DB_SCF.TblContasReceber;
