CREATE TABLE character_spouses (
    spouse1_url VARCHAR,
    spouse2_url VARCHAR
);

ALTER TABLE character_spouses
    ADD FOREIGN KEY (spouse1_url)
    REFERENCES characters(url);

ALTER TABLE character_spouses
    ADD FOREIGN KEY (spouse2_url)
    REFERENCES characters(url)