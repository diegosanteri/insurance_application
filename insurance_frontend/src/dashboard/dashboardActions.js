import axios from 'axios'
const BASE_URL = 'http://localhost:8081/api/v1/insurance'

export function getSimulation () {

    return dispatch => {
        axios.get(`${BASE_URL}?simulation=true`)
                .then(response => {

                    dispatch({
                        type: 'SIMULATION_FETCHED',
                        payload: response.data.content
                    })
                })
                .catch(e => {
                    
                    e.response.data.errors.forEach(error => toastr.error('Erro', error))
                })
    }
}

export function getFinished () {
    
        return dispatch => {
            axios.get(`${BASE_URL}?simulation=false`)
                    .then(response => {
    
                        dispatch({
                            type: 'FINISHED_FETCHED',
                            payload: response.data.content
                        })
                    })
                    .catch(e => {
                        
                        e.response.data.errors.forEach(error => toastr.error('Erro', error))
                    })
        }
    }