import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyTimerListener implements ActionListener {
	
	private Controller controller;
	
	public MyTimerListener(Controller controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.Step();
	}

}
