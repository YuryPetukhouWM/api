CREATE TABLE books (
    url VARCHAR NOT NULL,
    name VARCHAR,
    isbn VARCHAR,
    authors VARCHAR,
    number_of_pages INTEGER,
    publisher VARCHAR,
    country CHAR(50),
    media_type CHAR(20),
    released TIMESTAMP
);

ALTER TABLE books ADD PRIMARY KEY(url)