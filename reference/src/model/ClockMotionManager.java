package model;

import java.awt.Dimension;
import java.util.Random;

import model.Font.QuadrantType;

public class ClockMotionManager {
	private static int updateCount = 0;
	
	public static boolean goalSeeking = true;
	
	private static EnumAnimation animationMode = EnumAnimation.ANIMATE_CCW;
	private static EnumGoal goalMode = EnumGoal.SET_HORIZONTAL;
	static Random generator = new Random();
	
	public enum EnumAnimation {
			ANIMATE_CCW,
			ANIMATE_CHICKENWIRE,
			ANIMATE_PACMAN,
			ANIMATE_CIRCLES;
			
			public static EnumAnimation random(){
				EnumAnimation[] choices = EnumAnimation.values();
				return choices[generator.nextInt(choices.length)];
		    }
		};
		
	public enum EnumGoal {
			SET_WAVE,
			SET_TIME,
			SET_CHICKENWIRE,
			SET_HORIZONTAL,
			SET_VERTICAL,
			SET_CIRCLES,
			SET_STRIPE,
			SET_DIAGONAL;
			
			public static EnumGoal random(){
				EnumGoal[] choices = EnumGoal.values();
			    return choices[generator.nextInt(choices.length)];
			   }
			
		};
	
	
	
	public static void update() {
		updateCount ++;
		int position = -1;
		for(ClockModel model : ClockModel.instancesList){
			position++;
			
			determineMode();
			
			goalSetChickenWire(position, model);
			goalSetCircles(position, model);
			goalSetFixateTime(position, model);
			goalSetHorizontal(model);
			goalSetVertical(model);
			goalSetWave(position, model);
			goalSetStripe(position, model);
			goalSetDiagonal(model);
			
			animateChickenWire(position, model);
			animatePacMan(model);			
			animateRotateCCW(model);
			animateCircles(position, model);
		
		}
	}

	private static void goalSetDiagonal(ClockModel model) {
		if(goalMode == EnumGoal.SET_DIAGONAL){
			model.hoursGoal = 270 + 45;
			model.minutesGoal = 90 + 45;
		}
	}
	
	private static void goalSetVertical(ClockModel model) {
		if(goalMode == EnumGoal.SET_VERTICAL){
			model.hoursGoal = 0;
			model.minutesGoal = 180;
		}
	}
	
	private static void goalSetStripe(int position, ClockModel model) {
		if(goalMode == EnumGoal.SET_STRIPE){
			if(position % 14 <= 5 || position % 14 >= 8){
				model.hoursGoal = 270;
				model.minutesGoal = 90;
			}else{
				model.hoursGoal = 0;
				model.minutesGoal = 180;
			}
		}
	}

	private static void goalSetWave(int position, ClockModel model){
		if(goalMode == EnumGoal.SET_WAVE){
			int column = position % 14;
			int angle = column * 10;
			model.hoursGoal = angle;
			model.minutesGoal = (180 + angle);
		}
	}
	
	private static void goalSetHorizontal(ClockModel model){
		if(goalMode == EnumGoal.SET_HORIZONTAL){
			model.hoursGoal = 270;
			model.minutesGoal = 90;
		}	
	}

	
	private static void goalSetChickenWire(int position, ClockModel model){
		if(goalMode == EnumGoal.SET_CHICKENWIRE){
			QuadrantType quadrant = Font.whichQuadrantForPosition(position);
			
			switch(quadrant){
			case QUAD_UL:
				model.hoursGoal = 315;
				model.minutesGoal = 135;
				break;
			
			case QUAD_UR:
				model.hoursGoal = 45;
				model.minutesGoal = 225;
				break;
				
			case QUAD_LL:
				model.hoursGoal = 45;
				model.minutesGoal = 225;
				break;
				
			case QUAD_LR:
				model.hoursGoal = 315;
				model.minutesGoal = 135;
				break;
			}
		}
	}
	
