import java.awt.Color;
import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

/**
 * This class handles what the user's desired shape is whenever he clicks a shape.
 * 
 * The mousetype is changed to the desired shape, and the last shape that the user
 * specified is added to the arraylist last_mouse_type.
 * @author Bilal
 *
 */

public class ShapeButtonListener implements ActionListener {

	BoardCanvas b;
	Frame f;
	MenuItem item;
	Clicky c;
	

	public ShapeButtonListener(Frame app, BoardCanvas b, MenuItem shapeitem, Clicky c) {
		this.b = b;
		f = app;
		item = shapeitem;
		this.c = c; 
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(item.getLabel().equals("Square"))
		{
			b.mousetype = "square";
			b.last_mouse_type.add("square");
			
		}

		else if(item.getLabel().equals("Circle"))
		{
			b.mousetype = "circle";
			b.last_mouse_type.add("circle");
		}

		else if(item.getLabel().equals("Rectangle"))
		{
			b.mousetype = "rectangle";
			b.last_mouse_type.add("rectangle");
		}

		else if(item.getLabel().equals("Color"))
		{
			b.mousetype = "color";
			b.color_chosen = JColorChooser.showDialog(b, "Choose a Color", Color.WHITE);
			
		}

		else if(item.getLabel().equals("Filled Circle"))
		{
			b.mousetype = "filledcircle";
			b.last_mouse_type.add("filledcircle");
		}

		else if(item.getLabel().equals("Filled Square"))
		{
			b.mousetype = "filledsquare";
			b.last_mouse_type.add("filledsquare");
		}

		else if(item.getLabel().equals("Line"))
		{
			b.mousetype = "line";
			b.last_mouse_type.add("line");
		}

		else if(item.getLabel().equals("Filled Rectangle"))
		{
			b.mousetype = "filledrect";
			b.last_mouse_type.add("filledrect");
		}

		else if(item.getLabel().equals("Delete"))
		{
			b.mousetype = "delete";
			b.last_mouse_type.add("delete");
		}
		

	}

}
