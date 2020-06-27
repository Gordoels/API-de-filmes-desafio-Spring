CREATE TABLE categoria(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (name) values ('action');
INSERT INTO categoria (name) values ('drama');
INSERT INTO categoria (name) values ('kids');
INSERT INTO categoria (name) values ('horror');
INSERT INTO categoria (name) values ('comedy');
INSERT INTO categoria (name) values ('other');