/** @format */

import { useState } from "react";
import SubtractAllocationInput from "./SubtractAllocationInput";
import SavingsButton from "./SavingsButton";
import ExpenseButton from "./ExpenseButton";
import axios from "axios";

const Form = () => {
  const [initialAmount, setInitialAmount] = useState("");
  const [percent, setPercent] = useState("");

  const [error, setError] = useState("");

  const handleSavingsSubmit = async (e) => {
    e.preventDefault();
    const data = { initialAmount, percent };
        await axios.post(
        "http://localhost:8080/api/savings/allocateToSavings",
        data
      )
      .then((response) => {
      response.data;
      setInitialAmount(response.data);
      setPercent(response.data);
      setError("");
    })
    .catch((error) => {
      console.error("Error posting savings data: ", error.message);
      setError(error.message);
    });

    if (
      initialAmount === "" ||
      initialAmount <= 0 ||
      percent === "" ||
      percent <= 0
    ) {
      setError("Please enter a valid amount and percent");
    };

    setInitialAmount("");
    setPercent("");
  };

  const handleExpensesSubmit = async (e) => {
    e.preventDefault();
    const data = { initialAmount, percent };
    await axios.post(
      "http://localhost:8080/api/expenses/allocateToExpenses",
      data
    )
    .then((response) => {
      response.data;
      setInitialAmount(data);
      setPercent(data);
      setError("");
    })
    .catch((error) => {
      console.error("Error posting expenses data: ", error.message);
      setError(error.message);
    });

    if (
      initialAmount === "" ||
      initialAmount <= 0 ||
      percent === "" ||
      percent <= 0
    ) {
      setError("Please enter a valid amount and percent");
    };

    setInitialAmount("");
    setPercent("");
  };

  return (
    <>
      <form
        htmlFor="calculator"
        className="md:flex flex-col items-center space-y-3 p-12"
      >
        <h1 className="text-5xl font-bold mb-6">Finance Calculator</h1>
        <h1 className="text-xl font-semibold mb-4">
          Enter your initial amount and percent to deduct from:{" "}
        </h1>
        <label htmlFor="amount" className="text-2xl font-semibold">
          Amount:
        </label>
        <input
          type="number"
          placeholder="Amount"
          value={initialAmount}
          onChange={(e) => setInitialAmount(e.target.value)}
          className="border-4 rounded-md p-2 text-center appearance-none"
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

        {error && <p className="text-red-700 font-semibold pt-4">{error}</p>}

        <h1 className="font-semibold text-xl pt-12">
          Select where you would like to allocate your deduction:
        </h1>

        <div className="flex space-x-4 pt-2">
          <SavingsButton name="Savings" handleSubmit={handleSavingsSubmit} />
          <ExpenseButton name="Expenses" handleSubmit={handleExpensesSubmit} />
        </div>
      </form>
      <SubtractAllocationInput title="Subtract from allocation here:" />
    </>
  );
};

export default Form;
