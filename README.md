# projectmanagement

Correção realizada no sript abaixo pois o antigo apresentava <br />
erro na definição da chave composta

CREATE TABLE public.membros (<br />
	idprojeto int8 NOT NULL,<br />
	idpessoa int8 NOT NULL,<br />
	nome varchar(200) NOT NULL,<br />
	cargo varchar(200) NOT NULL,<br />
	CONSTRAINT pk_membros PRIMARY KEY (idprojeto, idpessoa),<br />
	CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa) REFERENCES public.pessoa(id),<br />
	CONSTRAINT fk_membros_projeto FOREIGN KEY (idprojeto) REFERENCES public.projeto(id)<br />
);
