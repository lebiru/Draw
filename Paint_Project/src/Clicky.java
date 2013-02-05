import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The Clicky class; Called whenever the mouse is pressed and released.
 * 
 * Ultimately, it just draws the shapes.
 * @author Bilal
 *
 */



public class Clicky implements MouseListener {

	Frame f;
	BoardCanvas b; 

	public Clicky(Frame app, BoardCanvas b) {
		f = app;
		this.b = b;

	}

	@Override
	public void mouseClicked(MouseEvent m) {


	}

	@Override
	public void mouseEntered(MouseEvent m) {


	}

	@Override
	public void mouseExited(MouseEvent arg0) {


	}

	@Override
	public void mousePressed(MouseEvent m) {

		b.mouse_x_1 = m.getX();
		b.mouse_y_1 = m.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent m) {

		b.mouse_x_2 = m.getX();
		b.mouse_y_2 = m.getY();

		b.draw_shape();

		b.repaint();

	}

}
