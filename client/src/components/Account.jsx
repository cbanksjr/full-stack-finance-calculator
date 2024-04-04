/** @format */

import { useEffect, useState } from "react";
import axios from "axios";

const Account = ({ showAccount }) => {
  const [account, setAccount] = useState([]);

  const fetchAccountData = async () => {
    try {
      const response = await axios.get(
        `${process.env.REACT_APP_API_URL}/api/account/updateAmount`
      );
      const data = response.data;
      setAccount(data);
    } catch (err) {
      console.error("Error fetching account data: ", err.message);
    }
  };

  useEffect(() => {
    fetchAccountData();
  }, [showAccount]);

  return (
    <section className="mb-3 ml-3">
      <div className="flex flex-col justify-center items-center font-semibold duration-300 bg-emerald-400 md:h-44 md:w-80 h-36 w-64 rounded-lg shadow-lg shadow-slate-600 hover:bg-emerald-500 hover:duration-300">
        <h1 className="md:text-xl font-bold mb-4">Account</h1>
        {account.length >= 1 ? (
          account.map((element, index) => (
            <div key={element.id || index} className="text-black">
              <p>Amount: ${element.amount}</p>
              <p>Remaining: ${element.remaining}</p>
            </div>
          ))
        ) : (
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
