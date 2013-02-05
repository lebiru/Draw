import java.awt.Color;
import java.awt.Graphics;

public class Drawable_Color extends Drawable{

	/*
	 * I've decided to put Drawable_Color as a subclass of Drawable to make sure all
	 * drawable objects are of the same superclass. This will ensure that the superclass
	 * Drawable handles every and all object methods that for objects being drawn on the
	 * canvas.
	 * 
	 * Drawable_Color takes three integer arguments, red, green, and blue respectively,
	 * to create the new color object.
	 */
	
	int red;
	int blue;
	int green;

	public Drawable_Color(int r, int g, int b)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public void draw(Graphics g)
	{
		g.setColor(new Color(red, green, blue));
	}


}
