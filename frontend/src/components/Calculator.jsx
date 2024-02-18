/** @format */

import FormComponent from "./FormComponent";
import AccountComponent from "./AccountComponent";

const Calculator = () => {
  return (
    <main className="grid grid-cols-2">
      <h1 className="col-start-1 col-end-3 text-center mt-16 text-4xl font-bold text-white">
        Finance Calculator
      </h1>
      <FormComponent/>
        <AccountComponent/>
    </main>
  );
};

export default Calculator;
