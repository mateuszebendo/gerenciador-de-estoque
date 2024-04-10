CREATE TABLE funcionarios (
    id_funcionario SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    salario FLOAT NOT NULL,
    bonus_comissao FLOAT NOT NULL
);

CREATE TABLE clientes (
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereço VARCHAR(255) NOT NULL,
    credito_disponível FLOAT NOT NULL DEFAULT 0.0,
    dívida FLOAT NOT NULL DEFAULT 0.0
);

CREATE TABLE itens (
    id_item SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    estoque INT NOT NULL,
    preco_custo FLOAT NOT NULL,
    preco_venda FLOAT NOT NULL
);

CREATE TABLE vendas (
    id_venda SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    id_funcionario INT NOT NULL,
    id_cliente INT NOT NULL,
    id_item INT NOT NULL,
    preco_total FLOAT NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id_funcionario),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_item) REFERENCES itens(id_item)
);

insert into funcionarios (nome, email, senha, cargo, salario, bonus_comissao) values (
	'Luiz Miele',
	'luiz.miele@hotmail.com',
	'1212',
	'safado',
	1200.12,
	0.2
);

