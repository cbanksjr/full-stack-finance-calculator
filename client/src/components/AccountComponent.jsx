/** @format */

import { useState, useEffect } from "react";
import axios from "axios";

const Account = () => {
  const [account, setAccount] = useState([]);

  useEffect(() => {
  const fetchAccountData = async () => {
    await axios
      .get("http://localhost:8000/getAccount")
      .then((response) => {
        console.log(response.data);
        setAccount(response.data);
      })
      .catch((err) => console.error(err));
  };

  
    return () => fetchAccountData();
  }, []);

  return (
    <section className="flex flex-col items-center col-start-2 row-start-2 text-black">
      <div className="flex flex-col items-center place-content-center bg-white mt-6 p-16 rounded-3xl">
        <h1 className="text-xl font-semibold mb-4">Account</h1>

        {account.map((element) => (
          <div className="text-black">
            <p key={element.id}>Amount: ${element.amount}</p>
            <p>Amount Remaining: ${element.remaining}</p>
          </div>
        ))}
      </div>
    </section>
  );
};

export default Account;
