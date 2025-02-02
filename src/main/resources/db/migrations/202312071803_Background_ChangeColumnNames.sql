--liquibase formatted sql logicalFilePath:db/migrations/202312071803_Background_ChangeColumnNames.sql

--changeset includeAll:raw
ALTER TABLE Background
RENAME COLUMN Detailed to detailed;