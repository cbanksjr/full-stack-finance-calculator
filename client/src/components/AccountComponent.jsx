/** @format */

import React, { useEffect, useState } from "react";
import axios from "axios";

const Account = () => {
  const [account, setAccount] = useState([]);
  const [amount, setAmount] = useState(0);

  useEffect(() => {
    const fetchAccountData = async () => {
      await axios
        .get("http://localhost:8080/api/account/updateAmount")
        .then((response) => {
          setAccount(response.data);
        })
        .catch((err) => console.error(err));
    };
    fetchAccountData();
  }, []);


 
  return (
    <section className="flex flex-col items-center text-black">
      <div className="flex flex-col items-center place-content-center font-semibold bg-emerald-400 mt-6 p-8 rounded-2xl shadow-xl shadow-slate-600">
        <h1 className="text-xl font-bold mb-4">Account</h1>
        {account.map((element) => (
          <div className="text-black">
            <p key={element.id}>Amount: ${amount ? amount : element.amount}</p> 
            <p>Amount Remaining: ${element.remaining}</p>
          </div>
        ))}
      </div>
    </section>
  );
};

export default Account;
