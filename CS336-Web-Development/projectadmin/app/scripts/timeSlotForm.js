/* React timeSlotForm component
 * This is the form at the bottom of the page 
 * that lets an admin create new timeslots. These
 * new slots don't have names or emails, just date and times
 */
import React from 'react';
import $ from 'jquery';

module.exports = React.createClass({
    getInitialState: function() {
        return {name: '', email: ''};
    },
    handleNameChange: function(e) {
        this.setState({name: e.target.value});
    },
    handleEmailChange: function(e) {
        this.setState({email: e.target.value});
    },
    handleDateChange: function(e) {
        this.setState({date: e.target.value});
    },
    handleTimeChange: function(e) {
        this.setState({time: e.target.value});
    },
    handleSubmit: function(e) {
        e.preventDefault();
        var name = "OPEN";
        var email = "";
        var date = this.state.date;
        var time = this.state.time;
        if (!date || !time) {
            return;
        }
        this.props.onTimeSlotSubmit({name: name, email: email, date: date, time: time});
        this.setState({name: '', email: ''});
    },
    render: function() {
        return (
            <form className="timeSlotForm" onSubmit={this.handleSubmit}>
                <input className="ui-widget ui-corner-all" type="date"
                        value={this.state.date} onChange={this.handleDateChange}
                />
                <input className="ui-widget ui-corner-all" type="time"
                        value={this.state.time} onChange={this.handleTimeChange}
                />
                <input className="ui-button ui-widget ui-corner-all" type="submit" value="Create Timeslot" />
            </form>
        );
    }
});
