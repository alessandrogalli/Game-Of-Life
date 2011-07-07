import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MySliderListener implements ChangeListener {
	
	private Controller controller;
	
	public MySliderListener(Controller controller) {
		this.controller = controller;
	}

	public void stateChanged(ChangeEvent expn) {
		JSlider source = (JSlider)expn.getSource();
		if (!source.getValueIsAdjusting()) {
			controller.changeSpeed((int)source.getValue());
		}
	}
}