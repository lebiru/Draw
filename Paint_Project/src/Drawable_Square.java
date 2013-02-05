
import java.awt.Graphics;


public class Drawable_Square extends Drawable {

	int x;
	int y;
	int width;
	int height;

	public Drawable_Square(int x, int y, int width)
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

}
