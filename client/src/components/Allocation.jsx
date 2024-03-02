/** @format */
import React, { useState } from "react";
import Form from "./Form";

const Allocation = () => {
  return (
    <div className="p-48">
      <div className="flex flex-col items-center bg-white border-2 rounded-lg p-16">
        <h1 className="text-xl font-semibold">
          Where would you like to allocate your deduction?
        </h1>
        <Form />
      </div>
    </div>
  );
};

export default Allocation;
