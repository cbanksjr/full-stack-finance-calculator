import React, {useState, useEffect} from 'react'
import SavingsButton from './SavingsButton'
import axios from 'axios'

const SubtractAllocationInput = ({title}) => {
  const [allocationTakenOut, setAllocationTakenOut] = useState([]);

    const updateSavingsData = async (e) => {
      e.preventDefault();
      const savingsData = {allocationTakenOut};
      try {
            const response = await axios.put("http://localhost:8080/api/savings/updateSavings/1", savingsData); 
            const data = response.data;
            setAllocationTakenOut(data);
            console.log(data);
        } catch (err) {
            console.error("Error fetching savings data: ", err.message);
        }
    }

    useEffect(() => {
        updateSavingsData();
    }, []);
  return (
    <form className='flex flex-col items-center mt-10'>
        <h1 className='text-xl font-semibold pt-10'>{title}</h1>
        <input
            type="number"
            placeholder="Amount"
            value={allocationTakenOut}
            onChange={(e) => setAllocationTakenOut(e.target.value)}
            className="border-4 rounded-md p-2 text-center mt-4" />

            <SavingsButton name="Update Savings" updateSavings={updateSavingsData} />
    </form>
  )
}

export default SubtractAllocationInput