package viewModel;

import model.ClockModel;

public class ClockViewModel {
	private ClockModel _clockModel = new ClockModel();

	public double getHour(){
		return Math.toRadians( 180 - _clockModel.getHourAngle());
	}

	
	public double getMinute(){
		return Math.toRadians( 180 - _clockModel.getMinuteAngle());
	}


	public void addHour() {
		_clockModel.rotateHour();
	}

}
