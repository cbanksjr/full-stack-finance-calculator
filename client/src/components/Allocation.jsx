/** @format */
import React from "react";
import Form from "./Form";

const Allocation = () => {
  return (
    <div className="p-48">
      <div className="flex flex-col items-center bg-white border-2 rounded-lg p-16 shadow-lg shadow-gray-500">
        <h1 className="text-xl font-semibold">
          Enter your initial amount and percent to deduct from:
        </h1>
        <Form />
      </div>
    </div>
  );
};

export default Allocation;
