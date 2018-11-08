/* TimeSlotBox react component
 *
 * The box to house all other components inside of it.
 */

import React from 'react';
import $ from 'jquery';

import TimeSlotList from './timeSlotList';
import TimeSlotFooter from './timeSlotFooter';

import { API_URL, POLL_INTERVAL} from './global';

module.exports = React.createClass({

  // loadTimeSlotsFromServer() pulls data from server every .5 seconds and updates 
  //   the view of time slots.
  loadTimeSlotsFromServer: function() {
    $.ajax({
      url: API_URL,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({data: data});

		// find the number of total time slots
		this.context.totalTimes = data.length;

		// find the number of time slots filled
		var ctr = 0;
		for (var i=0; i < data.length; i++) {
			if (data[i].filled)
				ctr ++;
		}
		this.context.currTimes = ctr;

		// update the progress bar
		$("#progress-bar").width(((this.context.currTimes / this.context.totalTimes) * 100) + '%');

      }.bind(this),
      error: function(xhr, status, err) {
        console.error(API_URL, status, err.toString());
      }.bind(this)
    });
  },

  // sets initial state
  getInitialState: function() {
    return {data: []};
  },

  // check to see if the component mounted, pull from database
  componentDidMount: function() {
    this.loadTimeSlotsFromServer();
    setInterval(this.loadTimeSlotsFromServer, POLL_INTERVAL);
  },

  // render the box and its componenets
  render: function() {
    return (
      <div className="timeSlotBox">
        <h1>Blood Drive<br/>Sign Up</h1>
        <TimeSlotList data={this.state.data} />
		<TimeSlotFooter />
      </div>
    );
  }
});
