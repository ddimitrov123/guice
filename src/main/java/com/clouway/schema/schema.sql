CREATE TABLE cookies
(
    name VARCHAR,
    value VARCHAR,
    expdate BIGINT
);
CREATE TABLE history
(
    transaction VARCHAR(10),
    before_transaction VARCHAR(20) NOT NULL,
    date DATE,
    after_transaction VARCHAR(20) NOT NULL,
    name VARCHAR
);
CREATE TABLE users
(
    name VARCHAR PRIMARY KEY NOT NULL,
    password VARCHAR,
    balance NUMERIC(131089)
);
ALTER TABLE cookies ADD FOREIGN KEY (name) REFERENCES users (name);
ALTER TABLE history ADD FOREIGN KEY (name) REFERENCES users (name);

CREATE OR replace function insertIntoHistory() returns trigger AS $example_table$
BEGIN
if(new.balance > old.balance) then
INSERT INTO history (transaction, before_transaction, date,  after_transaction, name) VALUES ('deposit', old.balance, CURRENT_TIMESTAMP(0), new.balance, old.name);
else
INSERT INTO history (transaction, before_transaction, date,  after_transaction, name) VALUES ('withdraw', old.balance, CURRENT_TIMESTAMP(0), new.balance, old.name);
end if;
return old;
END;
$example_table$ LANGUAGE plpgsql;

CREATE trigger example_trigger after UPDATE ON users FOR each row EXECUTE PROCEDURE insertIntoHistory();