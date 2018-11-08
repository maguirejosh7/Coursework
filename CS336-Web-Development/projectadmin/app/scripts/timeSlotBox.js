/*React timeSlotBox component
 * is the root for the components (really intex is)
 * but this component encases all the other ones. 
 */
import React from 'react';
import $ from 'jquery';

import TimeSlotForm from './timeSlotForm';
import TimeSlotList from './timeSlotList';
import { API_URL, POLL_INTERVAL } from './global';

module.exports = React.createClass({
  loadTimeSlotsFromServer: function() {
    $.ajax({
      url: API_URL,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(API_URL, status, err.toString());
      }.bind(this)
    });
  },
  handleTimeSlotSubmit: function(timeSlot) {
    var timeSlots = this.state.data;
    timeSlot.id = Date.now();
    var newTimeSlots = timeSlots.concat([timeSlot]);
    this.setState({data: newTimeSlots});
    $.ajax({
      url: API_URL,
      dataType: 'json',
      type: 'POST',
      data: timeSlot,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(API_URL, status, err.toString());
      }.bind(this)
    });
  },
  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
    this.loadTimeSlotsFromServer();
    setInterval(this.loadTimeSlotsFromServer, POLL_INTERVAL);
  },
  render: function() {
    return (
      <div className="timeSlotBox">
      <h1>Time Slots</h1>
      <TimeSlotList data={this.state.data} onTimeSlotSubmit={this.handleTimeSlotSubmit} />
      <TimeSlotForm onTimeSlotSubmit={this.handleTimeSlotSubmit} />
      </div>
      );
    }
  });