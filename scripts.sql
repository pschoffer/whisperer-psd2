DROP table public.user;

CREATE TABLE public.user(
   id serial PRIMARY KEY,
   email VARCHAR (355) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL,
   birth_date VARCHAR (32) NOT NULL,
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
    iban VARCHAR (128) PRIMARY KEY,
    user_id VARCHAR (128) UNIQUE NOT NULL,
    prefix VARCHAR (32) NOT NULL,
    bank_code VARCHAR (32) NOT NULL,
    bic VARCHAR (32) NOT NULL,
    currency VARCHAR (32) NOT NULL,
    country VARCHAR (32) NOT NULL
);

DROP table public.merchant;
CREATE TABLE public.merchant(
    id VARCHAR (128) PRIMARY KEY,
    name VARCHAR (128) ,
    email VARCHAR (128) ,
    password VARCHAR (128),
    mcc_codes VARCHAR (512),
    zip_code VARCHAR (32)
);

DROP table public.transaction;
CREATE TABLE public.transaction(
    id VARCHAR (128) PRIMARY KEY,
    account_id VARCHAR (128) NOT NULL,
    amount VARCHAR (32) NOT NULL,
    currency VARCHAR (32) NOT NULL,
    merchant_id VARCHAR (32) NOT NULL,
    bookkeeping_date VARCHAR (32),
    mcc_code VARCHAR (32),
    credit_debit_indicator VARCHAR (1),
    installment_indicator VARCHAR (1),
    zip_code VARCHAR (32)
);

--INSERT INTO public.transaction( id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, longitude, latitude)
-- VALUES ('9876', '11', '12', 'EUR', 'TEST-MERCHANT', '07/06/2019', 'SHOPPING', 'D', 'N', '23.6236', '46.7712');

-- HOUSING, GROCERIES, HOUSEHOLD SERVICES, RESTAURANT, SHOPPING, TRANSPORTATION, HEALTH, LEISURE , OTHER
