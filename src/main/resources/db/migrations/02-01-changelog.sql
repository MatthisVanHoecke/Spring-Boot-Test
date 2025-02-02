--liquibase formatted sql logicalFilePath:db/migrations/02-01-changelog.sql

--changeset includeAll:raw
CREATE TABLE test
(
    test_id DECIMAL NOT NULL,
    CONSTRAINT pk_test PRIMARY KEY (test_id)
);

