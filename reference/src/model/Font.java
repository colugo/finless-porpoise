package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;

import model.Font.QuadrantType;

public class Font {

	
	static HashMap<Character, HashMap<Point, Dimension>> map = new HashMap<Character, HashMap<Point, Dimension>>();
	
	public static String display = "78:90";
	
	private static void add(HashMap<Point, Dimension> map, int x, int y, int hours, int minutes){
		map.put(new Point(x, y), new Dimension(hours, minutes));
	}
	
	public static void prepare(){
		
		add1Digit();
		add2Digit();
		add3Digit();
		add4Digit();
		add5Digit();
		add6Digit();
		add7Digit();
		add8Digit();
		add9Digit();
		add0Digit();
		addColon();
	}

	private static void add1Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 90);
		add(map1, 1, 1, 180, 270);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 225, 225);
		add(map1, 1, 2, 0, 180);
		add(map1, 2, 2, 0, 180);
		
		add(map1, 0, 3, 225, 225);
		add(map1, 1, 3, 0, 180);
		add(map1, 2, 3, 0, 180);
		
		add(map1, 0, 4, 225, 225);
		add(map1, 1, 4, 0, 180);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 225, 225);
		add(map1, 1, 5, 0, 90);
		add(map1, 2, 5, 0, 270);
		map.put('1', map1);
	}
	
	private static void add2Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 90);
		add(map1, 1, 1, 180, 270);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 90, 180);
		add(map1, 1, 2, 0, 270);
		add(map1, 2, 2, 0, 180);
		
		add(map1, 0, 3, 0, 180);
		add(map1, 1, 3, 180, 90);
		add(map1, 2, 3, 0, 270);
		
		add(map1, 0, 4, 0, 180);
		add(map1, 1, 4, 0, 90);
		add(map1, 2, 4, 270, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('2', map1);
	}
	
	private static void add3Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 90);
		add(map1, 1, 1, 180, 270);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 90, 180);
		add(map1, 1, 2, 0, 270);
		add(map1, 2, 2, 0, 180);
		
		add(map1, 0, 3, 0, 90);
		add(map1, 1, 3, 180, 270);
		add(map1, 2, 3, 0, 180);
		
		add(map1, 0, 4, 90, 180);
		add(map1, 1, 4, 0, 270);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('3', map1);
	}
	
	private static void add4Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 180);
		add(map1, 2, 0, 180, 270);

		add(map1, 0, 1, 0, 180);
		add(map1, 1, 1, 180, 0);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 0, 180);
		add(map1, 1, 2, 0, 0);
		add(map1, 2, 2, 0, 180);
		
		add(map1, 0, 3, 0, 90);
		add(map1, 1, 3, 270, 180);
		add(map1, 2, 3, 0, 180);
		
		add(map1, 0, 4, 225, 225);
		add(map1, 1, 4, 0, 180);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 225, 225);
		add(map1, 1, 5, 0, 90);
		add(map1, 2, 5, 0, 270);
		map.put('4', map1);
	}

	private static void add5Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 180);
		add(map1, 1, 1, 180, 90);
		add(map1, 2, 1, 0, 270);
		
		add(map1, 0, 2, 0, 180);
		add(map1, 1, 2, 0, 90);
		add(map1, 2, 2, 270, 180);
		
		add(map1, 0, 3, 0, 90);
		add(map1, 1, 3, 180, 270);
		add(map1, 2, 3, 0, 180);
		
		add(map1, 0, 4, 90, 180);
		add(map1, 1, 4, 0, 270);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('5', map1);
	}
	
	private static void add6Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 180);
		add(map1, 1, 1, 180, 90);
		add(map1, 2, 1, 0, 270);
		
		add(map1, 0, 2, 0, 180);
		add(map1, 1, 2, 0, 90);
		add(map1, 2, 2, 270, 180);
		
		add(map1, 0, 3, 0, 180);
		add(map1, 1, 3, 180, 180);
		add(map1, 2, 3, 0, 180);
		
		add(map1, 0, 4, 0, 180);
		add(map1, 1, 4, 0, 0);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('6', map1);
	}

	private static void add7Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 90);
		add(map1, 1, 1, 180, 270);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 225, 225);
		add(map1, 1, 2, 0, 225);
		add(map1, 2, 2, 0, 225);
		
		add(map1, 0, 3, 180, 45);
		add(map1, 1, 3, 180, 45);
		add(map1, 2, 3, 225, 225);
		
		add(map1, 0, 4, 0, 180);
		add(map1, 1, 4, 0, 180);
		add(map1, 2, 4, 225, 225);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 0, 270);
		add(map1, 2, 5, 225, 225);
		map.put('7', map1);
	}
	
	private static void add8Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 180);
		add(map1, 1, 1, 180, 180);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 0, 135);
		add(map1, 1, 2, 0, 0);
		add(map1, 2, 2, 0, 225);
		
		add(map1, 0, 3, 180, 45);
		add(map1, 1, 3, 180, 180);
		add(map1, 2, 3, 180, 315);
		
		add(map1, 0, 4, 0, 180);
		add(map1, 1, 4, 0, 0);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('8', map1);
	}
	
	private static void add9Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 180);
		add(map1, 1, 1, 180, 180);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 0, 180);
		add(map1, 1, 2, 0, 0);
		add(map1, 2, 2, 0, 180);
		
		add(map1, 0, 3, 0, 90);
		add(map1, 1, 3, 180, 270);
		add(map1, 2, 3, 0, 180);
		
		add(map1, 0, 4, 90, 180);
		add(map1, 1, 4, 0, 270);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('9', map1);
	}
	
	private static void add0Digit() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 180, 90);
		add(map1, 1, 0, 270, 90);
		add(map1, 2, 0, 270, 180);

		add(map1, 0, 1, 0, 180);
		add(map1, 1, 1, 180, 180);
		add(map1, 2, 1, 0, 180);
		
		add(map1, 0, 2, 0, 180);
		add(map1, 1, 2, 0, 180);
		add(map1, 2, 2, 0, 180);
		
		add(map1, 0, 3, 180, 0);
		add(map1, 1, 3, 180, 0);
		add(map1, 2, 3, 180, 0);
		
		add(map1, 0, 4, 0, 180);
		add(map1, 1, 4, 0, 0);
		add(map1, 2, 4, 0, 180);
		
		add(map1, 0, 5, 0, 90);
		add(map1, 1, 5, 270, 90);
		add(map1, 2, 5, 270, 0);
		
		map.put('0', map1);
	}
	
	private static void addColon() {
		HashMap<Point, Dimension> map1 = new HashMap<Point, Dimension>();
		add(map1, 0, 0, 225, 225);
		add(map1, 1, 0, 225, 225);
	
		add(map1, 0, 1, 180, 90);
		add(map1, 1, 1, 180, 270);
		
		add(map1, 0, 2, 0, 90);
		add(map1, 1, 2, 270, 0);
		
		add(map1, 0, 3, 180, 90);
		add(map1, 1, 3, 180, 270);
		
		add(map1, 0, 4, 0, 90);
		add(map1, 1, 4, 270, 0);
		
		add(map1, 0, 5, 225, 225);
		add(map1, 1, 5, 225, 225);
		
		map.put(':', map1);
	}
	
	public static Dimension getDimensionForPosition(int position){
		int digit = whichDigitForPosition(position);
		char digitChar = display.charAt(digit);
		Point pointForPositionInDigit = whichPointInDigitForPosition(position);
		
		if(map.containsKey(digitChar)){
			Dimension dim = map.get(digitChar).get(pointForPositionInDigit);
			return dim;
		}
		
		return null;
	}
	
	
	public static int whichDigitForPosition(int position){
		int temp = position % 14;
		
		if(temp <= 2) return 0;
		if(temp <= 5) return 1;
		if(temp <= 7) return 2;
		if(temp <= 10) return 3;
		if(temp <= 13) return 4;
		
		return -1;
	}
	
	public static Point whichPointInDigitForPosition(int position){
		//int digit = whichDigitForPosition(position);
		
		int xCoord = 0;
		int yCoord = 0;
		
		yCoord = position / 14;
		switch(position % 14){
		case 0: xCoord = 0; break;
		case 1: xCoord = 1; break;
		case 2: xCoord = 2; break;
		
		case 3: xCoord = 0; break;
		case 4: xCoord = 1; break;
		case 5: xCoord = 2; break;
		
		case 6: xCoord = 0; break;
		case 7: xCoord = 1; break;
		
		case 8: xCoord = 0; break;
		case 9: xCoord = 1; break;
		case 10: xCoord = 2; break;
		
		case 11: xCoord = 0; break;
		case 12: xCoord = 1; break;
		case 13: xCoord = 2; break;
			
		}
		
		return new Point(xCoord, yCoord);
	}
	
	
	
	public enum QuadrantType {QUAD_UL, QUAD_UR, QUAD_LL, QUAD_LR};
	public static QuadrantType whichQuadrantForPosition(int position){
		if(position % 2 == 0){
			if((position / 14) % 2 == 0){
				return QuadrantType.QUAD_UL;
			}
			else{
				return QuadrantType.QUAD_LL;
			}
		}
		else{
			if((position / 14) % 2 == 0){
				return QuadrantType.QUAD_UR;
			}
			else{
				return QuadrantType.QUAD_LR;
			}
		}
	}

	public static QuadrantType whichQuadrantOnGrid(int position) {
		if(position % 14 < 7){
			// left side
			if(position / 14 < 3){
				// top
				return QuadrantType.QUAD_UL;
			}
			else{
				// botom
				return QuadrantType.QUAD_LL;
			}
		}else
		{
			// right side
			if(position / 14 < 3){
				// top
				return QuadrantType.QUAD_UR;
			}
			else{
				// botom
				return QuadrantType.QUAD_LR;
			}
		}
		
	}
	
	
	//public static Point 
	
}
