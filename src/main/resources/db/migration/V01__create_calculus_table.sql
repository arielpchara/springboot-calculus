CREATE SEQUENCE calculus_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE calculus (
    id integer NOT NULL DEFAULT nextval('calculus_id_seq'::regclass),
    firstNumber numeric,
    secondNumber numeric,
    result numeric,
    operation character varying,
    CONSTRAINT calculus_pkey PRIMARY KEY (id)
);

INSERT INTO calculus VALUES(DEFAULT, 1, 10, 11, 'sum');