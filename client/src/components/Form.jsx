import React, {useState} from 'react';
import Account from './AccountComponent';
import ExpenseButton from './ExpenseButton';
import AllocationButton from './SavingsButton';
import axios from 'axios';

const Form = () => {
    const [initialAmount, setInitialAmount] = useState("");
    const [percent, setPercent] = useState("")
    
      const handleSavingsSubmit = async (e) => {
        e.preventDefault();
        const data = {initialAmount, percent};
        await axios
          .post("http://localhost:8080/api/savings/allocateToSavings", data)
          .then((response) => {
            setInitialAmount(response.data)
            setPercent(response.data)
          })
          .catch((err) => console.error(err));
       setInitialAmount("");
       setPercent("");
      };
    

  return (
      <>
        <form
          htmlFor="calculator"
          className="flex flex-col items-center space-y-3 p-12"
        >
          <label htmlFor="amount" className="text-2xl font-semibold">
            Amount:
          </label>
          <input
            type="number"
            placeholder="Amount"
            value={initialAmount}
            onChange={e => setInitialAmount(e.target.value)}
            className="border-4 rounded-md p-2 text-center"
          />

          <label htmlFor="percent" className="text-2xl font-semibold">
            Percent:
          </label>
          <input
            type="number"
            placeholder="Whole number"
            value={percent}
            onChange={e => setPercent(e.target.value)}
            className="border-4 rounded-md p-2 text-center"
          />
          <div className='flex space-x-4 pt-4'>
          <AllocationButton name="Savings" handleSubmit={handleSavingsSubmit}/>
          <ExpenseButton/>
          </div>
        </form>
        {/* CREATE LOGIC TO DISPLAY OTHER BUTTONS BASED ON CLICK OF THAT BUTTON???? */}
      <Account/>

  </>
    
  )
}

export default Form