import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class FilledSquare extends Drawable {

	/*
	 * Same as rectangle, except the width value is copied to the height.
	 */
	
	private int x, y, width, height;

	public FilledSquare(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = width;
	}

	public void draw(Graphics g) 
	{
		g.fillRect(x, y, width, height);
	}
	
	public boolean contains(int mouse_x, int mouse_y) 
	{

		Rectangle2D f_square = new Rectangle2D.Double(x, y, width, height);
		Point mouse = new Point(mouse_x, mouse_y);
		
		return(f_square.contains(mouse));
	}
	
	public String print() {
		String s = "";
		
		s += "filledsquare " + this.x + " " + this.y + " " + this.width ; 
		
		return s;
	}

}
