DROP table public.merchant;
CREATE TABLE public.merchant(
                                id VARCHAR (128) PRIMARY KEY,
                                name VARCHAR (128) ,
                                email VARCHAR (128) ,
                                password VARCHAR (128),
                                mcc_codes VARCHAR (512),
                                zip_code VARCHAR (32)
);
insert INTO public.merchant (id, name, email, password, mcc_codes, zip_code)
VALUES ('test-merchant', 'Test Merchant', 'test@info.com', '123', 'GROCERIES', '60202');


DROP table public.user;
CREATE TABLE public.user(
   id serial PRIMARY KEY,
   email VARCHAR (355) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL,
   birth_date date NOT NULL,
   gender VARCHAR (1) NOT NULL,
   zip_code VARCHAR (32),
   city VARCHAR (32),
   country VARCHAR (32),
   api_token VARCHAR (256)
);

INSERT INTO public.USER (id, email, password, birth_date, gender, zip_code, city, country, api_token)
VALUES (1, 'test@test.com', '123', '12/07/1989', 'M', '16865', 'STOCKHOLM', 'SWEDEN', '127e1e83-5ccf-4474-a86e-f3da61b150cb');

DROP table public.account;
CREATE TABLE public.account(
    id int PRIMARY KEY,
    iban VARCHAR (128),
    user_id VARCHAR (128) UNIQUE NOT NULL,
    prefix VARCHAR (32) NOT NULL,
    bank_code VARCHAR (32) NOT NULL,
    bic VARCHAR (32) NOT NULL,
    currency VARCHAR (32) NOT NULL,
    country VARCHAR (32) NOT NULL
);
INSERT into public.account (id, iban, user_id, prefix, bank_code, bic, currency, country)
VALUES (1, 'SE35 5000 0000 0549 1000 0003', 1, '5402', 'SE23', 'SEB', 'SEK', 'SWE');


DROP table public.transaction;
CREATE TABLE public.transaction(
    id VARCHAR (128) PRIMARY KEY,
    account_id int NOT NULL,
    amount VARCHAR (32) NOT NULL,
    currency VARCHAR (32) NOT NULL,
    merchant_id VARCHAR (32) NOT NULL,
    bookkeeping_date date NOT NULL ,
    mcc_code VARCHAR (32),
    credit_debit_indicator VARCHAR (1),
    installment_indicator VARCHAR (1),
    zip_code VARCHAR (32)
);
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1234', 1, 12, 'EUR', 'test-merchant', '07/06/2019', 'GROCERIES', 'D', 'N', '60202')

-- HOUSING, GROCERIES, HOUSEHOLD SERVICES, RESTAURANT, SHOPPING, TRANSPORTATION, HEALTH, LEISURE , OTHER
