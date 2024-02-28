import ExpenseButton from "./ExpenseButton.jsx";
import VacationButton from "./VacationButton.jsx";
import InvestingButton from "./InvestingButton.jsx";
import SavingsButton from "./SavingsButton.jsx";
const Percent = () => {

    return (
        <div className="col-start-1 col-end-3 p-16">
            <div className="flex flex-col items-center bg-white border-2 rounded-lg p-16">
                <h1 className="text-xl font-semibold">What percent would you like to deduct from your account?</h1>
                <form className="mt-10 flex flex-col items-center">
                    <label htmlFor="percent" className="text-2xl font-semibold mb-3">Percent:</label>
                    <input type="number"
                           placeholder="Percent"
                            className="border-4 rounded-md p-2 text-center"/>
                    <div className="flex space-x-3 mt-4">
                        <ExpenseButton  name="Expenses"/>
                        <InvestingButton name="Investments"/>
                        <VacationButton name="Vacation"/>
                        <SavingsButton name="Savings"/>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default Percent
