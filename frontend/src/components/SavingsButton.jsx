const SavingsButton = ({name}) => {

    return (
        <div className="pt-4">
            <button className="rounded-md px-8 py-3 text-center font-medium bg-purple-600 text-white border-2 border-purple-500 hover:bg-purple-800 shadow-md shadow-black active:shadow transition ease-in-out hover:translate-y-0.5 hover:scale-100">
                {name}
            </button>
        </div>
    )
}

export default SavingsButton