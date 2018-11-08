package edu.calvin.jlm54.lab12.calgorythmic;
import java.util.ArrayList;
import java.util.List;

import c12lists.lab.calgorythmic.midi.Beat;
import c12lists.lab.calgorythmic.midi.Midi;
import c12lists.lab.calgorythmic.midi.MidiPlayer;

/**
 * Piece models a piece of music as a set of {@link Part}s to be played
 * simultaneously.
 * 
 * @author kvlinden
 * @version 23nov2009
 */
public class Piece {

	private int myTempo;
	private List<Part> myParts;

	/**
	 * Construct a new Piece with an empty list of parts.
     * @author Joshua Maguire
  	 * @version 20nov2012
	 * @param tempo
	 *            the specified tempo
	 * @throws Exception 
	 */
	public Piece(int tempo) throws Exception {
		Midi.checkTempo(tempo);
		myTempo = tempo;
		myParts = new ArrayList<Part>();
	}

	public void addPart(Part part) {
		myParts.add(part);
	}

	/**
	 * Play the parts of this piece simultaneously.
	 * 
	 * @param midi
	 *            the Midi object to do the playing
	 * @throws Exception
	 */
	public void play(MidiPlayer midi) throws Exception {
		List<List<Beat>> midiParts = new ArrayList<List<Beat>>(myParts.size());
		for (Part part : myParts)
			midiParts.add(part.getBeats());
		for (int b = 0; b < midiParts.get(0).size(); b++) {
			for (int p = 0; p < midiParts.size(); p++) {
				midi.setInstrument(myParts.get(p).getInstrument());
				midiParts.get(p).get(b).send(midi, p);
			}
			Thread.sleep(myTempo);
		}
	}

}
