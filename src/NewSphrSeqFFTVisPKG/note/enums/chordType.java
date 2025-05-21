package NewSphrSeqFFTVisPKG.note.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * chord type
 * @author John Turner
 *
 */
public enum chordType {
	Major,			//1,3,5
	Minor,			//1,b3,5
	Augmented,		//1,3,#5
	MajFlt5,			//1,3,b5
	Diminished,		//1,b3,b5
	Sus2,			//1,2,5
	Sus4,			//1,4,5
	Maj6,			//1,3,5,6
	Min6,			//1,b3,5,6
	Maj7,			//1,3,5,7
	Dom7,			//1,3,5,b7
	Min7,			//1,b3,5,b7
	Dim7,			//1,b3,b5,bb7==6
	None;			//not a predifined chord type
	private static Map<Integer, chordType> map = new HashMap<Integer, chordType>(); 
	static { for (chordType enumV : chordType.values()) { map.put(enumV.ordinal(), enumV);}}
	public int getOrdinal() {return ordinal();}
	public static chordType getEnumByIndex(int idx){return map.get(idx);}
	public static chordType getEnumFromValue(int idx){return map.get(idx);}
	public static int getNumVals(){return map.size();}					//get # of values in enum	
	/**
	 * return array of halfstep displacements for each note of chord, starting with 0 for root
	 * @param typ
	 * @return
	 */
	public static int[] getChordDisp(chordType typ){
		switch (typ){
		case Major		:{return (new int[]{0,4,7});}	//1,3,5
		case Minor		:{return (new int[]{0,3,7});}	//1,b3,5
		case Augmented	:{return (new int[]{0,4,8});}	//1,3,#5
		case MajFlt5	:{return (new int[]{0,4,6});}	//1,3,b5
		case Diminished	:{return (new int[]{0,3,6});}	//1,b3,b5
		case Sus2       :{return (new int[]{0,2,7});}	//1,2,5
		case Sus4       :{return (new int[]{0,5,7});}	//1,4,5			
		case Maj6       :{return (new int[]{0,4,7,9});}	//1,3,5,6
		case Min6      	:{return (new int[]{0,3,7,9});}	//1,b3,5,6
		case Maj7      	:{return (new int[]{0,4,7,11});}	//1,3,5,7
		case Dom7      	:{return (new int[]{0,4,7,10});}	//1,3,5,b7
		case Min7      	:{return (new int[]{0,3,7,10});}	//1,b3,5,b7
		case Dim7      	:{return (new int[]{0,3,6,9});}	//1,b3,b5,bb7==6
		case None      	:{return (new int[]{0});}	//not a predifined chord type
		default         :{return (new int[]{0});}						
		}			
	}
	
}//enum chordType