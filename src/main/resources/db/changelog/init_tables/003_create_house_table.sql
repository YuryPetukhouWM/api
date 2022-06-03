CREATE TABLE houses (
    url VARCHAR NOT NULL,
    name VARCHAR,
    region CHAR(50),
    coat_of_arms VARCHAR,
    words VARCHAR,
    titles VARCHAR(50) ARRAY,
    seats VARCHAR(50) ARRAY,
    current_lord_url VARCHAR,
    heir_url VARCHAR,
    overlord_url VARCHAR,
    founded CHAR(8),
    founder_url VARCHAR,
    died_out CHAR(8),
    ancestral_weapons VARCHAR(50) ARRAY
);

ALTER TABLE houses ADD PRIMARY KEY(url);

ALTER TABLE houses
    ADD FOREIGN KEY (current_lord_url)
    REFERENCES characters(url);

ALTER TABLE houses
    ADD FOREIGN KEY (heir_url)
    REFERENCES characters(url);

ALTER TABLE houses
    ADD FOREIGN KEY (overlord_url)
    REFERENCES characters(url);

ALTER TABLE houses
    ADD FOREIGN KEY (founder_url)
    REFERENCES characters(url);