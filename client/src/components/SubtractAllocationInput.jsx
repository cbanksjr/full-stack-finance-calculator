import React from 'react'
import SubmitButton from './SubmitButton'

const SubtractAllocationInput = ({title}) => {
  return (
    <form className='flex flex-col items-center mt-10'>
        <h1 className='text-xl font-semibold pt-10'>{title}</h1>
        <input
            type="number"
            placeholder="Take out of allocation"
            className="border-4 rounded-md p-2 text-center mt-4" />
            <SubmitButton name="Submit" />
    </form>
  )
}

export default SubtractAllocationInput