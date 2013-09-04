package com.jnselectronics.ime.bean;

import com.jnselectronics.im.hardware.JoyStickTypeF;
import com.jnselectronics.im.hardware.KeyBoardTypeG;

public class JnsIMEKeyTypeGMap extends JnsIMEKeyMap {

	@Override
	public int getScanCode() {
		// TODO Auto-generated method stub
		return KeyBoardTypeG.gamePadButoonScanCode[this.getGamPadIndex()/KeyBoardTypeG.DISPLAY_ROW][this.getGamPadIndex()%KeyBoardTypeG.DISPLAY_ROW];

	}

}
