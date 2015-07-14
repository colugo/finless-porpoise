package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import viewModel.ClockViewModel;

public class ClockView {
	public static final int CLOCK_RADIUS = 32;
	public static final int HOUR_LENGTH = (int) (CLOCK_RADIUS * 0.70);
	public static final int MINUTE_LENGTH = (int) (CLOCK_RADIUS * 0.90);
	private Stroke thin = new BasicStroke((float) 1.0);
	private Stroke thick = new BasicStroke((float) 4);
	
	private ClockViewModel _model = new ClockViewModel();
	private int _row;
	private int _col;
	
	private static ArrayList<ClockView> _list = new ArrayList<ClockView>();
	public static void paintAll(Graphics2D g2d) {
		for(ClockView view : _list){
			view.paint(g2d);
		}
	}
	
	public ClockView(int col, int row) {
		this._row = row;
		this._col = col;
		
		_list.add(this);
	}

	public void paint(Graphics2D g2d){
		int xOff = _col * CLOCK_RADIUS * 2;
		int yOff = _row * CLOCK_RADIUS * 2;
		g2d.setColor(Color.LIGHT_GRAY);
		Ellipse2D face = new Ellipse2D.Double(xOff, yOff, CLOCK_RADIUS * 2,CLOCK_RADIUS * 2);
		g2d.setStroke(thin);
		//g2d.draw(face);
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(thick);
		
		Point2D center = new Point2D.Double(xOff + CLOCK_RADIUS, yOff + CLOCK_RADIUS);
		Point2D hourPoint = new Point2D.Double(
				center.getX() + HOUR_LENGTH * Math.sin( _model.getHour() ),
				center.getY() + HOUR_LENGTH * Math.cos( _model.getHour() )
		);
		
		Point2D minutePoint = new Point2D.Double(
				center.getX() + MINUTE_LENGTH * Math.sin( _model.getMinute() ),
				center.getY() + MINUTE_LENGTH * Math.cos( _model.getMinute() )
		);
		
		Line2D hourHand = new Line2D.Double(center, hourPoint);
		g2d.draw(hourHand);
		
		Line2D minuteHand = new Line2D.Double(center, minutePoint);
		g2d.draw(minuteHand);
		
	}


	
}
