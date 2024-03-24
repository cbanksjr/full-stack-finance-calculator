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

  const updateSavingsData = async (e) => {
    e.preventDefault();
    const savingsData = { allocationTakenOut };
    await axios
      .put("http://localhost:8080/api/savings/updateSavings", savingsData)
      .then((response) => {
        response.savingsData;
        setAllocationTakenOut(savingsData);
        setError("");
      })
      .catch((err) => {
        console.error("Error updating savings data: ", err.message);
        setError(err.message);
      });
    if (allocationTakenOut === "" || allocationTakenOut <= 0) {
      setError("Please enter a valid amount to subtract");
    }

    setAllocationTakenOut("");
  };

  const updateExpensesData = async (e) => {
    e.preventDefault();
    const expensesData = { allocationTakenOut };
    await axios
      .put("http://localhost:8080/api/expenses/updateExpenses", expensesData)
      .then((response) => {
        response.expensesData;
        setAllocationTakenOut(expensesData);
        setError("");
      })
      .catch((err) => {
        console.error("Error updating expenses data: ", err.message);
        setError(err.message);
      });
  };

  const updateVacationData = async (e) => {
    e.preventDefault();
    const vacationData = { allocationTakenOut };
    await axios
      .put("http://localhost:8080/api/vacation/updateVacation", vacationData)
      .then((response) => {
        response.vacationData;
        setAllocationTakenOut(vacationData);
        setError("");
      })
      .catch((err) => {
        console.error("Error updating vacation data: ", err.message);
        setError(err.message);
      });
  };

  useEffect(() => {
    updateSavingsData();
    updateExpensesData();
    updateVacationData();
  }, []);

  return (
    <>
      <div className="flex flex-wrap space-x-6 p-4">
        <Account showAccount={() => showAccount} />
        <Expense showExpenses={updateExpensesData} />
        <Savings showSavings={updateSavingsData} />
        <Vacation showVacation={updateVacationData} />
      </div>

      <form className="flex justify-center items-center mt-10 pb-6">
        <div className="flex space-x-4">
          <h1 className="text-xl font-semibold pt-10">{title}</h1>
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
      {error && (
        <p className="text-red-700 font-semibold items-center">{error}</p>
      )}
    </>
  );
};

export default SubtractAllocationInput;
