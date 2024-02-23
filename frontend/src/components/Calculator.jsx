/** @format */

import Form from "./Form.jsx";
import Account from "./Account.jsx";
import Percent from "./Percent.jsx";

const Calculator = () => {
  return (
    <main className="grid grid-cols-2 grid-rows-2">
      <h1 className="col-start-1 col-end-3 text-center mt-28 text-4xl font-bold text-white">
        Finance Calculator
      </h1>
        <Form/>
        <Account/>
        <Percent/>
    </main>
  );
};

export default Calculator;
