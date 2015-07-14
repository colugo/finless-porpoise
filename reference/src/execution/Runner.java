package execution;

import javax.swing.JFrame;

import model.Font;
import viewModel.MainViewModel;

public class Runner {

	
	private static JFrame frame;
	
	public static void main(String[] args) {
		
		Font.prepare();
		
		frame = new JFrame();
		MainViewModel mainViewModel = new MainViewModel();
		
        frame.setSize(900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainViewModel);
                
	}


}
