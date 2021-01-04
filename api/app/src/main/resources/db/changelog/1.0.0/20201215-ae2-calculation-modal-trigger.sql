--20201215-ae1-calculation-modal.sql

--changeset aekhin:1
CREATE FUNCTION calculation_modal_increment_and_set_version() RETURNS trigger AS
$$
DECLARE
    result INTEGER;
BEGIN
    result := (SELECT max(calculation_modal.version)
               FROM calculation_modal
               WHERE date_start = NEW.date_start
                 AND date_end = NEW.date_end
                 AND product = NEW.product
                 AND campaign = new.campaign
                 AND crm = new.crm
                 AND channel = new.channel
                 AND playground = new.playground
    );

    RAISE NOTICE 'calculation_modal.version %', result;

    IF result IS NULL THEN
        NEW.version := 1;
    ELSE
        NEW.version := result + 1;
    end if;

    RAISE NOTICE 'new version %', new.version;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER calculation_modal_increment_and_set_version
    BEFORE INSERT
    ON calculation_modal
    FOR EACH ROW
EXECUTE PROCEDURE calculation_modal_increment_and_set_version();

-- Creating the tables:

-- CREATE TABLE dum();
-- CREATE TABLE dee();
-- INSERT INTO dee DEFAULT VALUES;
--
-- -- Making sure the tables stay this way:
-- CREATE FUNCTION dum_trg ()
--     RETURNS trigger
-- AS $$
-- BEGIN
--     RAISE EXCEPTION 'Dum must be empty';
-- END
-- $$ LANGUAGE plpgsql;
--
-- CREATE TRIGGER dum_trg
--     BEFORE INSERT OR UPDATE OR DELETE OR TRUNCATE
--     ON dum
--     FOR EACH STATEMENT
-- EXECUTE PROCEDURE dum_trg();

-- CREATE FUNCTION add(integer, integer) RETURNS integer
-- AS 'select $1 + $2;'
--     LANGUAGE SQL
--     IMMUTABLE
--     RETURNS NULL ON NULL INPUT;


