/** @format */

import { useState, useEffect } from "react";
import SavingsButton from "./SavingsButton";
import Savings from "./Savings";
import Account from "./Account";
import axios from "axios";

const SubtractAllocationInput = ({ title, showAccount }) => {
  const [allocationTakenOut, setAllocationTakenOut] = useState([]);

  const updateSavingsData = async (e) => {
    e.preventDefault();
    const savingsData = { allocationTakenOut };
    try {
      const response = await axios.put(
        "http://localhost:8080/api/savings/updateSavings",
        savingsData
      );
      const data = response.data;
      setAllocationTakenOut(data);
    } catch (err) {
      console.error("Error updating savings data: ", err.message);
    }

    setAllocationTakenOut("");
  };

  useEffect(() => {
    updateSavingsData();
  }, []);

  return (
    <>
      <div className="flex flex-wrap space-x-6">
        <Account showAccount={() => showAccount} />
        <Savings showSavings={updateSavingsData} />
      </div>

      <form className="flex justify-center items-center mt-10 pb-10">
        <div className="flex space-x-10">
          <h1 className="text-xl font-semibold pt-10">{title}</h1>
          <input
            type="number"
            placeholder="Amount"
            value={allocationTakenOut}
            onChange={(e) => setAllocationTakenOut(e.target.value)}
            className="border-4 rounded-md p-2 text-center mt-4"
          />
          <SavingsButton
            name="Update Savings"
            updateSavings={updateSavingsData}
          />
        </div>
      </form>
    </>
  );
};

export default SubtractAllocationInput;
