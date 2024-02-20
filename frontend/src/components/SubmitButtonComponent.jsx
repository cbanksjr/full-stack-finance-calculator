/* eslint-disable react/prop-types */

const SubmitButtonComponent = ({name}) => {

  return (
    <div className="pt-4">
    <button className="rounded-md px-8 py-3 text-center font-medium bg-green-600 text-white border-2 border-green-500 hover:bg-green-800">
      {name}
    </button>
  </div>
  )
}

export default SubmitButtonComponent