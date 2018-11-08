/* TimeSlot react component
 *
 * The individual time slots that show the date and time for each time slot.
 */

import React from 'react';
import Remarkable from 'remarkable';
import { Link, browserHistory } from 'react-router';
import $ from 'jquery';
import styles from '../css/base.css';

import { API_URL } from './global';

// create the class
module.exports = React.createClass({

  // set initial state
  getInitialState: function() {
    return {name: '', email: ''};
  },

  // when user enters in name input
  handleNameChange: function(e) {
    this.setState({name: e.target.value});
  },

  // when user enters in email input
  handleEmailChange: function(e) {
    this.setState({email: e.target.value});
  },

  // when user clicks sign up for a time slot
  handleUpdate: function() {

	// gather data from form
    var my_name = this.state.name.trim();
    var my_email = this.state.email.trim();

	// check if empty form inputs
    if (!my_email || !my_name) {
      return;
    }
    var updatedTimeSlot = {
	  id: this.props.id,
	  name: my_name,
      email: my_email
    }

	// call to database to update time slot
    $.ajax({
      url: API_URL,
      dataType: 'json',
      type: 'PUT',
      contentType: 'application/json',
      data: JSON.stringify(updatedTimeSlot)
    })
    .done(function(timeSlots){
 	  // update the progress bar
	  this.context.currTimes += 1;

	  // sends an email using EmailJS to the recipient
      emailjs.send("gmail", "blood_drive_template",
	  {
		"email": my_email,
		"name": my_name,
		"date": this.props.date,
		"time": this.props.time
	  })

      this.setState({name: '', email: ''});
    }.bind(this))
    .fail(function(xhr, status, errorThrown) {
      console.error(API_URL, status, errorThrown.toString());
    }.bind(this));
  },

  // when a user cancels their sign up
  handleCancel: function () {

    // call to database to cancel a sign up
	$.ajax({
	  url: API_URL + '/cancel',
	  type: 'PUT',
	  data: { 'id': this.props.id }
	})
	.done(function(timeSlots){

	  // update the progress bar
  	  this.context.currTimes -= 1;
	}.bind(this))
	.fail(function(xhr, status, errorThrown) {
	  console. error(API_URL, status, errorThrown.toString());
	}.bind(this));
  },  
  alert: function () {
	document.getElementById("{styles.timeTable}").style.color = "red";
  },  
  rawMarkup: function() {
    var md = new Remarkable();
    var rawMarkup = md.render(this.props.children.toString());
    return { __html: rawMarkup };
  },
  render: function() {
    return (
      <div className="timeSlot">
			
          <table id={styles.timeTable} onClick={this.alert}>
			<tr>
			<td className={styles.date}>{this.props.date}</td>
			<td className={styles.time}>{this.props.time}</td>
			<td className={styles.name}>{this.props.name}</td>
			</tr>
		  </table>

    	{ this.props.filled ?
			<button className={styles.cancel}onClick={this.handleCancel}> CANCEL </button>
			:          
		  	<form className="timeSlotForm">
			  <input
				type="text"
				placeholder="Your Name"
				value={this.state.name}
				onChange={this.handleNameChange}
			  />
			  <input
				type="email"
				placeholder="Email"
				value={this.state.email}
				onChange={this.handleEmailChange}
			  />
			  <button type="button" className={styles.formBtn} onClick={this.handleUpdate}>Sign Up</button>
			</form>
		}
	  </div>
    );
  }
});
