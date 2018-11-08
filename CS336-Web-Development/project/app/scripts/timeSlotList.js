/* TimeSlotList react component
 *
 * The list of time slot components.
 */

import React from 'react';
import $ from 'jquery';
import Remarkable from 'remarkable';

import TimeSlot from './timeSlot';

module.exports = React.createClass({
  render: function() {
	const divStyle = {
	  height: '75px'
	};

	// get all time slots
    var timeSlotNodes = this.props.data.map(function(timeSlot) {
      return (
        <TimeSlot id={timeSlot.id} date={timeSlot.date} time={timeSlot.time} name={timeSlot.name} email={timeSlot.email} filled={timeSlot.filled} key={timeSlot.id}>
          {timeSlot.id}
        </TimeSlot>
      );
    });
    return (
      <div className="timeSlotList">
        {timeSlotNodes}
		<div style={divStyle}></div>
      </div>
    );
  }
});
