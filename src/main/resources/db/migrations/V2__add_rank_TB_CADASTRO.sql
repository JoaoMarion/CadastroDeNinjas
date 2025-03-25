-- V2: Migrations para adicionar a coluna RANK na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(20);