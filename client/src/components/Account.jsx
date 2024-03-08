/** @format */

import React, { useEffect, useState } from "react";
import axios from "axios";

const Account = () => {
  const [account, setAccount] = useState([]);

  useEffect(() => {
    const fetchAccountData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/account/updateAmount");
        const data = response.data;
        setAccount(data);
      } catch (err) {
        console.error("Error fetching account data: ", err.message);
      }
        
    };
    fetchAccountData();
  }, []);

  return (
    <section className="flex flex-col items-center text-black">
      <div className="flex flex-col items-center place-content-center font-semibold bg-emerald-400 mt-6 p-8 rounded-2xl shadow-xl shadow-slate-600 hover:bg-emerald-500">
        <h1 className="text-xl font-bold mb-4">Account</h1>
        {account.length >= 1 ? account.map((element) => (
          <div className="text-black" key={element.id}>
            <p>Amount: ${element.amount}</p> 
            <p>Amount Remaining: ${element.remaining}</p>
          </div>
        )) : (
          <div className="text-black">
            <p>Amount: $0</p> 
            <p>Amount Remaining: $0</p>
          </div>
        )}
      </div>
    </section>
  );
};

export default Account;
