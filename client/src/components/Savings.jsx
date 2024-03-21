import { useEffect, useState } from 'react';
import axios from 'axios';

const Savings = ({ showSavings}) => {
  const [savings, setSavings] = useState([]);

  const fetchSavingsData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/savings/getSavings');
      const data = response.data;
      setSavings(data);
    } catch (err) {
      console.error('Error fetching savings data: ', err.message);
    }
  };

  useEffect(() => {
    fetchSavingsData();
  }, [showSavings]); 

  return (
    <section className='flex flex-col justify-center'>
      <div className='flex flex-col items-center justify-center font-semibold duration-300 hover:duration-300 bg-purple-600 h-44 w-80 rounded-2xl shadow-lg shadow-slate-600 hover:bg-purple-700'>
        <h1 className='text-xl font-bold mb-4'>Savings</h1>
        {savings.length >= 1 ? (
          savings.map((element, index) => (
            <div key={element.id || index} className='text-black'>
              <p>Allocation: ${element.allocatedAmount}</p>
              <p>Total Allocated: ${element.totalAllocation}</p>
              <p>Allocation Taken Out: ${element.allocationTakenOut}</p>
              <p>Total Allocation Taken Out: ${element.totalAllocationTakenOut}</p>
            </div>
          ))
        ) : (
          <div className='text-black'>
            <p>Allocation: $0</p>
            <p>Total Allocated: $0</p>
            <p>Allocation Taken Out: $0</p>
            <p>Total Allocation Taken Out: $0</p>
          </div>
        )}
      </div>
    </section>
  );
};

export default Savings;
