import java.awt.Graphics;

class Circle_class extends Drawable{

	int x;
	int y;
	int radius;

	public Circle_class(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g)
	{
		g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
	}


}
