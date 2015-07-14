package model;

import java.util.ArrayList;

public class ClockModel {
	
	public static ArrayList<ClockModel> instancesList = new ArrayList<ClockModel>();
	public int hoursManual = 0;
	public int minutesManual = 0;
	
	public int hoursGoal;
	public int minutesGoal;
	
	private static final int STEP_ANGLE = 5;
	
	public ClockModel(){
		instancesList.add(this);
	}
	
	public boolean isGoalMet(){
		return hoursGoal == hoursManual && minutesGoal == minutesManual;
	}
	
	public int getHourAngle() {
		return this.hoursManual;
	}
	
	public int getMinuteAngle() {
		return this.minutesManual;
	}

	public void rotateMinute() {
		if(ClockMotionManager.goalSeeking && this.minutesManual == this.minutesGoal){
			return;
		}
		this.minutesManual = rotate(this.minutesManual);
	}

	public void rotateHour() {
		if(ClockMotionManager.goalSeeking && this.hoursManual == this.hoursGoal){
			return;
		}
		this.hoursManual = rotate(this.hoursManual);
	}
	
	private int rotate(int current){
		int temp = current + STEP_ANGLE;
		if(temp >= 360){
			return temp - 360;
		}
		if(temp < 0){
			return temp + 360;
		}
		return temp;
	}

}
