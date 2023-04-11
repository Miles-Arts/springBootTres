alter table medicos add activo tinyint;
update medicos set activo = 1;
delete from flyway_schema_history where success = 0;