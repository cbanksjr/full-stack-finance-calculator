
const SavingsButton = ({name, handleSubmit, updateSavings}) => {
    return (
        <div className="pt-4">
            <button onClick={handleSubmit ? handleSubmit : updateSavings} className='rounded-md px-8 py-4 text-center font-medium bg-purple-600 text-white border-2 duration-300 hover:duration-300 border-purple-500 hover:bg-purple-700 shadow-md shadow-black active:shadow transition ease-in-out hover:translate-y-0.5 hover:scale-100'>
                {name}
            </button>
        </div>
    )
}

export default SavingsButton;

