import java.awt.Graphics;

public class Drawable {
	
	/*
	 * Public class Drawable is the superclass for all shapes and the class Drawable_Color
	 * The only method described is draw, which allows all subclasses to inherit this method easily
	 */

	public void draw(Graphics g)
	{
		
	}

	/*
	 * The contains method is utilized in the BoardCanvas shape_deleter method, which tests if the 
	 * mouse click has intersected the specified shape. Every class tests this by making an instance
	 * of the shape and seeing if the mouse has intersected the shape.
	 */
	public boolean contains(int mouse_x, int mouse_y) {
		
		return false;
	}

	/*
	 * For all subclasses under Drawable, we define a print() method, which simply appends to a string the shape's class variables.
	 * The print method is utilized in the Saver class where we print all of the drawable objects to the text file. 
	 */
	public String print() {
		String s = "";
		
		return s;
	}

}

