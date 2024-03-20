-- DROP TABLE pessoa;
CREATE TABLE pessoa (
	id bigserial NOT NULL,
	nome varchar(100) NOT NULL,
	datanascimento date NULL,
	cpf varchar(14) NULL,
	funcionario bool NULL,
	gerente bool NULL,
	CONSTRAINT pk_pessoa PRIMARY KEY (id)
);

-- DROP TABLE projeto;
CREATE TABLE projeto (
	id bigserial NOT NULL,
	nome varchar(200) NOT NULL,
	data_inicio date NULL,
	data_previsao_fim date NULL,
	data_fim date NULL,
	descricao varchar(5000) NULL,
	status varchar(45) NULL,
	orcamento float8 NULL,
	risco varchar(45) NULL,
	idgerente int8 NOT NULL,
	CONSTRAINT pk_projeto PRIMARY KEY (id),
	CONSTRAINT fk_gerente FOREIGN KEY (idgerente) REFERENCES public.pessoa(id)
);

-- DROP TABLE membros;
CREATE TABLE membros (
	idprojeto int8 NOT NULL,
	idpessoa int8 NOT NULL,
	nome varchar(200) NOT NULL,
	cargo varchar(200) NOT NULL,
	CONSTRAINT pk_membros PRIMARY KEY (idprojeto, idpessoa),
	CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa) REFERENCES public.pessoa(id),
	CONSTRAINT fk_membros_projeto FOREIGN KEY (idprojeto) REFERENCES public.projeto(id)
);
