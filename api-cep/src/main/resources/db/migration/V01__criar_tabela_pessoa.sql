CREATE TABLE endereco (
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
cep VARCHAR(50) NOT NULL,
numero VARCHAR(30),
lagradouro VARCHAR(30),
complemento VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO enderecos (id, cep , numero, lagradouro, complemento) values ('69080-020', '45', 'Castro barroso', 'casa');