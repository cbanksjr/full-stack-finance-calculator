/** @format */

import { useState, useEffect } from "react";
import SavingsButton from "./SavingsButton";
import ExpenseButton from "./ExpenseButton";
import VacationButton from "./VacationButton";
import Expense from "./Expense";
import Savings from "./Savings";
import Account from "./Account";
import Vacation from "./Vacation";
import axios from "axios";



const SubtractAllocationInput = ({ title, showAccount }) => {
  const [allocationTakenOut, setAllocationTakenOut] = useState([]);
  const [error, setError] = useState("");

  const invalidSubtractedAmount = () => allocationTakenOut === "" || allocationTakenOut <= 0 && "Please enter a valid amount to subtract";

  const updateSavingsData = async (e) => {
    e.preventDefault();
    const savingsData = { allocationTakenOut };
    await axios
      .put(`${process.env.REACT_APP_API_URL}/api/savings/updateSavings`, savingsData)
      .then((response) => {
        response.savingsData;
        setAllocationTakenOut(savingsData);
        setError("");
      })
      .catch((err) => {
        console.error("Error updating savings data: ", err.message);
        setError(err.message);
      });

    setError(invalidSubtractedAmount());
    setAllocationTakenOut("");
  };

  const updateExpensesData = async (e) => {
    e.preventDefault();
    const expensesData = { allocationTakenOut };
    await axios
      .put(`${process.env.REACT_APP_API_URL}/api/expenses/updateExpenses`, expensesData)
      .then((response) => {
        response.expensesData;
        setAllocationTakenOut(expensesData);
        setError("");
      })
      .catch((err) => {
        console.error("Error updating expenses data: ", err.message);
        setError(err.message);
      });

    setError(invalidSubtractedAmount());
    setAllocationTakenOut("");
  };

  const updateVacationData = async (e) => {
    e.preventDefault();
    const vacationData = { allocationTakenOut };
    await axios
      .put(`${process.env.REACT_APP_API_URL}/api/vacation/updateVacation`, vacationData)
      .then((response) => {
        response.vacationData;
        setAllocationTakenOut(vacationData);
        setError("");
      })
      .catch((err) => {
        console.error("Error updating vacation data: ", err.message);
        setError(err.message);
      });

    setError(invalidSubtractedAmount());
    setAllocationTakenOut("");
  };

  useEffect(() => {
    updateSavingsData();
    updateExpensesData();
    updateVacationData();
  }, []);

  return (
    <>
      <div className="xl:flex justify-center items-center p-10">
        <Account showAccount={() => showAccount} />
        <Expense showExpenses={updateExpensesData} />
        <Savings showSavings={updateSavingsData} />
        <Vacation showVacation={updateVacationData} />
      </div>

      <form className="text-center">
        <h1 className="text-sm md:text-xl font-semibold">{title}</h1>
        {error && (
          <p className="text-red-700 font-semibold items-center mt-4">{error}</p>
        )}
        <div className="xl:flex justify-center items-center space-x-4 mb-10 mt-3">
          <input
            type="number"
            placeholder="Amount"
            value={allocationTakenOut}
            onChange={(e) => setAllocationTakenOut(e.target.value)}
            className="border-4 rounded-md p-2 text-center mt-4"
          />
          <ExpenseButton name="Expenses" updateExpenses={updateExpensesData} />
          <SavingsButton name="Savings" updateSavings={updateSavingsData} />
          <VacationButton name="Vacation" updateVacation={updateVacationData} />
        </div>
      </form>
    </>
  );
};

export default SubtractAllocationInput;
