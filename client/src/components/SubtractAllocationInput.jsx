/** @format */

import { useState, useEffect } from "react";
import SavingsButton from "./SavingsButton";
import Expense from "./Expense";
import Savings from "./Savings";
import Account from "./Account";
import axios from "axios";
import ExpenseButton from "./ExpenseButton";

const SubtractAllocationInput = ({ title, showAccount }) => {
  const [allocationTakenOut, setAllocationTakenOut] = useState([]);
  const [error, setError] = useState("");

  const updateSavingsData = async (e) => {
    e.preventDefault();
    const savingsData = { allocationTakenOut };
      await axios.put(
        "http://localhost:8080/api/savings/updateSavings",
        savingsData
      )
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
    await axios.put("http://localhost:8080/api/expenses/updateExpenses", expensesData)
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

  useEffect(() => {
    updateSavingsData();
    updateExpensesData();
  }, []);

  return (
    <>
      <div className="flex flex-wrap space-x-6 p-4">
        <Account showAccount={() => showAccount} />
        <Savings showSavings={updateSavingsData} />
        <Expense showExpenses={updateExpensesData} />
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
          <SavingsButton
            name="Savings"
            updateSavings={updateSavingsData}
          />
          <ExpenseButton name="Expenses" updateExpenses={updateExpensesData} />
        </div>
      </form>
          {error && <p className="text-red-700 font-semibold items-center">{error}</p>}
    </>
  );
  };

export default SubtractAllocationInput;
