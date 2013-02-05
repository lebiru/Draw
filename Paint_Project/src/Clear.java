import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Simple class which is called when File/Clear is clicked.
 * 
 * Clears the Canvas.
 * @author Bilal
 *
 */

public class Clear implements ActionListener {

	BoardCanvas b;
	Frame app;
	
	public Clear(Frame app, BoardCanvas b)
	{
		this.b = b;
		this.app = app;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.drawable_object.clear();
		b.curr_shape.clear();
		
		b.mousetype = "circle";
		b.drawable_object.add(new Color_Drawable(b.color_chosen.getRed(), b.color_chosen.getGreen(), b.color_chosen.getBlue()));
		
		b.repaint();

	}

}
