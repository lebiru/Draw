import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

public class FilledCircle extends Drawable {

	/*
	 * Here is where the object filled circle is defined.
	 * A filled circle is a Drawable object, thus it inherits the method draw(Graphics g)
	 * An object filled circle is comprised of an x and y position, and the radius. 
	 * These points define where the filled circle will be drawn on the canvas.
	 */

	private int x,y,radius;

	public FilledCircle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void draw(Graphics g)
	{
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}


	/*
	 * For FilledCircle and Circle's implementation of the contains method, we make an instance
	 * of a circle with the same variable values of the specified shape's instance. We then 
	 * utilize an Ellipse2D method called contain where we see if the mouse's x and y coordinates
	 * intersected with the circle. It then returns the boolean value of the check.
	 */
	public boolean contains(int mouse_x, int mouse_y) 
	{
		Ellipse2D circle = new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2);
		double mouse_x_ = (double)mouse_x;
		double mouse_y_ = (double)mouse_y;

		return (circle.contains(mouse_x_, mouse_y_));

	}

	public String print() {
		String s = "";

		s += "filledcircle " + this.x + " " + this.y + " " + this.radius; 

		return s;
	}

}

