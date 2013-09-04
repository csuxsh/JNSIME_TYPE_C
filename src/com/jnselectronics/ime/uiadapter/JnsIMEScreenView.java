package com.jnselectronics.ime.uiadapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.jnselectronics.ime.JnsIMECoreService;
import com.jnselectronics.ime.R;
import com.jnselectronics.ime.bean.JnsIMEPosition;
import com.jnselectronics.ime.bean.JnsIMEProfile;
import com.jnselectronics.ime.util.DrawableUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class JnsIMEScreenView extends View implements Runnable {
	private static final String TAG = "JnsIMEScreenView";
	@SuppressWarnings("unused")
	private String msg = "";
	private float tx;
	private float ty;
	private float radius = 30;
	@SuppressWarnings("unused")
	private int currentBitmapId;
	private float type =JnsIMEPosition.TYPE_OTHERS;
	private boolean isCircle = false;
	private boolean drawable = false;
	private boolean drawPos = false;
	private Paint areaPaint;
	private Paint infoPaint;
	@SuppressWarnings("unused")
	private Rect rect;
	public static Context context;
	public List<JnsIMEPosition> posList;
	public final static int RES_SIZE = 17;
	public final static int G_RES_SIZE = 12;
	public final static int C_RES_SIZE = 13;
	static Bitmap[] bitmap = new Bitmap[RES_SIZE];
	static Bitmap[] g_bitmap = new Bitmap[G_RES_SIZE];
	static Bitmap[] c_bitmap = new Bitmap[C_RES_SIZE];
	public static final int BUTTOM_BG = 0;
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int BUTTON_UP = 5;
	public static final int BUTTON_DOWN = 6;
	public static final int BUTTON_RIGHT = 7;
	public static final int BUTTON_LEFT = 8;
	public static final int BUTTON_SELECT = 9;
	public static final int BUTTON_START = 10;
	public static final int BUTTON_L1 = 11;
	public static final int BUTTON_L2 = 12;
	public static final int BUTTON_R1 = 13;
	public static final int BUTTON_R2 = 14;
	public static final int STICK_L = 15;
	public static final int STICK_R = 16;
	
	public static final int BUTTON_G_UP = 1;
	public static final int BUTTON_G_DOWN = 2;
	public static final int BUTTON_G_RIGHT = 3;
	public static final int BUTTON_G_LEFT = 4;
	public static final int BUTTON_G_ENTER = 5;
	public static final int BUTTON_MUTE = 6;
	public static final int BUTTON_V_DOWN = 7;
	public static final int BUTTON_V_UP = 8;
	public static final int BUTTON_M_PREVIEW = 9;
	public static final int BUTTON_M_NEXT = 10;
	public static final int BUTTON_M_PAUSE = 11;
	
	
	public static final int BUTTON_C_A = 1;
	public static final int BUTTON_C_B = 2;
	public static final int BUTTON_C_X = 3;
	public static final int BUTTON_C_Y = 4;
	public static final int BUTTON_C_UP = 5;
	public static final int BUTTON_C_DOWN = 6;
	public static final int BUTTON_C_RIGHT = 7;
	public static final int BUTTON_C_LEFT = 8;
	public static final int BUTTON_C_SELECT = 9;
	public static final int BUTTON_C_START = 10;
	public static final int BUTTON_C_L1 = 11;
	public static final int BUTTON_C_R1 = 12;
	
	public static final boolean TYPE_G = false; 
	public static final boolean TYPE_C = true;
	
	
	private static int[] resId = 
	{
		R.drawable.pos,
		R.drawable.a,
		R.drawable.b,
		R.drawable.x,
		R.drawable.y,
		R.drawable.up,
		R.drawable.down,
		R.drawable.right,
		R.drawable.left,
		R.drawable.select,
		R.drawable.start,
		R.drawable.l1,
		R.drawable.l2,
		R.drawable.r1,
		R.drawable.r2,
		R.drawable.l_stick,
		R.drawable.r_stick
	};
	
	private static int[] C_resId = 
	{
		R.drawable.pos,
		R.drawable.c_a,
		R.drawable.c_b,
		R.drawable.c_x,
		R.drawable.c_y,
		R.drawable.c_up,
		R.drawable.c_down,
		R.drawable.c_right,
		R.drawable.c_left,
		R.drawable.c_select,
		R.drawable.c_start,
		R.drawable.c_l1,
		R.drawable.c_r1,

	};
	
	private static int[] G_resId = 
	{
		R.drawable.pos,
		R.drawable.g_up,
		R.drawable.g_down,
		R.drawable.g_right,
		R.drawable.g_left,
		R.drawable.g_enter,
		R.drawable.g_mute,
		R.drawable.v_down,
		R.drawable.v_up,
		R.drawable.m_preview,
		R.drawable.m_next,
		R.drawable.g_pause,
	};
	public static void loadTpMapRes()
	{
		 BitmapFactory.Options options=new BitmapFactory.Options(); 
		 options.inJustDecodeBounds = false; 
		 options.inSampleSize = 1;   
		 InputStream is;
		 for(int i= 0; i < RES_SIZE; i++ )
		 {
			 is = context.getResources().openRawResource(resId[i]);
			 bitmap[i] = BitmapFactory.decodeStream(is,null,options);
		 }
		 for(int i= 0; i < G_RES_SIZE; i++ )
		 {
			 is = context.getResources().openRawResource(G_resId[i]);
			 g_bitmap[i] = BitmapFactory.decodeStream(is,null,options);
		 }
		 for(int i= 0; i < C_RES_SIZE; i++ )
		 {
			 is = context.getResources().openRawResource(C_resId[i]);
			 c_bitmap[i] = BitmapFactory.decodeStream(is,null,options);
		 }
	}
	private void loadOldKey(JnsIMEProfile  profile)
	{
		 JnsIMEPosition bop = new JnsIMEPosition();
	 
		 switch (profile.keyCode) {
			case KeyEvent.KEYCODE_0:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_1:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				bop.resId = 0xFF;//BUTTON_V_DOWN;
				break;
			case KeyEvent.KEYCODE_VOLUME_UP:
				bop.resId = 0xFF;//BUTTON_V_UP;
				break;
			case KeyEvent.KEYCODE_VOLUME_MUTE:
				bop.resId = 0xFF;//BUTTON_MUTE;
				break;
			case KeyEvent.KEYCODE_2:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_3:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_4:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_5:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_6:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_7:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_8:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_9:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_A:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_ALT_LEFT:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_ALT_RIGHT:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_APOSTROPHE:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_B:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_BACKSLASH:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_C:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_COMMA:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_D:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_E:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_EQUALS:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_F:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_G:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_H:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_I:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_J:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_K:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_L:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_N:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_M:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_O:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_P:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_Q:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_R:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_S:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_T:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_U:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_V:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_W:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_X:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_Y:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_Z:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_BUTTON_A:
				bop.resId = JnsIMEScreenView.BUTTON_A;
				break;
			case KeyEvent.KEYCODE_BUTTON_B:
				bop.resId = JnsIMEScreenView.BUTTON_B;
				break;
			case KeyEvent.KEYCODE_BUTTON_C:
				bop.resId =0xFF;
				break;
			case KeyEvent.KEYCODE_BUTTON_L1:
				if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_L1;
				else
					bop.resId = JnsIMEScreenView.BUTTON_L1;
				break;
			case KeyEvent.KEYCODE_BUTTON_L2:
				bop.resId = JnsIMEScreenView.BUTTON_L2;
				break;
			case KeyEvent.KEYCODE_BUTTON_MODE:
				bop.resId  = 0xFF;
				break;
			case KeyEvent.KEYCODE_BUTTON_R1:
				if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_R1;
				else
					bop.resId = JnsIMEScreenView.BUTTON_R1;
				break;
			case KeyEvent.KEYCODE_BUTTON_R2:
				bop.resId = JnsIMEScreenView.BUTTON_R2;
				break;
			case KeyEvent.KEYCODE_BUTTON_SELECT:
				if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_SELECT;
				else
					bop.resId = JnsIMEScreenView.BUTTON_SELECT;
				break;
			case KeyEvent.KEYCODE_BUTTON_START:
				if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_START;
				else
					bop.resId = JnsIMEScreenView.BUTTON_START;
				break;
			case KeyEvent.KEYCODE_BUTTON_THUMBL:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_BUTTON_THUMBR:
				bop.resId = 0xFF;;
				break;
			case KeyEvent.KEYCODE_BUTTON_X:
				if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_X;
				else
					bop.resId = JnsIMEScreenView.BUTTON_X;
				break;
			case KeyEvent.KEYCODE_BUTTON_Y:
				if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_Y;
				else
					bop.resId = JnsIMEScreenView.BUTTON_Y;
				break;
			case KeyEvent.KEYCODE_BUTTON_Z:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_DPAD_CENTER:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				if(TYPE_G)
					bop.resId = BUTTON_G_DOWN;
				else if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_DOWN;
				else
					bop.resId = BUTTON_DOWN;
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				if(TYPE_G)
					bop.resId = BUTTON_G_LEFT;
				else if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_LEFT;
				else
					bop.resId = BUTTON_LEFT;
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				if(TYPE_G)
					bop.resId = BUTTON_G_RIGHT;
				else if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_RIGHT;
				else
					bop.resId =BUTTON_RIGHT;
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				if(TYPE_G)
					bop.resId = BUTTON_G_UP;
				else if(TYPE_C)
					bop.resId = JnsIMEScreenView.BUTTON_C_UP;
				else
					bop.resId = BUTTON_UP;
				break;
			case KeyEvent.KEYCODE_LEFT_BRACKET:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_MEDIA_NEXT:
				bop.resId = 0xFF;//BUTTON_M_NEXT;
				break;
			case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
				bop.resId = 0XFF;//BUTTON_M_PAUSE;
				break;
			case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
				bop.resId = 0XFF;//BUTTON_M_PREVIEW;
				break;
			case KeyEvent.KEYCODE_MEDIA_REWIND:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_MEDIA_STOP:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_MINUS:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_NUM:
				bop.resId = 0xFF;
				break;
			case KeyEvent. KEYCODE_PAGE_DOWN:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_PAGE_UP:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_PICTSYMBOLS:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_PLUS:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_POUND:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_RIGHT_BRACKET:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SEARCH:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SEMICOLON:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SHIFT_LEFT:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SHIFT_RIGHT:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SLASH:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SOFT_LEFT:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SOFT_RIGHT:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SPACE:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_STAR:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_SYM:
				bop.resId = 0xFF;
				break;
			case KeyEvent.KEYCODE_TAB:
				bop.resId = 0xFF;
				break;
		 }
		 if(profile.posType == JnsIMEProfile.LEFT_JOYSTICK)
		 { 
			 bop.resId = JnsIMEScreenView.STICK_L;
			 bop.type = JnsIMEPosition.TYPE_LEFT_JOYSTICK;
		 } 
		 else if(profile.posType == JnsIMEProfile.RIGHT_JOYSTICK)
		 {	 
			 bop.resId = JnsIMEScreenView.STICK_R;
			 bop.type = JnsIMEPosition.TYPE_RIGHT_JOYSTICK;
		 } 
		 else
			 bop.type = JnsIMEPosition.TYPE_OTHERS;
		 bop.scancode = profile.key;
		 bop.r = profile.posR;
		 bop.x = profile.posX;
		 bop.y = profile.posY;
		 this.posList.add(bop);
	}
	public JnsIMEScreenView(Context context, AttributeSet attrs) {
		super(context, attrs);
		areaPaint = new Paint();
		areaPaint.setColor(Color.RED);
		infoPaint = new Paint();
		infoPaint.setColor(Color.RED);
		posList = new ArrayList<JnsIMEPosition>();
		rect = new Rect();
		for(JnsIMEProfile profile : JnsIMECoreService.keyList)
		{
			loadOldKey(profile);
		}	
		// TODO Auto-generated constructor stub
		new Thread(this).start();
	}
	
	@Override
	public void onDraw(Canvas canvas) {
	//	drawTouchArea(canvas);
		drawInfo(canvas);
		drawCurrentArea(canvas);
		drawable=false;
	}
	
	
	private void drawCurrentArea(Canvas canvas) {
		if (!drawable) return;
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		if(drawPos)
		if (radius == 0)
		canvas.drawBitmap(bitmap[BUTTOM_BG],tx - bitmap[BUTTOM_BG].getWidth()/2,
				ty - bitmap[BUTTOM_BG].getHeight()/2, null);
		else
		{
		
		canvas.drawBitmap(DrawableUtil.zoomBitmap(bitmap[BUTTOM_BG], 2 * (int)radius, 2 * (int)radius),
				tx - radius,ty - radius, null);
		}
	}
	
	public void setColor(int color) {
		areaPaint.setColor(color);
	}
	
	private void drawInfo(Canvas canvas) {
		if (posList == null) return;
		for (int i = 0; i < posList.size(); i ++) {
			JnsIMEPosition bop = posList.get(i);
			if(bop.resId == 0xFF)
			{	Log.d(TAG, "A INVALID BUTTON");
				continue;
			}
			if(TYPE_G)
			{
				canvas.drawBitmap(g_bitmap[bop.resId],bop.x - g_bitmap[bop.resId].getWidth()/2,
						bop.y - g_bitmap[bop.resId].getHeight()/2, null);
			}
			else if(TYPE_C)
			{	
				canvas.drawBitmap(c_bitmap[bop.resId],bop.x - c_bitmap[bop.resId].getWidth()/2,
						bop.y - c_bitmap[bop.resId].getHeight()/2, null);
			}
			else
			{	
				Log.d(TAG,"bitmap[bop.resId].getWidth() = "+(bitmap[bop.resId].getWidth()));
				canvas.drawBitmap(bitmap[bop.resId],bop.x - bitmap[bop.resId].getWidth()/2,
						bop.y - bitmap[bop.resId].getHeight()/2, null);
			}
			//infoPaint.getTextBounds(bop.msg.toCharArray(), 0, bop.msg.length(), rect);
			//canvas.drawText(bop.msg, bop.x - rect.width()/2, bop.y + rect.height()/2, infoPaint);		
			if(bop.r > 0)
			{
				Paint paint = new Paint();
				paint.setColor(Color.BLACK);
				paint.setStyle(Paint.Style.STROKE);
				canvas.drawCircle(bop.x,bop.y, bop.r, paint);
			}	
		}
	}
	
	public void drawCircle(float x, float y) {
		tx = x;
		ty = y;
		radius = 30;
		isCircle = false;
	}
	public void drawBitmap(float x, float y, int id) {
		tx = x;
		ty = y;
		radius = 0;
		currentBitmapId = id;
	}
	public void drawCircle2(float x, float y, float r) {
		tx = x;
		ty = y;
		radius = r;
		isCircle = true;
	}
	
	public float getTouchX() {
		return tx;
	}
	
	public float getTouchY() {
		return ty;
	}
	
	public float getTouchR() {
		return isCircle ? radius : 0;
	}
	
	public void setCircleType(float type) {
		this.type = type;
	}
	
	public float getCircleType() {
		return type; 
	}
	
	public void drawInfo(String msg) {
		this.msg = msg;
	}
	
	public void drawNow(boolean drawable, boolean drawPos) {
		this.drawable = drawable;
		this.drawPos = drawPos;
	}

	@Override
	public void run() {
		Thread.currentThread();
		// TODO Auto-generated method stub
		while (!Thread.interrupted()) {
			try {
				if(drawable)
				postInvalidate();
				Thread.sleep(100);
			} catch (Exception io) {
				
			}
		}
	}
}
