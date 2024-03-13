/** @format */
import Form from "./components/Form.jsx";
import SubtractAllocationInput from "./components/SubtractAllocationInput.jsx";

const App = ({showAccount}) => {

  return (
    <main>
    <h1 className="text-white text-center text-6xl font-bold mb-20">Finance Calculator</h1>
      <div className="flex flex-col items-center bg-white border-2 rounded-lg p-12 shadow-lg shadow-gray-500">
        <Form />
      </div>
    </main>
  );
};

export default App;
