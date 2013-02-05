import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * This class handles actively drawing the shape while the mouse is being dragged.
 * @author Bilal
 *
 */

public class ActiveShapeRendering implements MouseMotionListener {
	
	Frame f;
	BoardCanvas b; 

	public ActiveShapeRendering(Frame app, BoardCanvas b) {
		f = app;
		this.b = b;

	}


/**
 * Whenever the mouse is being dragged, we add the shape to the
 * drawable arraylist curr_shape, then we update the canvas.
 * 
 * After the shape is drawn, we remove the shape from the list, so
 * only one shape is shown at a time.
 */
	@Override
	public void mouseDragged(MouseEvent m) {
		
		b.mouse_x_2 = m.getX();
		b.mouse_y_2 = m.getY();

        b.draw_curr_shape(); //add to different arraylist when dragging

		b.repaint();
		
		if(b.curr_shape.size() > 1)
		  b.curr_shape.remove(0);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
