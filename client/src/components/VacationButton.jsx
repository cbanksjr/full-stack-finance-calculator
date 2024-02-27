const VacationButton = ({name}) => {

    return (
        <div className="pt-4">
            <button className="rounded-md px-8 py-3 text-center font-medium bg-yellow-500 text-white border-2 border-yellow-400 hover:bg-yellow-600 shadow-md shadow-black active:shadow transition ease-in-out hover:translate-y-0.5 hover:scale-100">
                {name}
            </button>
        </div>
    )
}

export default VacationButton