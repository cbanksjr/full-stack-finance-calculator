const SubmitButton = ({onClick}) => {
// CREATE STATE OF BEING CLICKED????
  return (
    <div className="pt-4">
    <button className="rounded-md px-8 py-3 text-center font-medium bg-green-600 text-white border-2 border-green-500 hover:bg-green-800 shadow-md shadow-black active:shadow transition ease-in-out hover:translate-y-0.5 hover:scale-100" 
            type="submit"
            onClick={() => onClick}
            >
      Submit
    </button>
  </div>
  )
}

export default SubmitButton