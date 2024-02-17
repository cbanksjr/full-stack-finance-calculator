import {useState} from "react";
import axios from 'axios';
const AccountComponent = () => {
    const [amount, setAmount] = useState([])

    const handleSubmit = async (e) => {
        e.preventDefault()
        await axios.get("http://localhost:8080/api/account/setAmount/{id}")
            .then((response) => setAmount(response.data))
            .catch((error) => console.error(error))

        return (
            <section className="bg-amber-500 col-start-1 text-white">
                {amount.map((element) => (
                        <div key={element.id} className="text-white">
                            <p>Account: {element.amount}</p>
                            <p>Deducted: {element.deducted}</p>
                            <p>Remaining: {element.remaining}</p>
                            <button onClick={handleSubmit}>Add To Account</button>
                        </div>
                ))}
            </section>
        )
    }
}

export default AccountComponent
