import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import dateFormat from 'dateformat'
import { getSimulation, showUpdate, showUpdateStatus, showDelete } from './insuranceActions'

class InsuranceList extends Component {

    componentWillMount(nextProps, nextState) {
        this.props.getSimulation()
    }

    renderRows() {
        const list = this.props.simulation || []

        return list.map(bc => (
            <tr key={bc.id}>
                <td>{bc.username}</td>
                <td>{bc.insurance}</td>
                <td>{'€ ' + bc.productValue}</td>
                <td>{'€ ' + bc.tariff}</td>
                <td>{dateFormat(bc.created, "dddd, mmmm dS, yyyy, h:MM:ss TT")}</td>
                <td>
                    <button className='btn btn-success' onClick={() => this.props.showUpdateStatus(bc)}>
                        <i className='fa fa-check '></i>
                    </button>
                    <button className='btn btn-warning' onClick={() => this.props.showUpdate(bc)}>
                        <i className='fa fa-pencil'></i>
                    </button>
                    <button className='btn btn-danger' onClick={() => this.props.showDelete(bc)}>
                        <i className='fa fa-trash-o'></i>
                    </button>
                </td>
            </tr>
        ))
    }

    render() {
        return (
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Insurance Type</th> 
                            <th>Product value</th>
                            <th>Tariff</th>
                            <th>Created At</th>
                            <th className='table-actions'>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.renderRows()}
                    </tbody>
                </table>
            </div>
        )
    }
}

const mapStateToProps = state => ({simulation: state.insurance.simulation})
const mapDispatchToProps = dispatch => bindActionCreators({getSimulation, showUpdate, showUpdateStatus, showDelete}, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(InsuranceList)