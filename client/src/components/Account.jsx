/** @format */

import React, { useEffect, useState } from "react";
import axios from "axios";

const Account = ({updateContent}) => {
  const [account, setAccount] = useState([]);
  
  const fetchAccountData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/account/updateAmount");
      const data = response.data;
      setAccount(data);
      if(data.length > 1) {
        setAccount([data[data.length - 1]]);
      }
    } catch (err) {
      console.error("Error fetching account data: ", err.message);
    }
  };

  useEffect(() => {
    fetchAccountData();
  }, [updateContent]);
  
  return (
    <section className="flex flex-col">
      <div className="flex flex-col items-center place-content-center font-semibold duration-300 bg-emerald-400 mt-6 p-8 rounded-2xl shadow-lg shadow-slate-600 hover:bg-emerald-500 hover:duration-300">
        <h1 className="text-xl font-bold mb-4">Account</h1>
        {account.length >= 1 ? account.map((element) => (
          <ul key={element.id} className="text-black">
            <li>Amount: ${element.amount}</li> 
            <li>Amount Remaining: ${element.remaining}</li>
          </ul>
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
