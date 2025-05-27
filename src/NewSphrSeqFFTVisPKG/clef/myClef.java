package NewSphrSeqFFTVisPKG.clef;

import NewSphrSeqFFTVisPKG.clef.base.myClefBase;
import NewSphrSeqFFTVisPKG.clef.enums.clefType;
import NewSphrSeqFFTVisPKG.note.NoteData;
import NewSphrSeqFFTVisPKG.ui.base.myMusicSimWindow;
import base_Render_Interface.IRenderInterface;
import base_UI_Objects.renderer.ProcessingRenderer;
import processing.core.PImage;

public class myClef extends myClefBase{

	public myClef(myMusicSimWindow _win, String _name, clefType _clef, NoteData _mdNote, PImage _img, float[] _drawDim, float _ocf) {
		super(_win, _name, _clef, _mdNote, _img, _drawDim, _ocf);
	}
	public myClef(myClef _c){
		super(_c);		
	}
	

	@Override
	public boolean isAboveMiddle(NoteData _note) 	{
		return midNote.isLowerThan(_note);
	}
	@Override
	public void setImage(PImage[] _clf) {//only 1 image, passed by reference
		this.clefImage = _clf[0];	
	}
	//whether or not a note is on the staff or above or below it : -1 is below, 0 is on, 1 is above
	@Override
	public int isOnStaff(NoteData _note) {
		return (highNote.isLowerThan(_note) ? 1 : (_note.isLowerThan(lowNote)) ? -1: 0);
	}
	
	@Override
	public void drawMe(IRenderInterface p, float offset) {
		p.pushMatState();//draw image	
		((ProcessingRenderer) p).image(clefImage, drawDim[0] + offset,drawDim[1], drawDim[2],drawDim[3]);		
		p.popMatState();	
	}
	
	@Override
	public String toString(){
		String res = super.toString();
		res +=" Clef middle note : " + midNote.name+midNote.octave+ " High Note : "+ highNote.name+highNote.octave+ " Low Note : " + lowNote.name+lowNote.octave;
		return res;
	}

}//myClef