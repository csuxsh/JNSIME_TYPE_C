package com.jnselectronics.im.hardware;



public class KeyBoardTypeG {
	public static final int BUTTON_SEARCH_SCANCODE = 217;
	public static final int BUTTON_A_SCANCODE = 304;
	public static final int BUTTON_B_SCANCODE = 305;
	public static final int BUTTON_X_SCANCODE = 307;
	public static final int BUTTON_Y_SCANCODE = 308;
	public static final int BUTTON_UP_SCANCODE = 103;
	public static final int BUTTON_DOWN_SCANCODE = 108;
	public static final int BUTTON_RIGHT_SCANCODE = 106;
	public static final int BUTTON_LEFT_SCANCODE = 105;
	public static final int BUTTON_SELECT_SCANCODE = 314;
	public static final int BUTTON_START_SCANCODE = 315;
	public static final int BUTTON_L1_SCANCODE = 310;
	public static final int BUTTON_L2_SCANCODE = 312;
	public static final int BUTTON_R1_SCANCODE = 311;
	public static final int BUTTON_R2_SCANCODE = 313;
	public static final int STICK_L = 15;
	public static final int STICK_R = 16;
	public static final int BUTTON_XP_SCANCODE = 0x7f01;
	public static final int BUTTON_XI_SCANCODE = 0x7f02;
	public static final int BUTTON_YP_SCANCODE = 0x7f03;
	public static final int BUTTON_YI_SCANCODE = 0x7f04;
	public static final int BUTTON_ZP_SCANCODE = 0x7f05;
	public static final int BUTTON_ZI_SCANCODE = 0x7f06;
	public static final int BUTTON_RZP_SCANCODE = 0x7f07;
	public static final int BUTTON_RZI_SCANCODE = 0x7f08;

	public final static int BUTTON_V_DOWN_SCANCODE = 0x73;
	public final static int BUTTON_V_UP_SCANCODE = 0x72;
	public final static int BUTTON_MUTE_SCANCODE = 0x72;
	public final static int BUTTON_M_PREVIOUS_SCANCODE = 0xa5;
	public final static int BUTTON_M_NEXT_SCANCODE = 0xa3;
	public final static int BUTTON_PAUSE_SCANCODE = 0xa4;
	public final static int BUTTON_ENTER_SCANCODE = 0x1c;





	public static final int RIGHT_JOYSTICK_TAG = 1;
	public static final int LEFT_JOYSTICK_TAG = 2;
	public static final int JOYSTICK_ZOOM_1_TAG =0x3;
	public static final int JOYSTICK_ZOOM_2_TAG =0x4;



	public final static int BUTTON_UP = 34;
	public final static int BUTTON_ENTER = 45;
	public final static int BUTTON_LEFT = 50;
	//public final static int BUTTON_V_UP = 30;
	public final static int BUTTON_RIGHT = 66;
	//public final static int BUTTON_M_PREVIOUS = 46;
	public final static int BUTTON_DOWN = 82;
	//public final static int BUTTON_V_DOWN = 62;
	//public final static int BUTTON_PAUSE = 79;
	//public final static int BUTTON_M_NEXT= 122;
	// final static int BUTTON_MUTE = 123;




	/*
	private final static int DISPLAY_COL = 8;
	{
		"",
		"L1",
		"Select",
		"Start",
		"R1",
		"L2",
		"R2",
		"Up",
		"Y",
		"Left",
		"Right",
		"X",
		"B",
		"Down",
		"A",
		"Y+",
		"RZ+",
		"X-",
		"X+",
		"Z-",
		"Z+",
		"Y-",
		"RZ+"	
	};
	 */

	public final static int DISPLAY_ROW = 16;
	public final static int DISPLAY_COL = 8;


	public final static int gamePadButoonScanCode[][] = 
		{
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		{0, 0, BUTTON_UP_SCANCODE,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  BUTTON_ENTER_SCANCODE,  0,  0},
		{0, 0, BUTTON_LEFT_SCANCODE, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		{0, 0, BUTTON_RIGHT_SCANCODE,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
		{0, 0, BUTTON_DOWN_SCANCODE,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,0},
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0,  0},
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		
		};
	public final static int gamePadButoonIndex[][] = 
		{
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		{0, 0, BUTTON_UP,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  BUTTON_ENTER,  0,  0},
		{0, 0, BUTTON_LEFT, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		{0, 0, BUTTON_RIGHT,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
		{0, 0, BUTTON_DOWN,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,0},
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0,  0},
		{0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
		
		};
	/*
	public final static String gamePadButoonLable[][] = 
	{
		{null,  null,  null,  "L1",  null,  null,  null,  "Select",  "Start",  null,  null,  null,  "R1", null,  null,  null},
		{null,  null,  "L2",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "R2", null,  null},
		{null,  "Up",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "Y", null},
		{"Left",  null,	"Right",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "X", null, "B"},
		{null,  	"Down", null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, "A",  null},
		{null,  "Y+", null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, "RZ+",  null},
		{"X-",  null ,"X+",null,  null,  null,  null,  null,  null,  null,  null,  null,   null,  "Z-", null, "Z-"},
		{null,   "Y-",null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "RZ+",null},
	};*/
	public final static String gamePadButoonLable[][] = 
		{
		{null,  null, null, null,  null,  null,  null,  null,  null,  null,  null,  null,   null,  null, null, null},
		{null,  null, null, null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,null},
		{null,  null,  "",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, "",  null,  null},
		{null,  null,  "",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, null,  null},
		{null,  null,  "",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, null, null},
		{null,  null,  "",  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, null, null},
		{null,  null, null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,null,  null},
		{null, null, null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, null,  null},
		
		};

}