	private static void goalSetCircles(int position, ClockModel model){
		if(goalMode == EnumGoal.SET_CIRCLES){
			QuadrantType quadrant = Font.whichQuadrantOnGrid(position);
			
			int horiz = Math.abs(7 - position % 14);
			int vert = Math.abs(3 - position / 14);
			
			int distanceFromCenter = (horiz + vert) * 6 % 360;
			
			int offsetAmount = 18 + distanceFromCenter;
			
			if(position == 34 || position == 35 || position == 48 || position == 49){
				offsetAmount = 15;
			}
			
			int factors5 = offsetAmount / 5;
			offsetAmount = factors5 * 5;
			
			switch(quadrant){
			case QUAD_UL:
				model.hoursGoal = 180 + offsetAmount;
				model.minutesGoal = 90 - offsetAmount;
				break;
			
			case QUAD_UR:
				model.hoursGoal = 270 + offsetAmount;
				model.minutesGoal = 180 - offsetAmount;
				break;
				
			case QUAD_LL:
				model.hoursGoal = 90 + offsetAmount;
				model.minutesGoal = 360 - offsetAmount;
				break;
				
			case QUAD_LR:
				model.hoursGoal = 0 + offsetAmount;
				model.minutesGoal = 270 - offsetAmount;
				break;
			}
		}
	}

	
	private static void animateChickenWire(int position, ClockModel model){
		if(animationMode == EnumAnimation.ANIMATE_CHICKENWIRE){
			QuadrantType quadrant = Font.whichQuadrantForPosition(position);
			
			switch(quadrant){
			case QUAD_UL:
				model.rotateHour();
				model.rotateMinute();
				break;
			
			case QUAD_UR:
				model.rotateHour();
				model.rotateMinute();
				break;
				
			case QUAD_LL:
				model.rotateHour();
				model.rotateMinute();
				break;
				
			case QUAD_LR:
				model.rotateHour();
				model.rotateMinute();
				break;
			}
		}
	}

	private static void goalSetFixateTime(int position, ClockModel model) {
		if(goalMode == EnumGoal.SET_TIME){
			
			Dimension wantedAngles = Font.getDimensionForPosition(position);
			if(wantedAngles != null)
			{
				model.hoursGoal = wantedAngles.width;
				model.minutesGoal = wantedAngles.height;
			}
			
		}
	}

	private static void animatePacMan(ClockModel model) {
		if(animationMode == EnumAnimation.ANIMATE_PACMAN){
			model.rotateHour();
			model.rotateHour();
			model.rotateMinute();
		}
	}
	
	private static void animateCircles(int position, ClockModel model) {
		if(animationMode == EnumAnimation.ANIMATE_CIRCLES){
			QuadrantType quadrant = Font.whichQuadrantOnGrid(position);
			switch(quadrant){
			case QUAD_UL:
				model.rotateHour();
				model.rotateMinute();
				break;
			
			case QUAD_UR:
				model.rotateHour();
				model.rotateMinute();
				break;
				
			case QUAD_LL:
				model.rotateHour();
				model.rotateMinute();
				break;
				
			case QUAD_LR:
				model.rotateHour();
				model.rotateMinute();
				break;
			}
			
		}
	}
	
	private static void animateRotateCCW(ClockModel model) {
		if(animationMode == EnumAnimation.ANIMATE_CCW){
			model.rotateHour();
			model.rotateMinute();
		}
	}
	
	private static boolean allGoalsMetAndTime(int updateLower, int updateHigher){
		if(updateCount < updateLower || updateCount > updateHigher){
			return false;
		}
		
		for(ClockModel model : ClockModel.instancesList)
		{
			if(!model.isGoalMet()){
				return false;
			}
		}
		
		return true;
	}

	private static void determineMode() {
		//modePattern1();
		//modePattern2();
		modePattern3();
		
	}

