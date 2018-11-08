/* TimeSlotFooter react component
 *
 * The footer at the bottom of the application which shows the Blood-O-Meter,
 * which keeps track of blood donations.
 */

import React from 'react';
import $ from 'jquery';
import '../css/base.css';

import { API_URL } from './global';

module.exports = React.createClass({

  // get initial state
  getInitialState: function() {
    return {};
  },
  render: function() {

	// since we could not figure out css for the longest time until professor helped us the last day,
    //  this is a workaround, using variables to declare css classes.
	const divStyle = {
		background: '#ffffff',
		background: '-moz-linear-gradient(top, #ffffff 0%, #f6f6f6 47%, #ededed 100%)',
		background: '-webkit-linear-gradient(top, #ffffff 0%,#f6f6f6 47%,#ededed 100%)',
		background: 'linear-gradient(to bottom, #ffffff 0%,#f6f6f6 47%,#ededed 100%)',
		filter: "progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed',GradientType=0 )",
		opacity: 0.5,	
		position: 'fixed',
		left: 0,
		right: 0,
		bottom: 0,
		height: '75px'
    };

	const divStyle2 = {
		border: '5px solid black',
		width: '50%',
		margin: '6.25px auto',
		height: '50px',
		'line-height': '50px',
		'vertical-align': 'middle',
		position: 'relative',
	};

	const divStyle3 = {
		width: '50%',
		background: 'red',
		height: '50px',
		position: 'absolute',
		top: 0,
		left: 0,
	};

	const divStyle4 = {
		position: 'absolute',
		margin: '0 0 0 35%',
		'z-index': 10001,
		'font-weight': 'bold',
		'font-family': "'Lato', sans-serif"
	};

	// return the progress bar at the bottom of the page.
    return (
      <div className="timeSlotFooter" style={divStyle}>
		<div className="progress-bar" style={divStyle2}>
			<div id="progress-bar" style={divStyle3}></div>
			<span id="blood-meter" style={divStyle4}>BLOOD-O-METER</span>
		</div>
	  </div>
    );
  }
});
