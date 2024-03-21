/** @format */
import Form from "./components/Form.jsx";
import SubtractAllocationInput from "./components/SubtractAllocationInput.jsx";

const App = ({ showAccount }) => {
  return (
    <main className="p-16">
      <div className="flex flex-col items-center bg-gradient-to-tl from-blue-300 to-blue-600 rounded-lg p-12 shadow-lg shadow-gray-500">
        <Form />
      </div>
    </main>
  );
};

export default App;
