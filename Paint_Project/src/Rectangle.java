import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Drawable {

	/*
	 * Same as square, yet height and width have a unique value. 
	 */

	private int x, y, width, height;

	public Rectangle(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g) 
	{
		g.drawRect(x, y, width, height);
	}

	public boolean contains(int mouse_x, int mouse_y) 
	{
		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		Point mouse = new Point(mouse_x, mouse_y);
		
		return(rect.contains(mouse));

	} 
	
	public String print() 
	{
		String s = "";
		s += "rectangle " + this.x + " " + this.y + " " + this.width + " " + this.height; 
		return s;
	}
}
