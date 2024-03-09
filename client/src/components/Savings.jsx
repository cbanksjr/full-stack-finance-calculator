import React, {useEffect, useState} from 'react'
import axios from 'axios'

const Savings = () => {
    const [savings, setSavings] = useState([]);

    const fetchSavingsData = async () => {
        try {
            const response = await axios.put("http://localhost:8080/api/savings/updateSavings/1"); //USE GET REQUEST
            const data = response.data;
            setSavings(data);
            console.log(data);
        } catch (err) {
            console.error("Error fetching savings data: ", err.message);
        }
    }

    useEffect(() => {
        fetchSavingsData();
    }, []);

  return (
    <section className='flex flex-col'>
    <div className='flex flex-col items-center place-content-center font-semibold duration-300 hover:duration-300 bg-purple-600 mt-6 p-8 rounded-2xl shadow-lg shadow-slate-600 hover:bg-purple-700'>
      <h1 className='text-xl font-bold mb-4'>Savings</h1>

    </div>
    </section>
  )
}

export default Savings