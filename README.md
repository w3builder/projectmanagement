# projectmanagement

* Correção realizada no sript abaixo pois o antigo apresentava erro na definição da chave composta Também foi incluido mais dois campos (nome, cargo) como indicado.

`-- -----------------------------------------------------`<br/>
`-- Table Membros CORRIGIDA`<br/>
`-- -----------------------------------------------------`<br/>

`CREATE TABLE public.membros (`<br/>
	`idprojeto int8 NOT NULL`,<br/>
	`idpessoa int8 NOT NULL`,<br/>
	`nome varchar(200) NOT NULL`,<br/>
	`cargo varchar(200) NOT NULL`,<br/>
	`CONSTRAINT pk_membros PRIMARY KEY (idprojeto, idpessoa)`,<br/>
	`CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa) REFERENCES public.pessoa(id)`,<br/>
	`CONSTRAINT fk_membros_projeto FOREIGN KEY (idprojeto) REFERENCES public.projeto(id)`<br/>
`);`


`-- -----------------------------------------------------`<br/>
`-- Table Membros ANTIGA COM ERRO NA DEFINIÇÃO DA CHAVE`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE membros`<br/>
`( idprojeto bigint NOT NULL, `<br/>
`idpessoa bigint NOT NULL,  `<br/>
`CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto),`<br/>
`CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa)`<br/>
`REFERENCES projeto (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION,`<br/>
`CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa)`<br/>
`REFERENCES pessoa (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION);`<br/>


