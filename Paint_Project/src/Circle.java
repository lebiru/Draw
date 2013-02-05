import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

class Circle extends Drawable{

	/*
	 * The only special property of Circle_class is that the width and
	 * height of the circle are each the radius times 2. This is simply
	 * the property of circles.
	 */
	
	private int x, y, radius;

	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void draw(Graphics g)
	{
		g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	/*
	 * Same contains implementation as FilledCircle
	 */
	public boolean contains(int mouse_x, int mouse_y) 
	{
		Ellipse2D circle = new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2);
		double mouse_x_ = (double)mouse_x;
		double mouse_y_ = (double)mouse_y;
		
		return(circle.contains(mouse_x_, mouse_y_));
	}
	
	public String print() {
		String s = "";
		
		s += "circle " + this.x + " " + this.y + " " + this.radius; 
		
		return s;
	}

}
