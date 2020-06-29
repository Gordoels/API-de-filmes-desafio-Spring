CREATE TABLE movie (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL,
    id_actor BIGINT(20),
	director VARCHAR(30),
    actor VARCHAR(50),
	original_language VARCHAR(30),
	original_title VARCHAR(50),
	release_year VARCHAR(15),
	overview VARCHAR(250),
	adult BOOLEAN,
    id_genre BIGINT(20) NOT NULL,
    FOREIGN KEY (id_actor) REFERENCES actor(id),
    FOREIGN KEY (id_genre) REFERENCES genre(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
