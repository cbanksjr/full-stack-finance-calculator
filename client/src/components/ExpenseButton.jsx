/** @format */

const ExpenseButton = ({ name, handleSubmit, updateExpenses }) => {
  return (
    <div className="pt-4">
      <button onClick={handleSubmit ? handleSubmit : updateExpenses} className="rounded-md px-6 py-4 text-center font-medium duration-300 hover:duration-300 bg-blue-600 text-white border-2 border-blue-400 hover:bg-blue-800 shadow-md shadow-black active:shadow transition ease-in-out hover:translate-y-0.5 hover:scale-100">
        {name}
      </button>
    </div>
  );
};

export default ExpenseButton;
