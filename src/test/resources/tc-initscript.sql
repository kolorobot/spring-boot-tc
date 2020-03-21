DROP TABLE IF EXISTS owners;
CREATE TABLE owners (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
);

INSERT INTO owners VALUES (1, 'John', 'Doe', '110 W. Liberty St.', 'Madison', '6085551023');