/** @format */

import { useState, useEffect } from "react";
import axios from "axios";

const AccountComponent = () => {
  const [account, setAccount] = useState([]);

  useEffect(() => {
    const fetchAccountData = async () => {
      await axios
        .get("http://localhost:8080/api/account/setAmount/1")
        .then((response) => {
          console.log(response.data);
          setAccount(response.data);
        })
        .catch((error) => console.error(error));
    };
    return () => fetchAccountData();
  }, []);

  return (
    <section className="flex flex-col justify-center col-start-1 row-start-2 text-black rounded-lg bg-white">
      <div className="flex flex-col justify-center items-center">
        <h1 className="text-xl font-semibold mb-4">Account</h1>
        {account.map((element, index) => (
          <div key={element.id || index} className="text-black">
            <p>Amount: {element.amount}</p>
            <p>Deducted: {element.deducted}</p>
            <p>Remaining: {element.remaining}</p>
          </div>
        ))}
      </div>
    </section>
  );
};

export default AccountComponent;
