import React from 'react'
import MenuItem from './menuItem'
import MenuTree from './menuTree'

export default props => (
    <ul className='sidebar-menu'>
        <MenuItem path='/' label='Dashboard' icon='dashboard' />
        <MenuTree label='Insurance' icon='edit'> 
            <MenuItem path='insurance'
                label='Management' icon='asterisk' />
        </MenuTree>
    </ul>
)