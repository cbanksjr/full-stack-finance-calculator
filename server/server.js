const PORT = process.env.PORT ?? 8000
const express = require('express')
const cors = require('cors')
const app = express()
const pool = require('./db')


app.use(cors())
app.use(express.json())


app.post('/account', async(req, res) => {
    const { amount } = req.body
    console.log(amount)
    
    try {
        const accountSubmit = await pool.query(
            "INSERT INTO account(amount) VALUES($1)", [amount]
        )
        console.log(accountSubmit)
        res.json(accountSubmit)
    } catch (err) {
        console.error(err)
    }
})

app.get('/getAccount', async (req, res) => {
    try {
        const getAmount = await pool.query("SELECT * FROM account")
        console.log(getAmount);
        res.json(getAmount.rows)
    } catch (err) {
        console.error(err)
    }
})









app.listen(PORT, () => console.log(`Server running on port ${PORT}`))
