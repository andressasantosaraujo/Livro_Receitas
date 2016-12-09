DROP TABLE IF EXISTS receita

CREATE TABLE receita
(
  id SERIAL,
  titulo VARCHAR(30) NOT NULL,
  ingredientes VARCHAR(100) NOT NULL,
  passo_passo VARCHAR(500) NOT NULL,
  PRIMARY KEY (id)
);