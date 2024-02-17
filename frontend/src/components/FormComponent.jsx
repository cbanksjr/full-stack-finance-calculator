/** @format */
import { useState } from "react";
import ButtonComponent from "./ButtonComponent";
import axios from "axios";


const FormComponent = () => {
  const [amount, setAmount] = useState("");
  const [percent, setPercent] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = {amount, percent}
    await axios.post("http://localhost:8080/api/calculator", data)
        .then((response) => response.data)
        .catch((error) => console.log(error));
  setAmount("")
  setPercent("")
  };
  return (
    <section className="flex flex-col items-center mt-6 col-start-2">
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

        <label htmlFor="percent" className="text-2xl font-semibold">
          Percent:{" "}
        </label>
        <input
          type="number"
          placeholder="Whole number"
          value={percent}
          onChange={(e) => setPercent(e.target.value)}
          className="border-4 rounded-md p-2 text-center"
        />

        <ButtonComponent name="Submit" />

      </form>
    </section>
  );
};

export default FormComponent;
