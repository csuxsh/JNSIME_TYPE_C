package com.jnselectronics.ime.bean;

import com.jnselectronics.im.hardware.KeyBoardTypeC;

public class JnsIMEKeyTypeCMap extends JnsIMEKeyMap {

	@Override
	public int getScanCode() {
		// TODO Auto-generated method stub
		return KeyBoardTypeC.gamePadButoonScanCode[this.getGamPadIndex()/KeyBoardTypeC.DISPLAY_ROW][this.getGamPadIndex()%KeyBoardTypeC.DISPLAY_ROW];

	}

}
