CREATE TABLE characters (
    url VARCHAR NOT NULL,
    name VARCHAR,
    gender VARCHAR(6),
    culture VARCHAR,
    born VARCHAR,
    died VARCHAR,
    titles VARCHAR(50),
    aliases VARCHAR(50),
    father_url BIGINT,
    mother_url BIGINT,
    allegiances VARCHAR(50),
    tv_series VARCHAR(50),
    played_by VARCHAR(50)
);

 ALTER TABLE characters ADD PRIMARY KEY(url);

 ALTER TABLE characters
     ADD FOREIGN KEY (father_url)
     REFERENCES characters(url);

ALTER TABLE characters
    ADD FOREIGN KEY (mother_url)
    REFERENCES characters(url);

ALTER TABLE characters
    ADD FOREIGN KEY (mother_url)
    REFERENCES characters(url);