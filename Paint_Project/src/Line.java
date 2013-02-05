import java.awt.Graphics;
import java.awt.geom.Line2D;

public class Line extends Drawable {

	/**
	 * Here is where the object line is defined.
	 * Line is a Drawable object, thus it inherits the method draw(Graphics g)
	 * An object Line is comprised of an x,y and x_2, y_2. These points define where
	 * The line will be drawn on the canvas.
	 */

	private int x, y, x_2, y_2;

	public Line(int x, int y, int x_2, int y_2)
	{
		this.x = x;
		this.y = y;
		this.x_2 = x_2;
		this.y_2 = y_2;
	}

	public void draw(Graphics g) 
	{
		g.drawLine(x, y, x_2, y_2);
	}

	/*
	 * Make an instance of the specified Line using the Line2D library.
	 * We test if the mouse has "contacted" the line by measuring how far
	 * the mouse point is from the line when the mouse is clicked. 
	 * 
	 * The variable threshold is how close the mouse point has to be in order
	 * for the mouse to be considered contacting the line.
	 */
	public boolean contains(int mouse_x, int mouse_y) 
	{

		double threshold = 2;
		double class_x = (double)x;
		double class_y = (double)y;
		double class_x_2 = (double)x_2;
		double class_y_2 = (double)y_2;

		Line2D this_l = new Line2D.Double(class_x, class_y, class_x_2, class_y_2);

		double mouse_x_ = (double)mouse_x;
		double mouse_y_ = (double)mouse_y;

		return(this_l.ptLineDist(mouse_x_, mouse_y_) < threshold); 
	}

	public String print() 
	{
		String s = "";

		s += "line " + this.x + " " + this.y + " " + this.x_2 + " " + this.y_2; 

		return s;
	}


}
