/* Server.js is a simple server for the Blood Drive Sign Up website.
 * 
 * It is driven with a mongoDB database and computes simple functions
 *  to get the data.
 */

var fs = require('fs');
var path = require('path');
var express = require('express');
var bodyParser = require('body-parser');
var MongoClient = require('mongodb').MongoClient
var app = express();

// set the port
app.set('port', (process.env.PORT || 3000));
var APP_PATH = path.join(__dirname, 'dist');

app.use('/', express.static(APP_PATH));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

// Connect to MongoDB
var db;
var PASSWORD = 'bjarne';
var mongoURL = 'mongodb://cs336:' + PASSWORD + '@ds139937.mlab.com:39937/cs336';
MongoClient.connect(mongoURL, function(err, dbConnection) {
	if (err) throw err;
	db = dbConnection;
});

// Additional middleware which will set headers that we need on each request.
app.use(function(req, res, next) {
    // Set permissive CORS header - this allows this server to be used only as
    // an API server in conjunction with something like webpack-dev-server.
    res.setHeader('Access-Control-Allow-Origin', '*');

    // Disable caching so we'll always get the latest comments.
    res.setHeader('Cache-Control', 'no-cache');
    next();
});

// GET to get all time slots from database
app.get('/api/timeslots', function(req, res) {
	db.collection('timeslots').find({}).toArray(function(err, docs) {
		if (err) throw err;
		res.json(docs);
	});
});

//POST - creates new time slot, with data sent from client
app.post('/api/timeslots', function(req, res) {
    var newTimeSlot = {
        id: Date.now(),
        name: req.body.name,
        email: req.body.email,
    };

	// insert into database
	db.collection('timeslots').insertOne(newComment, function(err, result) {
		if (err) throw err;
		db.collection('timeslots').find({}).toArray(function(err, docs) {
			if (err) throw err;
			res.json(docs);
		});
	});

});


// GET - gets information regarding one timeslot, using the time slot ID number argument
app.get('/api/timeslots/:id', function(req, res) {
    db.collection("timeslots").find({"id": Number(req.params.id)}).toArray(function(err, docs) {
        if (err) throw err;
        res.json(docs);
    });
});


// PUT - updates one time slot, after a user has signed up for a time
app.put('/api/timeslots', function(req, res) {
    var update = req.body;

	// update time slot
    db.collection('timeslots').updateOne(
        { id: update.id },
        { $set: {
			name: update.name,
			email: update.email,
			filled: true,
		}},
        function(err, result) {
            if (err) throw err;
            db.collection("timeslots").find({}).toArray(function(err, docs) {
                if (err) throw err;
                res.json(docs);
            });
        });
});


// PUT - updates a time slot when user cancels their sign up
app.put('/api/timeslots/cancel', function(req, res) {
	var timeId = parseInt(req.body.id);
	db.collection('timeslots').updateOne(
		{ id: timeId },
		{ $set: {
			name: 'OPEN',
			email: '',
			filled: false,
		}},
        function(err, result) {
            if (err) throw err;
            db.collection("timeslots").find({}).toArray(function(err, docs) {
                if (err) throw err;
                res.json(docs);
            });
        });
});


// Send all routes/methods not specified above to the app root.
app.use('*', express.static(APP_PATH));

app.listen(app.get('port'), function() {
    console.log('Server started: http://localhost:' + app.get('port') + '/');
});
