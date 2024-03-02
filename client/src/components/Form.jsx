import React, {useState} from 'react'
import SubmitButton from './SubmitButton'
import Account from './AccountComponent';
import ExpenseButton from './ExpenseButton';
import axios from 'axios';

const Form = () => {
    const [amount, setAmount] = useState("");
    const [percent, setPercent] = useState("")
    const [submitted, setSubmitted] = useState(false)
    
      const handleSubmit = async (e) => {
        e.preventDefault();
        const data = {amount, percent};
        await axios
          .post("http://localhost:8000/account", data)
          .then((response) => {
            setAmount(response.data)
            setPercent(response.data)
            setSubmitted(true)
          })
          .catch((err) => console.error(err));
       setAmount("");
       setPercent("");
      };
    

  return (
      <>
        <form
        onSubmit={handleSubmit}
          htmlFor="calculator"
          className="flex flex-col items-center space-y-3 p-12"
        >
          <label htmlFor="amount" className="text-2xl font-semibold">
            Amount:
          </label>
          <input
            type="number"
            placeholder="Amount"
            value={amount}
            onChange={e => setAmount(e.target.value)}
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
          <div className='flex space-x-4'>
          <SubmitButton onClick={handleSubmit}/>
          <ExpenseButton />
          </div>
        </form>
        {/* CREATE LOGIC TO DISPLAY OTHER BUTTONS BASED ON CLICK OF THAT BUTTON???? */}
      {submitted && <Account/>}

  </>
    
  )
}

export default Form