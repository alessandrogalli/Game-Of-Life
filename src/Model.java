import java.awt.Color;

class Model {
	
	private int size;
	private int steps;

	private PointColor[][] board;

	public Model(int size) {
		this.size = size;
		this.board = new PointColor[size][size];
        for (int i=0; i<size; i++) {
        	for (int j=0; j<size; j++) {
        		this.board[i][j] = new PointColor(i, j, Color.GRAY);
        	}
        }
	}
	
	public void clear() {
		this.steps = 0;
        for (int i=0; i<size; i++) {
        	for (int j=0; j<size; j++) {
        		this.board[i][j] = new PointColor(i, j, Color.GRAY);
        	}
        }
	}
	
	public void step() {
		PointColor[][] nextBoard = new PointColor[size][size];
        for (int i=0; i<size; i++) {
        	for (int j=0; j<size; j++) {
        		nextBoard[i][j] = new PointColor(i, j, board[i][j].getColor());
        	}
        }		
		this.steps++;
        for (int i=0; i<size; i++) {
        	for (int j=0; j<size; j++) {
        		evaluatePoint(nextBoard[i][j]);
        	}
        }		
        board = nextBoard;
	}
	
	private void evaluatePoint(PointColor p) {
		if (isCellAlive(p)) {
			if (countNeighbours(p) < 2 || countNeighbours(p) > 3)
				p.setColor(Color.GRAY);
		}
		else {
			if (countNeighbours(p) == 3) {
				p.setColor(whichColor(p));
			}
		}
	}
	
	private int countNeighbours(PointColor p) {
		int count = 0;
		int x = p.getX();
		int y = p.getY();
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				if (i!=x || j!=y) {
					if (isCellAlive(board[wrap(i)][wrap(j)]))
						count++;
				}
			}
		}
		return count;
	}
	
	private int wrap(int n){
		n = n%size;
		if (n < 0)
			n += size;
		return n;
	}
	
	private Color whichColor(PointColor p){
		int red = 0;
		int green = 0;
		int x = p.getX();
		int y = p.getY();
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				if (i!=x || j!=y) {
					if (board[wrap(i)][wrap(j)].getColor().equals(Color.RED))
						red++;
					else if (board[wrap(i)][wrap(j)].getColor().equals(Color.GREEN))
						green++;			
				}
			}
		}
		if (red > green)
			return Color.RED;
		else
			return Color.GREEN;
	}
	
	private boolean isCellAlive(PointColor p) {
		if (p.getColor().equals(Color.GRAY))
			return false;
		else
			return true;
	}
	
	public PointColor getPoint(int x, int y) {
		return board[x][y];
	}
	
	public void setPoint(int x, int y, Color bg) {
		board[x][y].setColor(bg);
	}
	
	public int getSteps() {
		return steps;
	}
	
}