create schema comercio;

use comercio;

create user 'teste'@'localhost' identified by 'teste123';

grant select, insert, delete, update on comercio.* to teste@'localhost';

create table emp_empresa (
  emp_id bigint unsigned not null auto_increment,
  emp_nome varchar(20) not null,
  emp_setor varchar(20) not null,
  primary key (emp_id),
  unique key uni_emp_nome (emp_nome)
);

create table for_fornecedor (
  for_id bigint unsigned not null auto_increment,
  for_nome varchar(20) not null,
  primary key (for_id),
  unique key uni_for_nome (for_nome)
);

create table emf_empresa_fornecedor (
  emp_id bigint unsigned not null,
  for_id bigint unsigned not null,
  primary key (emp_id, for_id),
  foreign key emp_empresa_fk (emp_id) references emp_empresa (emp_id) on delete restrict on update cascade,
  foreign key for_fornecedor_fk (for_id) references for_fornecedor (for_id) on delete restrict on update cascade
);
