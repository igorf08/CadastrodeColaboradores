-- Migration utilizada para criar a coluna de img_url, permitindo assim adição de imagens para usuários do db.
ALTER TABLE TB_CADASTRO
ADD COLUMN img_url VARCHAR(2048);