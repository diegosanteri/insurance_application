import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'

import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import Tabs from '../common/tab/tabs'
import TabsHeader from '../common/tab/tabsHeader'
import TabsContent from '../common/tab/tabsContent'
import TabHeader from '../common/tab/tabHeader'
import TabContent from '../common/tab/tabContent'
import { init, create, update, remove, getFinished, updateStatus, getSimulation } from './insuranceActions'

import PendingList from './insurancePendingList'
import FinishedList from './insuranceFinishedList'
import Form from './insuranceForm'

class Insurance extends Component {

    componentWillMount() {
        this.props.init()
    }

    render() {
        
        const { create } = this.props
        return (
            <div> 
                <ContentHeader title='Insurance' small='Management' />
                <Content> 
                    <Tabs> 
                        <TabsHeader> 
                            <TabHeader label='New simulation' icon='plus' target='tabCreate' />
                            <TabHeader label='Pending simulations' icon='bars' target='tabList'/>
                            <TabHeader label='Purchased insurance'icon='handshake-o' target='tabPurchase' />
                            <TabHeader label='Update simulation' icon='pencil' target='tabUpdate'/>
                            <TabHeader label='Update simulation status' icon='check' target='tabUpdateStatus' />
                            <TabHeader label='Purchase insurance details' icon='check' target='tabContractDetails' />
                        </TabsHeader> 
                        <TabsContent> 
                            <TabContent id='tabList'>
                                <PendingList />
                            </TabContent>
                            <TabContent id='tabCreate'>
                                <Form submitLabel={'Create simulation' } 
                                    submitClass='primary'
                                    onSubmit={this.props.create}
                                    readOnly={false}
                                    showDetails={false}/>
                            </TabContent>
                            <TabContent id='tabPurchase'>
                                <FinishedList />
                            </TabContent>
                            <TabContent id='tabUpdate'>
                                <Form submitLabel={'Update simulation' } 
                                    submitClass='info'
                                    onSubmit={this.props.update}
                                    readOnly={false}
                                    showDetails={true}/>
                            </TabContent>
                            <TabContent id='tabUpdateStatus'>
                                <Form submitLabel={'Purchase insurance' } 
                                    submitClass='info'
                                    onSubmit={this.props.updateStatus}
                                    readOnly={false}
                                    showDetails={true}/>
                            </TabContent>
                            <TabContent id='tabDelete'>
                                <Form submitLabel={'Delete simulation' } 
                                    submitClass='danger' 
                                    onSubmit={this.props.remove}
                                    readOnly={true}
                                    showDetails={true}/>
                            </TabContent>
                            <TabContent id='tabContractDetails'>
                                <Form 
                                    hideSubmit={true}
                                    readOnly={true}
                                    showDetails={true}/>
                            </TabContent>
                        </TabsContent> 
                    </Tabs> 
                </Content> 
            </div> 
        )
    }
}

const mapDispatchToProps = dispatch => bindActionCreators({
    init, create, update, remove, getFinished, getSimulation, updateStatus
}, dispatch)
export default connect(null, mapDispatchToProps)(Insurance)