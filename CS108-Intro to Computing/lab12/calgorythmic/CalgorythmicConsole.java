package edu.calvin.jlm54.lab12.calgorythmic;
import c12lists.lab.calgorythmic.midi.Midi;
import c12lists.lab.calgorythmic.midi.MidiPlayer;


/**
 * Plays simple midi notes, imports midi songs.
 * 
 * @author Joshua Maguire
 * @version 20nov2012
 */
public class CalgorythmicConsole {

	private static MidiPlayer midi;

	// A sample exercise that plays a middle C
	public static void exercise0() throws Exception {
		Piece middleC = new Piece(Midi.ANDANTE);
		Part melody = new Part(Midi.PIANO);
		melody.addChord(new Chord(Midi.C3, Midi.WHOLE));
		middleC.addPart(melody);
		middleC.play(midi);
	}

	public static void exercise1() throws Exception {
		Piece notes = new Piece(Midi.ANDANTE);
		Part melody1 = new Part(Midi.PIANO);
		melody1.addChord(new Chord(Midi.C4, Midi.QUARTER));
		melody1.addChord(new Chord(Midi.D4, Midi.QUARTER));
		melody1.addChord(new Chord(Midi.E4, Midi.QUARTER));
		melody1.addChord(new Chord(Midi.C4, Midi.QUARTER));
		notes.addPart(melody1);
		notes.play(midi);
	}
	//Exercise 12.2
	public static void chromaticScale() throws Exception{
		Piece chromaticScalePiece = new Piece(Midi.PRESTO);
		Part chromaticScalePart = new Part(Midi.PIANO);
		for (int i = Midi.C3;i <= Midi.C6;i++){
			chromaticScalePart.addChord(new Chord(i, Midi.QUARTER));
		}
		for (int i = Midi.C6;i >= Midi.C3;i--){
			chromaticScalePart.addChord(new Chord(i, Midi.QUARTER));
		}
		chromaticScalePiece.addPart(chromaticScalePart);
		chromaticScalePiece.play(midi);
	}

	public static void exercise3() throws Exception{
		Piece fjPiece = new Piece(Midi.ALLEGRETTO );
		Part fjPart = new Part("src/edu/calvin/jlm54/lab12/data/FrereJacques.txt",Midi.PIANO);
		fjPiece.addPart (fjPart);
		fjPiece.play(midi);
	
	}

	public static void main(String[] args) throws Exception {
		midi = new MidiPlayer();
		//exercise0();
		//exercise1();
		//chromaticScale();
		exercise3();
		midi.close();

	}

}
