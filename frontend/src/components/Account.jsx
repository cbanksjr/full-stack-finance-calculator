/** @format */

import {useState, useEffect} from "react";
import axios from "axios";

const Account = () => {
    const [account, setAccount] = useState([])
    const fetchAccountData = async () => {
        await axios
            .get("http://localhost:8080/api/account/setAmount/1")
            .then((response) => {
                console.log(response.data);
                setAccount(response.data);
            })
            .catch((error) => console.error(error));
    };



    useEffect(() => {
         fetchAccountData()
    }, []);

    return (
        <section className="flex flex-col items-center col-start-2 row-start-2 text-black">
            <div className="flex flex-col items-center place-content-center bg-white mt-6 p-16 rounded-3xl">
                <h1 className="text-xl font-semibold mb-4">Account</h1>
                {account.map((element, index) => (
                    <div key={element.id || index} className="text-black">
                        <p>Amount: ${element.amount}</p>
                    </div>
                ))}
            </div>
        </section>
    );
};

export default Account;
