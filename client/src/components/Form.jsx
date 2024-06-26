/** @format */

import { useState } from "react";
import SubtractAllocationInput from "./SubtractAllocationInput";
import SavingsButton from "./SavingsButton";
import ExpenseButton from "./ExpenseButton";
import VacationButton from "./VacationButton";
import axios from "axios";

const Form = () => {
  const [initialAmount, setInitialAmount] = useState("");
  const [percent, setPercent] = useState("");

  const [error, setError] = useState("");

  const handleSavingsSubmit = async (e) => {
    e.preventDefault();
    const data = { initialAmount, percent };
        await axios.post(
        `${process.env.REACT_APP_API_URL}/api/savings/allocateToSavings`,
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
      `${process.env.REACT_APP_API_URL}/api/expenses/allocateToExpenses`,
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

  const handleVacationSubmit = async (e) => {
    e.preventDefault();
    const data = { initialAmount, percent };
    await axios.post(
      `${process.env.REACT_APP_API_URL}/api/vacation/allocateToVacation`,
      data
    )
    .then((response) => {
      response.data;
      setInitialAmount(data);
      setPercent(data);
      setError("");
    })
    .catch((error) => {
      console.error("Error posting vacation data: ", error.message);
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
        className="flex flex-col items-center space-y-3 p-6"
      >
        <h1 className="text-xl md:text-4xl font-bold mb-4">Finance Calculator</h1>
        <h1 className="text-sm text-center md:text-xl font-semibold mb-4">
          Enter an amount & percent to deduct:
        </h1>
        <label htmlFor="amount" className="md:text-2xl font-semibold">
          Amount:
        </label>
        <input
          type="number"
          placeholder="Amount"
          value={initialAmount}
          onChange={(e) => setInitialAmount(e.target.value)}
          className="md:border-4 rounded-md p-2 text-center appearance-none"
        />
        <label htmlFor="percent" className="md:text-2xl font-semibold">
          Percent:
        </label>
        <input
          type="number"
          placeholder="Whole number"
          value={percent}
          onChange={(e) => setPercent(e.target.value)}
          className="md:border-4 rounded-md p-2 text-center"
        />

        {error && <p className="text-red-700 font-semibold pt-4">{error}</p>}

        <h1 className="text-sm text-center md:text-2xl font-semibold pt-4">
          Select an allocation category:
        </h1>

        <div className="md:flex md:space-x-4">
          <ExpenseButton name="Expenses" handleSubmit={handleExpensesSubmit} />
          <SavingsButton name="Savings" handleSubmit={handleSavingsSubmit} />
          <VacationButton name="Vacation" handleSubmit={handleVacationSubmit} />
        </div>
      </form>
      <SubtractAllocationInput title="Subtract from allocation here:" />
    </>
  );
};

export default Form;
