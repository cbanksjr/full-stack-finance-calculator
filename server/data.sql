CREATE DATABASE finance_calculator

CREATE TABLE account (
    amount REAL PRIMARY KEY,
    percent_deducted REAL,
    deducted REAL,
    remaining REAL
);


CREATE TABLE expenses (
    expense_allocation REAL PRIMARY KEY
);