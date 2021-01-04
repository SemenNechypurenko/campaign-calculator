--20201215-ae1-calculation-modal.sql

--changeset aekhin:1
CREATE TABLE calculation_modal
(
    date_start              DATE         NOT NULL,
    date_end                DATE         NOT NULL,
    product                 VARCHAR(100) NOT NULL,
    campaign                VARCHAR(100) NOT NULL,
    crm                     VARCHAR(100) NOT NULL,
    channel                 VARCHAR(100) NOT NULL,
    playground              VARCHAR(100) NOT NULL,
    format                  VARCHAR(100) NOT NULL,

    budget                  FLOAT        NOT NULL,
    ga_transactions         FLOAT        NOT NULL,
    attr_transactions_model FLOAT        NOT NULL,
    app_transactions        FLOAT        NOT NULL,
    effective_frequency     INTEGER      NOT NULL,
    sales                   FLOAT        NOT NULL,
    average_check           FLOAT        NOT NULL,
    cpa                     FLOAT        NOT NULL,
    romi_ga                 FLOAT        NOT NULL,
    romi_attr_model         FLOAT        NOT NULL,
    income_ga               FLOAT        NOT NULL,
    desktop_ga_transactions FLOAT        NOT NULL,
    mobile_ga_gransactions  FLOAT        NOT NULL,
    tablet_ga_transactions  FLOAT        NOT NULL,
    place                   VARCHAR(100) NOT NULL,
    budget_second           FLOAT        NOT NULL,
    budget_third            FLOAT        NOT NULL,
    budget_fourth           FLOAT        NOT NULL,
    format_second           VARCHAR(100) NOT NULL,
    new_players             FLOAT        NOT NULL,

    version                 INTEGER      NOT NULL,

    PRIMARY KEY (
                 date_start,
                 date_end,
                 product,
                 campaign,
                 crm,
                 channel,
                 playground,
                 format,
                 version
        )
);

