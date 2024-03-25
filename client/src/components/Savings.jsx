import { useEffect, useState } from 'react';
import axios from 'axios';

const Savings = ({ showSavings }) => {
  const [savings, setSavings] = useState([]);

  const fetchSavingsData = async () => {
      await axios.get('http://localhost:8080/api/savings/getSavings')
      .then((response) => {
        response.data;
        setSavings(response.data);
      })
      .catch((err) => {
        console.error('Error fetching savings data: ', err.message);
      });
    };
  

  useEffect(() => {
    fetchSavingsData();
  }, [showSavings]); 

  return (
    <section className='mb-3 ml-3'>
      <div className='flex flex-col items-center justify-center font-semibold duration-300 hover:duration-300 bg-purple-600 md:h-44 md:w-80 h-36 w-64 rounded-lg shadow-lg shadow-slate-600 hover:bg-purple-700'>
        <h1 className='md:text-xl font-bold mb-4'>Savings</h1>
        {savings.length >= 1 ? (
          savings.map((element, index) => (
            <div key={element.id || index} className='text-black'>
              <p>Total Allocated: ${element.totalAllocation}</p>
              <p>Allocation Taken Out: ${element.allocationTakenOut}</p>
              <p>Total Allocation Taken Out: ${element.totalAllocationTakenOut}</p>
            </div>
          ))
        ) : (
          <div className='text-black'>
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
