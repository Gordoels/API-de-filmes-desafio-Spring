CREATE TABLE movie (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL,
	director VARCHAR(30),
	starring VARCHAR(30),
	original_language VARCHAR(30),
	original_title VARCHAR(50),
	release_date VARCHAR(15),
	overview VARCHAR(250),
	adult BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
