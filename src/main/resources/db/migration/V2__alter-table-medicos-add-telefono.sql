alter table medicos add telefono varchar(20) not null;
delete from flyway_schema_history where success = 0;