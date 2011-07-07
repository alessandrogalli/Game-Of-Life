
public class Life {

    public static void main(String [] args) {
    	    	
    	final int rows;
    	if (args.length > 0)
    		rows = Integer.parseInt(args[0]);
    	else
    		rows = 30;
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model mod = new Model(rows);
                View gui = new View(rows, mod);
                new Controller(mod, gui);
            }
        });
        
    }
	
}
