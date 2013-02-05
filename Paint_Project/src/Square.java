import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Square extends Drawable {

	private int x, y, width, height;

	public Square(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = width;
	}


	public void draw(Graphics g) 
	{
		g.drawRect(x, y, width, height);
	}

	/*
	 * We make a Rectangle2D variable with the same variable values as the shape's values. We then check
	 * if the mouse has intersected this shape. Returns the boolean value of the statement.
	 */
	public boolean contains(int mouse_x, int mouse_y) 
	{
		Rectangle2D square = new Rectangle2D.Double(x, y, width, height);
		Point mouse = new Point(mouse_x, mouse_y);
		
		return(square.contains(mouse));
	} 
	
	public String print() 
	{
		String s = "";	
		s += "square " + this.x + " " + this.y + " " + this.width; 
		return s;
	}

}
