-- V2: Migrations para adicionar a coluna de contratação na tabela de cadastros.

ALTER TABLE TB_CADASTRO
ADD COLUMN modelo_contratacao VARCHAR(255);