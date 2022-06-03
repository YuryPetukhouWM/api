CREATE TABLE house_sworn_members (
    house_url VARCHAR,
    character_url VARCHAR
);

ALTER TABLE house_sworn_members
    ADD FOREIGN KEY (house_url)
    REFERENCES houses(url);

ALTER TABLE house_sworn_members
    ADD FOREIGN KEY (character_url)
    REFERENCES characters(url)