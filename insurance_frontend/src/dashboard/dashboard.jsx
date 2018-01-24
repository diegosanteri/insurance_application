import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'

import { getSimulation, getFinished } from './dashboardActions'
import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import ValueBox from  '../common/widget/valueBox'
import Row from  '../common/layout/row'

class Dashboard extends Component {

    componentWillMount() {
        this.props.getSimulation()
        this.props.getFinished()
    }

    render() {
        console.log(this.props)
        const { simulations, finished } = this.props
        return (
            <div> 
                <ContentHeader title='Dashboard' small='Version 1.0' />
                <Content>
                    <Row> 
                        <ValueBox cols='12 6' color='green' icon='check'
                            value={`${simulations.length}`} text='Active insurances contracts' />
                        <ValueBox cols='12 6' color='blue' icon='close'
                            value={`${finished.length}`} text='Pending insurances contracts' />                    </Row> 
                </Content> 
            </div>
        )
    }
}

const mapStateToProps = state => ({
    simulations: state.dashboard.simulations, 
    finished: state.dashboard.finished
})
const mapDispatchToProps = dispatch => bindActionCreators({getSimulation, getFinished}, dispatch)
export default connect(mapStateToProps, mapDispatchToProps)(Dashboard)