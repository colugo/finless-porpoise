package viewModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.ClockMotionManager;
import model.Font;
import view.ClockView;

@SuppressWarnings("serial")
public class MainViewModel extends JPanel implements ActionListener {
	
	private final Timer timer = new Timer(30, this);
	
	public MainViewModel(){
		for(int y = 0; y < 6; y ++){
			for(int i = 0; i < 14; i++){
				new ClockView(i, y);
			}
		}
		
		timer.start();
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(
			    RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_OFF);
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 950,400);
		
		g2d.setColor(Color.BLACK);
		ClockView.paintAll(g2d);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm");
		Font.display = df.format(date);
		
		ClockMotionManager.update();
		this.repaint();
	}
}
