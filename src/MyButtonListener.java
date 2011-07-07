import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class MyButtonListener implements ActionListener {
	
	private Controller controller;
	
	public MyButtonListener(Controller controller) {
		this.controller = controller;
	}

	public  void actionPerformed(ActionEvent event) {

		JButton sent = (JButton)event.getSource();

		String label = sent.getText();

		if (label.equals("Clear")) {
			controller.Clear();
		} else if (label.equals("Step")) {
			controller.Step();
		} else if (label.equals("Run")) {
			controller.Run();
		} else if (label.equals("Pause")){
			controller.Pause();
		} else {
			controller.Stop();
		}

	}

}
