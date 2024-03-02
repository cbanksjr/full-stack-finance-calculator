CREATE DATABASE finance_calculator

CREATE TABLE account (
    amount FLOAT(25) PRIMARY KEY,
    percent_deducted FLOAT(25),
    deducted FLOAT(25),
    remaining FLOAT(25)
);


CREATE TABLE expenses (
    expense_allocation FLOAT(25) PRIMARY KEY
);