/** @format */
import {useState} from "react";
import SubmitButton from "./SubmitButton.jsx";
import axios from "axios";


const Form = () => {
  const [amount, setAmount] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = {amount}
    await axios.post("http://localhost:8000/account", data)
        .then((response) => setAmount(response.data))
        .catch((err) => console.error(err));
    setAmount("")
  };



  return (
    <section className="flex flex-col items-center mt-6 col-start-1">
      <form
         htmlFor="calculator"
        onSubmit={handleSubmit}
        className="flex flex-col items-center space-y-3 bg-white border-2 rounded-lg p-16"
      >
        <label htmlFor="amount" className="text-2xl font-semibold">
          Amount:{" "}
        </label>
        <input
          type="number"
          placeholder="Amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          className="border-4 rounded-md p-2 text-center"
        />

        {/*<label htmlFor="percent" className="text-2xl font-semibold">*/}
        {/*  Percent:{" "}*/}
        {/*</label>*/}
        {/*<input*/}
        {/*  type="number"*/}
        {/*  placeholder="Whole number"*/}
        {/*  value={percent}*/}
        {/*  onChange={(e) => setPercent(e.target.value)}*/}
        {/*  className="border-4 rounded-md p-2 text-center"*/}
        {/*/>*/}

        <SubmitButton name="Submit" />

      </form>
    </section>
  );
};

export default Form;
