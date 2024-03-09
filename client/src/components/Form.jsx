/** @format */

import React, { useState } from "react";
import Account from "./Account";
import Savings from "./Savings";
import SubtractAllocationInput from "./SubtractAllocationInput";
import ExpenseButton from "./ExpenseButton";
import SavingsButton from "./SavingsButton";
import axios from "axios";

const Form = () => {
  const [initialAmount, setInitialAmount] = useState("");
  const [percent, setPercent] = useState("");
  const [submitted, setSubmitted] = useState(false);

  const handleSavingsSubmit = async (e) => {
    e.preventDefault();
    const data = { initialAmount, percent };
    await axios
      .post("http://localhost:8080/api/savings/allocateToSavings", data)
      .then((response) => {
        setInitialAmount(response.data);
        setPercent(response.data);
        setSubmitted(true);
      })
      .catch((err) => console.error(err));
    setInitialAmount("");
    setPercent("");
  };

  return (
    <>
      <form
        htmlFor="calculator"
        className="flex flex-col items-center space-y-3 p-12"
      >
        <label htmlFor="amount" className="text-2xl font-semibold">
          Amount:
        </label>
        <input
          type="number"
          placeholder="Amount"
          value={initialAmount}
          onChange={(e) => setInitialAmount(e.target.value)}
          className="border-4 rounded-md p-2 text-center"
        />
        <label htmlFor="percent" className="text-2xl font-semibold">
          Percent:
        </label>
        <input
          type="number"
          placeholder="Whole number"
          value={percent}
          onChange={(e) => setPercent(e.target.value)}
          className="border-4 rounded-md p-2 text-center"
        />

        <div className="flex space-x-4 pt-4">
          <ExpenseButton />
          <SavingsButton name="Savings" handleSubmit={handleSavingsSubmit} />
        </div>
      </form>
      <div className="flex flex-wrap space-x-4">
        <Account updateContent={submitted} />
        <Savings />
      </div>

      <SubtractAllocationInput title="Subtract from allocation here:" />
    </>
  );
};

export default Form;
