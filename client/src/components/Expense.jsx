import { useState, useEffect } from "react"
import axios from "axios"

const Expense = ({ showExpenses }) => {
    const [expense, setExpense] = useState([]);

    const fetchExpenseData = async () => {
        await axios.get('http://localhost:8080/api/expenses/getExpenses')
            .then((response) => {
                response.data;
                setExpense(response.data);
            })
            .catch((error) => {
                console.error('Error fetching expense data: ', error.message);
            });
    };

    useEffect(() => {
        fetchExpenseData();
    }, [showExpenses]); 

  return (
    <section className="mb-3 ml-3">
        <div className="flex flex-col items-center justify-center font-semibold duration-300 hover:duration-300 bg-blue-600 md:h-44 md:w-80 h-36 w-64 rounded-lg shadow-lg shadow-slate-600 hover:bg-blue-700">
            <h1 className="md:text-xl font-bold mb-4">Expenses</h1>
            {expense.length >= 1 ? (
                expense.map((element, index) => (
                    <div key={element.id || index} className="text-black">
                        <p>Total Allocated: ${element.totalAllocation}</p>
                        <p>Allocation Taken Out: ${element.allocationTakenOut}</p>
                        <p>Total Allocation Taken Out: ${element.totalAllocationTakenOut}</p>
                    </div>
                ))
            ) : (
                <div className="text-black">
                    <p>Total Allocated: $0</p>
                    <p>Allocation Taken Out: $0</p>
                    <p>Total Allocation Taken Out: $0</p>
                </div>
            )}
        </div>
    </section>
  )
}

export default Expense