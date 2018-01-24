import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import dateFormat from 'dateformat'
import { getFinished, showContract } from './insuranceActions'

class insuranceFinishedList extends Component {

    componentWillMount(nextProps, nextState) {
        this.props.getFinished()
    }

    renderRows() {
        const list = this.props.finished || []

        return list.map(bc => (
            <tr key={bc.id}>
                <td>{bc.username}</td>
                <td>{bc.insurance}</td>
                <td>{'€ ' + bc.productValue}</td>
                <td>{'€ ' + bc.tariff}</td>
                <td>{dateFormat(bc.created, "dddd, mmmm dS, yyyy, h:MM:ss TT")}</td>
                <td>
                    <button className='btn btn-primary' onClick={() => this.props.showContract(bc)}>
                        <i className='fa fa-eye'></i>
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

const mapStateToProps = state => ({finished: state.insurance.finished})
const mapDispatchToProps = dispatch => bindActionCreators({getFinished, showContract}, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(insuranceFinishedList)