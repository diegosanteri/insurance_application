const INITIAL_STATE = {simulations: 0, finished: 0}

export default function(state = INITIAL_STATE, action) {
    switch (action.type) {
        case 'SIMULATION_FETCHED':
            return { ...state, simulations: action.payload }
            case 'FINISHED_FETCHED':
            return { ...state, finished: action.payload }
        default:
            return state
    }
}