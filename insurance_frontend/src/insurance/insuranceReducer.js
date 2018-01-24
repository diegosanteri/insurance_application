const INITIAL_STATE = {simulation: [], finished: []}

export default (state = INITIAL_STATE, action) => {

    
    switch (action.type) {
        case 'INSURANCE_SIMULATION_FETCHED':
            return { ...state, simulation: action.payload.data.content }
        case 'INSURANCE_FINISHED_FETCHED':
            return { ...state, finished: action.payload.data.content }
        default:
            return state
    }
}