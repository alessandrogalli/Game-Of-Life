import javax.swing.*;

import java.awt.*;

public class View {
	
    private Model model;
	
    private JLabel result;
    
    protected int speed;
    protected int size;
    private JSlider slide;
    private JPanel square;
    private JButton[][] cells;
    private Box controls;
    
    private JButton clear;
    private JButton step;
    private JButton run;
    private JButton stop;
    
    public View(int rows, Model mod) {

    	this.size = rows;
    	this.model = mod;
    	this.speed = 5;
    	
    	
    	result = new JLabel("0",SwingConstants.CENTER);
    	
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        Container contentPane =  frame.getContentPane();

        /* BUILDING THE GRID */
        square = new JPanel();
        square.setLayout(new GridLayout(size, size));
        cells = new JButton[size][size];
        
        for (int i=0; i<size; i++) {
        	for (int j=0; j<size; j++) {
        		JButton cell = new JButton();
        		cell.setBackground(Color.GRAY);
        		cell.setOpaque(true);
        		cells[i][j] = cell;
            	square.add(cell);
        	}
        }
              
        /* BUILDING THE SLIDER */
        slide = new JSlider(JSlider.VERTICAL,1,10,5);
        slide.setMajorTickSpacing(2);
        slide.setMinorTickSpacing(1);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        /* BUILDING THE CONTROLS BOX */
        controls = new Box(BoxLayout.X_AXIS);
        clear = new JButton("Clear");
        step = new JButton("Step");
        run = new JButton("Run");
        stop = new JButton("Stop");
        controls.add(clear);
        controls.add(step);
        controls.add(run);
        controls.add(stop);
      
        /* ADDING COMPONENTS TO THE CONTAINER */
        contentPane.add(slide,BorderLayout.EAST);
        contentPane.add(result,BorderLayout.NORTH);
        contentPane.add(square,BorderLayout.CENTER);
        contentPane.add(controls,BorderLayout.SOUTH);
        
        frame.setVisible(true);
        
	}
	
    public void updateBoard() {
		this.result.setText(Integer.toString(model.getSteps()));
        for (int i=0; i<size; i++) {
        	for (int j=0; j<size; j++) {
        		setCell(i, j, model.getPoint(i, j).getColor());
        	}
        }
    }
    
    public void setButton(JButton b, boolean enable) {
    		b.setEnabled(enable);
    }
    
	public void setCell(int x, int y, Color bg) {
    	cells[x][y].setBackground(bg);
    	if (bg.equals(Color.GRAY))
    	   	cells[x][y].setText("");
    	else if (bg.equals(Color.GREEN))
    	   	cells[x][y].setText("G");
    	else
    	   	cells[x][y].setText("R");  		
	}    
    
    public JSlider getSlider() {
    	return slide;
    }
    
    public JButton getCell(int x, int y) {
    	return cells[x][y];
    }
    
    public JButton getClear() {
		return clear;
	}

	public JButton getStep() {
		return step;
	}

	public JButton getRun() {
		return run;
	}

	public JButton getStop() {
		return stop;
	}
	
}
