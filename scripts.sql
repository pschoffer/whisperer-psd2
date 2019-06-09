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
   id int PRIMARY KEY,
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
VALUES (1, 'test@test.com', '123', '1989-07-12', 'M', '16865', 'STOCKHOLM', 'SWEDEN', '127e1e83-5ccf-4474-a86e-f3da61b150cb');
INSERT INTO public.USER (id, email, password, birth_date, gender, zip_code, city, country, api_token)
VALUES (2, 'richer@test.com', '123', '1992-07-12', 'F', '16865', 'STOCKHOLM', 'SWEDEN', '127e1e83-5ccf-4474-a86e-f3da61b151771');
INSERT INTO public.USER (id, email, password, birth_date, gender, zip_code, city, country, api_token)
VALUES (3, 'ercument@hello.com', '123', '1969-07-12', 'M', '12811', 'STOCKHOLM', 'SWEDEN', '127e1e83-5ccf-4474-a86e-f3da613783872');
INSERT INTO public.USER (id, email, password, birth_date, gender, zip_code, city, country, api_token)
VALUES (4, 'hello@hello.com', '123', '1979-07-12', 'M', '12811', 'STOCKHOLM', 'SWEDEN', '127e1e83-5ccf-4474-a86e-asdasda2');

DROP table public.account;
CREATE TABLE public.account(
    id int PRIMARY KEY,
    iban VARCHAR (128),
    user_id int UNIQUE NOT NULL,
    prefix VARCHAR (32) NOT NULL,
    bank_code VARCHAR (32) NOT NULL,
    bic VARCHAR (32) NOT NULL,
    currency VARCHAR (32) NOT NULL,
    country VARCHAR (32) NOT NULL
);
INSERT into public.account (id, iban, user_id, prefix, bank_code, bic, currency, country)
VALUES (1, 'SE35 5000 0000 0549 1000 0003', 1, '5402', 'SE23', 'SEB', 'EUR', 'SWE');
INSERT into public.account (id, iban, user_id, prefix, bank_code, bic, currency, country)
VALUES (2, 'SE35 5000 0000 0549 2030 1922', 2, '5402', 'SE23', 'SEB', 'EUR', 'SWE');
INSERT into public.account (id, iban, user_id, prefix, bank_code, bic, currency, country)
VALUES (3, 'SE35 5000 0000 0524 5106 9810', 3, '5402', 'SE23', 'SEB', 'EUR', 'SWE');
INSERT into public.account (id, iban, user_id, prefix, bank_code, bic, currency, country)
VALUES (4, 'SE35 5000 0000 1223 5106 1832', 4, '5402', 'SE23', 'SEB', 'EUR', 'SWE');


DROP table public.transaction;
CREATE TABLE public.transaction(
    id VARCHAR (128) PRIMARY KEY,
    account_id int NOT NULL,
    amount numeric NOT NULL,
    currency VARCHAR (32) NOT NULL,
    merchant_id VARCHAR (32) NOT NULL,
    bookkeeping_date date NOT NULL ,
    mcc_code VARCHAR (32),
    credit_debit_indicator VARCHAR (1),
    installment_indicator VARCHAR (1),
    zip_code VARCHAR (32)
);
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1234', 1, 18004, 'EUR', 'test-merchant', '2019-07-06', 'GROCERIES', 'D', 'N', '60202');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1235', 1, 9908, 'EUR', 'test-merchant', '2019-08-06', 'SHOPPING', 'C', 'N', '60202');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1236', 1, 1200, 'EUR', 'test-merchant', '2019-01-06', 'SHOPPING', 'C', 'N', '60202');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1237', 1, 8711, 'EUR', 'test-merchant', '2019-01-06', 'RESTAURANT', 'C', 'N', '60202');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1238', 1, 999, 'EUR', 'test-merchant', '2019-01-06', 'HEALTH', 'C', 'N', '60202');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1239', 2, 12081, 'EUR', 'test-merchant', '2019-01-05', 'RESTAURANT', 'C', 'N', '60203');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1240', 3, 11920, 'EUR', 'test-merchant', '2019-03-05', 'RESTAURANT', 'C', 'N', '60203');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1241', 3, 1523, 'EUR', 'test-merchant', '2019-03-05', 'GROCERIES', 'C', 'N', '60203');
INSERT INTO public.transaction (id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code)
VALUES ('1242', 4, 24000, 'EUR', 'test-merchant', '2019-03-05', 'LEISURE', 'D', 'N', '60203');

-- HOUSING, GROCERIES, HOUSEHOLD SERVICES, RESTAURANT, SHOPPING, TRANSPORTATION, HEALTH, LEISURE , OTHER
