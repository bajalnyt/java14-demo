DROP TABLE IF EXISTS PEOPLE;

CREATE TABLE PEOPLE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  emotional_state INT NOT NULL
);