package edu.calvin.jlm54.lab12.calgorythmic;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import c12lists.lab.calgorythmic.midi.Beat;
import c12lists.lab.calgorythmic.midi.Midi;

/**
 * Part models a single part in a {@link Piece} of music. A part has a sequence
 * of {@link Chord}s and is played using a single instrument.
 * 
 * @author Joshua Maguire
 * @version 20nov2012
 */
public class Part {

	private List<Chord> myChords;
	private int myInstrument;

	/**
	 * Construct a new Part.
	 * 
	 * @param instrument
	 *            the instrument used to play the part
	 * @throws Exception
	 */
	public Part(int instrument) throws Exception {
		Midi.checkInstrument(instrument);
		myChords = new ArrayList<Chord>();
		myInstrument = instrument;
	}

	public Part(String filename, int instrument)throws Exception{
		Scanner fileIn = new Scanner(new File(filename));
		myChords = new ArrayList<Chord>();
		while (fileIn.hasNextLine()) {
			myChords.add(new Chord(fileIn.nextLine()));

		}
		fileIn.close();
		myInstrument = instrument;
	}

	public int getInstrument() {
		return myInstrument;
	}

	public void setInstrument(int instrument) throws Exception {
		Midi.checkInstrument(instrument);
		myInstrument = instrument;
	}

	public void addChord(Chord chord) {
		myChords.add(chord);
	}

	/**
	 * Add empty, non-pitched beats to the chord sequence
	 * 
	 * @param beats
	 *            the number of beats to add
	 * @throws Exception
	 */
	public void addRests(int beats) throws Exception {
		for (int i = 0; i < beats; i++)
			myChords.add(new Chord(0, Midi.BASIC_BEAT));
	}

	/**
	 * @return return a deep copy of this Part's chords
	 * @throws Exception
	 */
	public List<Chord> getChords() throws Exception {
		List<Chord> result = new ArrayList<Chord>();
		for (int i = 0; i < myChords.size(); i++) {
			result.add(new Chord(myChords.get(i).getPitch(), myChords.get(i).getDuration()));
		}
		return result;
	}

	public void addChords(List<Chord> chords) {
		myChords.addAll(chords);
	}

	/**
	 * @return a List of beats representing the Midi version of this part, which
	 *         includes all note-on, note-off and rest beats
	 */
	public List<Beat> getBeats() {
		List<Beat> result = new ArrayList<Beat>();
		Beat beat;
		Chord previousChord = null;
		for (Chord chord : myChords) {
			beat = new Beat();
			if (previousChord != null)
				beat.addEvents(previousChord.getEvents(Midi.NOTE_OFF));
			beat.addEvents(chord.getEvents(Midi.NOTE_ON));
			result.add(beat);
			result.addAll(chord.getWaitBeats());
			previousChord = chord;
		}
		return result;
	}

	/**
	 * Transpose this part based on the given interval.
	 * 
	 * @param interval
	 *            the change to apply to all chords in this part
	 * @throws Exception
	 */
	public void transpose(int interval) throws Exception {
		Chord chord;
		for (int i = 0; i < myChords.size(); i++) {
			chord = myChords.get(i);
			if (chord.getPitch() != 0) {
				chord.setPitch(chord.getPitch() + interval);
			}
		}
	}

}
