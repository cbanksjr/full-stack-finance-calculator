/** @format */
import { useState } from "react";
import ButtonComponent from "./ButtonComponent";


const FormComponent = () => {
  const [amount, setAmount] = useState("");
  const [percent, setPercent] = useState("");
  const [result, setResult] = useState("0.00");
  const [remaining, setRemaining] = useState("0.00");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (amount < 0 || isNaN(amount)) {
      setAmount(0);
      setPercent(0);
    }

    if (percent < 0 || isNaN(percent)) {
      setPercent(0);
      setAmount(0);
    }

    setResult(amount * (percent / 100));

    setRemaining(amount - amount * (percent / 100));
  };

  return (
    <section className="flex flex-col items-center mt-6">
      <form
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

        <div className="pt-6 space-y-2">
          <p>
            <span className="text-red-500 text-lg font-medium">Allocate: </span>
            <span className="text-center text-lg ml-2 text-red-500 font-medium">
              {result.toLocaleString(undefined, {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
              })}
            </span>
          </p>
          <p>
            <span className="text-green-700 text-lg font-medium">
              Remaining:
            </span>
            <span className="text-center text-lg ml-2 text-green-700 font-medium">
              {remaining.toLocaleString(undefined, {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
              })}
            </span>
          </p>
        </div>
      </form>
    </section>
  );
};

export default FormComponent;
