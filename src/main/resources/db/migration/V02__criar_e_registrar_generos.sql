CREATE TABLE genre (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	rating VARCHAR(100),
	description VARCHAR(350)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;