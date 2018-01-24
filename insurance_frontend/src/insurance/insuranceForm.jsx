import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { reduxForm, Field, formValueSelector } from 'redux-form'
import DropdownList from 'react-widgets/lib/DropdownList'

import { init } from './insuranceActions'
import LabelAndInput from '../common/form/labelAndInput'
import If from '../common/operator/if'
import Grid from '../common/layout/grid'


class InsuranceForm extends Component {

    render() {
        const { handleSubmit, readOnly, showDetails, hideSubmit } = this.props

        return (
            <form role='form' onSubmit={handleSubmit}>
                <div className='box-body'>
                    <Field name='username' component={LabelAndInput} readOnly={readOnly}
                        label='Usermane' cols='12 4' placeholder='Username' />

                    <Grid cols={'12 4'}>
                        <div className='form-group'>
                            <label >Insurance type</label>
                            <Field name="insurance" component="select"  readOnly={readOnly} className='form-control'>                        
                                <option></option>
                                <option value="BIKE" >BIKE</option>
                                <option value="JEWELRY">JEWELRY</option>
                                <option value="ELECTRONICS">ELECTRONICS</option>
                                <option value="SPORT_EQUIPMENT">SPORT_EQUIPMENT</option>
                            </Field>
                        </div>
                    </Grid>
                    <Field name='productValue' component={LabelAndInput} readOnly={readOnly}
                        label='Product value' cols='12 4' placeholder='Type product value' />
                    <If test = {showDetails}>
                        <Field name='tariff' component={LabelAndInput} readOnly={true}
                            label='Tariff' cols='12 4'/>
                    </If>
                    
                </div>
                <div className='box-footer'>
                    <If test = {!hideSubmit}>
                        <button type='submit' className={`btn btn-${this.props.submitClass}`}>
                            {this.props.submitLabel}
                        </button>
                    </If>
                    <button type='button' className='btn btn-default'
                        onClick={this.props.init}>Back</button>
                </div>
            </form>
        )
    }
}

InsuranceForm = reduxForm({ form: 'insuranceForm', destroyOnUnmount: false })(InsuranceForm)
const selector = formValueSelector('insuranceForm')
const mapStateToProps = state => ({
})

const mapDispatchToProps = dispatch => bindActionCreators({ init }, dispatch)
export default connect(mapStateToProps, mapDispatchToProps)(InsuranceForm)