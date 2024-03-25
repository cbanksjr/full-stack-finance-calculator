import { useEffect, useState } from 'react';
import axios from 'axios';

const Vacation = ({ showVacation }) => {
    const [vacation, setVacation] = useState([]);
    
    const fetchVacationData = async () => {
        await axios.get('http://localhost:8080/api/vacation/getVacation')
        .then((response) => {
            response.data;
            setVacation(response.data);
        })
        .catch((err) => {
            console.error('Error fetching vacation data: ', err.message);
        });
        };
    
    
    useEffect(() => {
        fetchVacationData();
    }, [showVacation]); 
    
    return (
        <section className='flex flex-col justify-center'>
        <div className='flex flex-col items-center justify-center font-semibold duration-300 hover:duration-300 bg-yellow-500 md:h-44 md:w-80 h-36 w-64 rounded-lg shadow-lg shadow-slate-600 hover:bg-yellow-700'>
            <h1 className='md:text-xl font-bold mb-4'>Vacation</h1>
            {vacation.length >= 1 ? (
            vacation.map((element, index) => (
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

export default Vacation;