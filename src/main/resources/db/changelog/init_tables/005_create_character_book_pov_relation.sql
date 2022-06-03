CREATE TABLE book_character_pov (
    book_url VARCHAR,
    character_url VARCHAR
);

ALTER TABLE book_character
    ADD FOREIGN KEY (book_url)
    REFERENCES books(url);

ALTER TABLE book_character
    ADD FOREIGN KEY (character_url)
    REFERENCES characters(url)