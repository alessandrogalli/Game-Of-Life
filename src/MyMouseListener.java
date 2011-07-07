import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;


public class MyMouseListener extends MouseAdapter {

	private Controller controller;
	private int x;
	private int y;
	
	public MyMouseListener(Controller controller, int x, int y) {
		this.controller = controller;
		this.x = x;
		this.y = y;
	}
	
	public void mouseClicked(MouseEvent e) {
				
//		JButton sender = (JButton)e.getSource();

		if (!controller.running) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				controller.changeColor(x, y, Color.RED);
			} else if (SwingUtilities.isRightMouseButton(e)) {
				controller.changeColor(x, y, Color.GREEN);
			} else if (SwingUtilities.isMiddleMouseButton(e)) {
				controller.changeColor(x, y, Color.GRAY);
			}
		}
	
	}

}
