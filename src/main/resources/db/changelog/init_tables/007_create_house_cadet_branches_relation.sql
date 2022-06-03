CREATE TABLE house_cadet_branches (
    house_url VARCHAR,
    cadet_branch_url VARCHAR
);

ALTER TABLE house_cadet_branches
    ADD FOREIGN KEY (house_url)
    REFERENCES houses(url);

ALTER TABLE house_cadet_branches
    ADD FOREIGN KEY (cadet_branch_url)
    REFERENCES houses(url)