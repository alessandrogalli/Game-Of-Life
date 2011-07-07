import java.awt.Color;
import javax.swing.Timer;


public class Controller {

	private Model model;
	private View view;
	
	protected boolean running;
	private Timer timer;
		
    public Controller( Model model, View view) {
        this.model = model;
        this.view = view;
        this.running = false;
        this.timer = new Timer(2000/view.speed, null);
        bind();
    }
  
    private void bind() {
    	
    	view.getSlider().addChangeListener(new MySliderListener(this));
    	view.getClear().addActionListener(new MyButtonListener(this));
    	view.getStep().addActionListener(new MyButtonListener(this));
    	view.getStop().addActionListener(new MyButtonListener(this));
    	view.getRun().addActionListener(new MyButtonListener(this));
    	timer.addActionListener(new MyTimerListener(this));
    	
    	for (int i=0; i<view.size; i++) {
    		for (int j=0; j<view.size; j++) {
    			view.getCell(i, j).addMouseListener(new MyMouseListener(this, i, j));
    		}
    	}
    
    }
    
    public void changeSpeed(int speed) {
		view.speed = speed;
		timer.setDelay(2000/view.speed);	
    }
    
    
    public void changeColor(int x, int y, Color color) {
    	model.setPoint(x, y, color);
    	view.setCell(x, y, color);
    }
    
    
    public void Step() {
    	model.step();
		view.updateBoard();
    }

    public void Stop() {
		System.exit(0);
    }
	
    public void Run() {
		view.getRun().setText("Pause");
		running = true;
		view.setButton(view.getClear(), false);
		view.setButton(view.getStop(), false);
		view.setButton(view.getStep(), false);
		timer.start();   	
    }
    
    public void Pause() {
		view.getRun().setText("Run");
		running = false;
		view.setButton(view.getClear(), true);
		view.setButton(view.getStop(), true);
		view.setButton(view.getStep(), true);
		timer.stop();    	
    }
    
    public void Clear() {
		model.clear();
		view.updateBoard();
    }
        
}
