import axios from 'axios'
import { toastr } from 'react-redux-toastr'
import { reset as resetForm, initialize } from 'redux-form'
import { showTabs, selectTab } from '../common/tab/tabActions'

const BASE_URL = 'http://localhost:8081/api/v1/insurance'
const INITIAL_VALUES = {
    simulations: [],
    finished: []
}

export function getSimulation() {
        return dispatch => {
            axios.get(`${BASE_URL}?simulation=true`)
                    .then(response => {
                        dispatch({
                            type: 'INSURANCE_SIMULATION_FETCHED',
                            payload: response
                        })
                    })
                    .catch(error => {
                        e.response.data.errors.forEach(error => toastr.error('Erro', error))
                    })
        }
    
    
}

export function getFinished() {
    return dispatch => {
        axios.get(`${BASE_URL}?simulation=false`)
                .then(response => {
                    dispatch({
                        type: 'INSURANCE_FINISHED_FETCHED',
                        payload: response
                    })
                })
                .catch(error => {
                    e.response.data.errors.forEach(error => toastr.error('Erro', error))
                })
    }
}

export function create(values) {
    return submit(values, 'post')
}

export function update(values) {
    return submit(values, 'put')
}

export function updateStatus(values) {
    return submit(values, 'put', '/status')
}

export function remove(values) {
    return submit(values, 'delete')
}

function submit(values, method, url) {
    
    return dispatch => {
        const id = values.id ? values.id : ''
        const u = url ? '/' + url : ''
        axios[method](`${BASE_URL}/${id}${u}`, values)
            .then(resp => {
                toastr.success('Success', 'Operation has been done successfully')
                if(method == "put" || method == "delete") {
                    dispatch(init())
                    return 
                }
                dispatch(showUpdate(resp.data))
            })
            .catch(e => {
                toastr.error('Error', e.response.data.message)
            })
    }
}

export function showContract(insurance) {
    return [ 
        showTabs('tabContractDetails'),
        selectTab('tabContractDetails'),
        initialize('insuranceForm', insurance)
    ]
}

export function showUpdateStatus(insurance) {
    return [ 
        showTabs('tabUpdateStatus'),
        selectTab('tabUpdateStatus'),
        initialize('insuranceForm', insurance)
    ]
}

export function showPurchasedContracts(insurance) {
    return [ 
        showTabs('tabList', 'tabCreate', 'tabPurchase'),
        selectTab('tabPurchase'),
        initialize('insuranceForm', insurance)
    ]
}

export function showUpdate(insurance) {
    return [ 
        showTabs('tabUpdate'),
        selectTab('tabUpdate'),
        initialize('insuranceForm', insurance)
    ]
}

export function showDelete(insurance) {
    return [ 
        showTabs('tabDelete'),
        selectTab('tabDelete'),
        initialize('insuranceForm', insurance)
    ]
}

export function init() {
    return [
        showTabs('tabList', 'tabCreate', 'tabPurchase'),
        selectTab('tabList'),
        getSimulation(),
        initialize('insuranceForm', INITIAL_VALUES)
    ]
}