	private static void modePattern1() {
		
		if(updateCount == 1) goalMode = EnumGoal.SET_WAVE;
		if(updateCount == 3) animationMode = EnumAnimation.ANIMATE_CCW;
		if(allGoalsMetAndTime(5, (int)(360 * 1.5))) goalSeeking = false;
		if(allGoalsMetAndTime(360 * 1, 360 * 2) ) goalMode=EnumGoal.SET_CHICKENWIRE;
		if(updateCount == 360 * 2 ) goalSeeking = true;
		if(allGoalsMetAndTime(360 * 2, 360 * 4) ) goalSeeking = false;
		if(updateCount == 360 * 4) goalMode = EnumGoal.SET_TIME;
		
		
		if(updateCount == 360 * 4 ) goalSeeking = true;
		if(updateCount == 360 * 5 ) goalMode=EnumGoal.SET_CHICKENWIRE;
		if(updateCount == 360 * 5 ) animationMode=EnumAnimation.ANIMATE_CHICKENWIRE;
		if(updateCount == 360 * 7 ) goalSeeking = false;
		if(updateCount == 360 * 7) goalMode = EnumGoal.SET_WAVE;
		if(updateCount == 360 * 7.5) goalSeeking = true;
		if(updateCount == 360 * 7) animationMode = EnumAnimation.ANIMATE_PACMAN;
		
		if(updateCount == 360 * 8) goalMode = EnumGoal.SET_HORIZONTAL;
		if(updateCount == 360 * 8) animationMode = EnumAnimation.ANIMATE_CHICKENWIRE;
		if(updateCount == 360 * 9) goalMode = EnumGoal.SET_TIME;		
		if(updateCount == 360 * 9) goalSeeking = true;
		
		if(allGoalsMetAndTime((int)(360 * 9.5), (int)(360 * 10.5)) )updateCount = 0;
	}
	
	
	private static void modePattern2(){
		
		/*
		goalMode = EnumGoal.SET_WAVE;
		animationMode = EnumAnimation.ANIMATE_CCW;
		*/
		
		/*
		animationMode = EnumAnimation.ANIMATE_CCW;
		goalMode=EnumGoal.SET_CHICKENWIRE;
		if(updateCount == 360 * 1 ) goalSeeking = false;
		*/
		
		/*
		animationMode = EnumAnimation.ANIMATE_CHICKENWIRE;
		goalMode=EnumGoal.SET_CHICKENWIRE;
		if(updateCount == 360 * 1 ) goalSeeking = false;
		*/
	
		/*
		animationMode = EnumAnimation.ANIMATE_PACMAN;
		goalMode=EnumGoal.SET_CHICKENWIRE;
		if(updateCount == 360 * 1 ) goalSeeking = false;
		*/
		
		if(updateCount == 360 * 1) goalMode = EnumGoal.SET_WAVE;
		if(updateCount == 360 * 1.5) goalSeeking = true;
		if(updateCount == 360 * 2) animationMode = EnumAnimation.ANIMATE_PACMAN;
		
		if(updateCount == 360 * 3) goalMode = EnumGoal.SET_HORIZONTAL;
		if(updateCount == 360 * 3) animationMode = EnumAnimation.ANIMATE_CHICKENWIRE;
		if(updateCount == 360 * 4) goalMode = EnumGoal.SET_TIME;		
		if(updateCount == 360 * 4) goalSeeking = true;
	}
	
	public static void modePattern3(){
		if(updateCount == 1){
			animationMode = EnumAnimation.random();
			goalMode=EnumGoal.random();
		}
		if(allGoalsMetAndTime((360 * 1) / 5, (360 * 2) / 5 )){
				goalSeeking = false;
				animationMode = EnumAnimation.random();
		}
		if(allGoalsMetAndTime((360 * 2) / 5, (360 * 3) / 5)){
			goalMode = EnumGoal.SET_TIME;		
			goalSeeking = true;
		}
		
		if(updateCount == (360 * 4) / 5){
			goalMode = EnumGoal.random();
			updateCount = 0;
		}
	}
	
	
	/* IDEAS
		change colour of backgrounds when showing time
		rotate chickenwire CCW
	
	 */
}
