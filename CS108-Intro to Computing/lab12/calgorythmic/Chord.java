package edu.calvin.jlm54.lab12.calgorythmic;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import c12lists.lab.calgorythmic.midi.Beat;
import c12lists.lab.calgorythmic.midi.Event;
import c12lists.lab.calgorythmic.midi.Midi;

/**
 * Chord models a single chord in a {@link Part} of a {@link Piece} of music.
 * This implementation only supports single notes rather than multiple-note
 * chords.
 * 
 * @author Joshua Maguire
 * @version 20nov2012
 */
public class Chord {

	private static final int DEFAULT_VELOCITY = 100;
	private int myDuration, myVelocity;
	private int myPitch;

	/**
	 * Construct a new Chord
	 * 
	 * @param pitch
	 *            a specified pitch
	 * @param duration
	 *            a specified duration
	 * @throws Exception 
	 */
	public Chord(int pitch, int duration) throws Exception {
		Midi.checkPitch(pitch);
		myPitch = pitch;
		Midi.checkDuration(duration);
		myDuration = duration;
		myVelocity = DEFAULT_VELOCITY;
	}
	//second constructor fofr importing song
	public Chord(String Line) throws Exception {
		Scanner scanner = new Scanner(Line);	
		myDuration =Midi.parseDuration(scanner.next());
		myPitch = Midi.parsePitch(scanner.next());
		scanner.close();
		myVelocity = DEFAULT_VELOCITY;
	}
	
	public int getPitch() {
		return myPitch;
	}
	
	public void setPitch(int pitch) throws Exception {
		Midi.checkPitch(pitch);
		myPitch = pitch;
	}
	
	public int getDuration() {
		return myDuration;
	}

	/**
	 * Create and return a list of Midi events (e.g., NOTE_ON events for each
	 * pitch to be executed at the beginning of a chord).
	 * @param type
	 *            a specified event type (cf. {@link Midi})
	 * @return a list of events of the given event type for each pitch
	 */
	public List<Event> getEvents(int type) {
		List<Event> result = new ArrayList<Event>();
		result.add(new Event(type, myPitch, myVelocity));
		return result;
	}

	/**
	 * @return an ArrayList of pitch-less beats with the length specified by the
	 *         chord's duration
	 */
	public ArrayList<Beat> getWaitBeats() {
		ArrayList<Beat> result = new ArrayList<Beat>();
		for (int i = 1; i < myDuration; i++)
			result.add(new Beat());
		return result;
	}

	
	
}
