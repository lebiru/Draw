import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class FilledRectangle extends Drawable {

	/*
	 * Same as Rectangle, except the draw method has a fillRect.
	 */
	
	private int x, y, width, height;

	public FilledRectangle(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, width, height);

	}
	
	public boolean contains(int mouse_x, int mouse_y) 
	{

		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		Point mouse = new Point(mouse_x, mouse_y);
		
		return(rect.contains(mouse));
	} 
	
	public String print() {
		String s = "";
		
		s += "filledrectangle " + this.x + " " + this.y + " " + this.width + " " + this.height; 
		
		return s;
	}
	

}
