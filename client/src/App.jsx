/** @format */
import { useState } from "react";
import Allocation from "./components/Allocation.jsx";

const App = () => {

  

  return (
    <main className="flex flex-col">
      <h1 className="text-center mt-28 text-4xl font-bold text-white">
        Finance Calculator
      </h1>
        <Allocation/>
    </main>
    
  );
}

export default App;
