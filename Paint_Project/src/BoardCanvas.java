import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * BoardCanvas is the board in which the the user draws on.
 * @author Bilal
 *
 */

@SuppressWarnings("serial")
class BoardCanvas extends Canvas {

	int width = 800;
	int height = 600;

	public int mouse_x_1 = 0;
	public int mouse_y_1 = 0;
	public int mouse_x_2 = 0;
	public int mouse_y_2 = 0;
	Color color_chosen = new Color(0,0,0); //initial color the user draws with is black


	String mousetype = "circle";
	ArrayList<String> last_mouse_type = new ArrayList<String>();


	/*
	 * The arraylist drawable_object holds objects of the subclass Drawable that will be painted
	 * onto the BoardCanvas everytime the paint method is called. 
	 */

	
	/**
	 * drawable_object: the final object that will be drawn on the canvas.
	 * curr_shape: the current shape being rendered by the mouse being dragged.
	 */
	ArrayList<Drawable> drawable_object = new ArrayList<Drawable>();
	ArrayList<Drawable> curr_shape = new ArrayList<Drawable>();
	//public boolean dragging = false;


	public BoardCanvas()
	{
		setSize(width, height);
		this.setBackground(Color.WHITE);
		drawable_object.add(new Color_Drawable(color_chosen.getRed(), color_chosen.getGreen(), color_chosen.getBlue()));
	}

	
	/**
	 * Whenever the paint method is called, we set the screen to white 
	 * and then drawn all shapes in both arraylists.
	 */
	
	public void paint(Graphics g) 
	{

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		for (int i = 0; i < drawable_object.size(); i++) 
		{
			Drawable s = drawable_object.get(i);

			s.draw(g);
		}

		for (int i = 0; i < curr_shape.size(); i++) 
		{
			Drawable s = curr_shape.get(i);

			s.draw(g);

		}
		

	}

	/*
	 * Shape_deleter listens to mouse clicks and will fire once the mouse presses down.
	 * The shape_deleter method will check every object in the array list drawable_object and 
	 * see if the mouse point has intersected with the specified shape. 
	 * 
	 *  My implementation of shape_deleter strikes all shapes that the mouse has intersected,
	 *  ignoring z-index integrity and "spear-heading" all of the shapes. 
	 */
	public void shape_deleter()
	{
		for(int i = 0 ; i < drawable_object.size(); i++)
		{
			Drawable x = drawable_object.get(i);
			if(x.contains(mouse_x_1, mouse_y_1))
			{
				drawable_object.remove(i);			
			}
		}

		for(int i = 0 ; i < curr_shape.size(); i++)
		{
			Drawable x = curr_shape.get(i);
			if(x.contains(mouse_x_1, mouse_y_1))
			{
				curr_shape.remove(i);			
			}
		}


	}


	/*
	 * Modifying the update method to avoid screen flickering.
	 * @see java.awt.Canvas#update(java.awt.Graphics)
	 */
	public void update(Graphics g){

		BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB); 
		Graphics g2 = image.getGraphics();
		paint(g2); // this paints the shapes
		g.drawImage(image, 0, 0, null); 

	}

	
	/*
	 * These two methods, draw_shape and draw_curr_shape are called whenever
	 * the mouse is pushed down, released, and dragged. ActiveShapeRendering utilizes
	 * the draw_curr_shape method, while when the user releases the mouse button
	 * the draw_shape button is fired.  
	 */

	public void draw_shape()
	{
		if(mousetype.equals("rectangle"))
		{
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new Rectangle(mouse_x_1, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new Rectangle(mouse_x_2, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new Rectangle(mouse_x_1, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new Rectangle(mouse_x_2, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	
		}

		else if(mousetype.equals("circle"))
		{
			//if(dragging == false)	
			drawable_object.add(new Circle(mouse_x_1, mouse_y_1, Math.abs(mouse_x_2 - mouse_x_1)));

			//		    else if(dragging == true)
			//		     curr_shape.add(new Circle(mouse_x_1, mouse_y_1, Math.abs(mouse_x_2 - mouse_x_1)));

		}


		else if(mousetype.equals("filledcircle"))
		{
			drawable_object.add(new FilledCircle(mouse_x_1, mouse_y_1, Math.abs(mouse_x_2 - mouse_x_1)));
		}

		else if(mousetype.equals("line"))
		{
			drawable_object.add(new Line(mouse_x_1, mouse_y_1, mouse_x_2, mouse_y_2));
		}

		else if(mousetype.equals("filledrect"))
		{
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new FilledRectangle(mouse_x_1, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new FilledRectangle(mouse_x_2, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new FilledRectangle(mouse_x_1, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new FilledRectangle(mouse_x_2, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

		}

		else if(mousetype.equals("filledsquare"))
		{
			///RIGHT TO BOTTOM
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new FilledSquare(mouse_x_1, mouse_y_1,  Math.abs(mouse_x_2 - mouse_x_1)));	

			//LEFT TO BOTTOM
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new FilledSquare(mouse_x_2, mouse_y_1,  Math.abs(mouse_x_1 - mouse_x_2)));	

			//RIGHT TO TOP
			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new FilledSquare(mouse_x_1, mouse_y_2,  Math.abs(mouse_x_2 - mouse_x_1)));	

			//LEFT TO TOP
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new FilledSquare(mouse_x_2, mouse_y_2,  Math.abs(mouse_y_1 - mouse_y_2)));

		}

		else if(mousetype.equals("square"))
		{
			//RIGHT TO BOTTOM
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new Square(mouse_x_1, mouse_y_1,  Math.abs(mouse_x_2 - mouse_x_1)));	

			//LEFT TO BOTTOM
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				drawable_object.add(new Square(mouse_x_2, mouse_y_1,  Math.abs(mouse_x_1 - mouse_x_2)));	

			//RIGHT TO TOP
			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new Square(mouse_x_1, mouse_y_2,  Math.abs(mouse_x_2 - mouse_x_1)));	

			//LEFT TO TOP
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				drawable_object.add(new Square(mouse_x_2, mouse_y_2,  Math.abs(mouse_y_1 - mouse_y_2)));	
		

		}

		else if (mousetype.equals("delete"))
		{
			shape_deleter();
		}


		else if (mousetype.equals("color"))
		{

			drawable_object.add(new Color_Drawable(color_chosen.getRed(), color_chosen.getGreen(), color_chosen.getBlue()));
			mousetype = last_mouse_type.get(last_mouse_type.size()-1);


		}

		else
		{
			System.out.println("Error: Does not recognize " + mousetype);
		}



	}


	public void draw_curr_shape()
	{
		if(mousetype.equals("rectangle"))
		{
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new Rectangle(mouse_x_1, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new Rectangle(mouse_x_2, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new Rectangle(mouse_x_1, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new Rectangle(mouse_x_2, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1), Math.abs(mouse_y_2 - mouse_y_1)));	
		}

		else if(mousetype.equals("circle"))
		{
			curr_shape.add(new Circle(mouse_x_1, mouse_y_1, Math.abs(mouse_x_2 - mouse_x_1)));    
		}


		else if(mousetype.equals("filledcircle"))
		{
			curr_shape.add(new FilledCircle(mouse_x_1, mouse_y_1, Math.abs(mouse_x_2 - mouse_x_1)));
		}

		else if(mousetype.equals("line"))
		{
			curr_shape.add(new Line(mouse_x_1, mouse_y_1, mouse_x_2, mouse_y_2));
		}

		else if(mousetype.equals("filledrect"))
		{
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new FilledRectangle(mouse_x_1, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new FilledRectangle(mouse_x_2, mouse_y_1,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new FilledRectangle(mouse_x_1, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new FilledRectangle(mouse_x_2, mouse_y_2,  
						Math.abs(mouse_x_2 - mouse_x_1),Math.abs(mouse_y_2 - mouse_y_1)));	

		}

		else if(mousetype.equals("filledsquare"))
		{
			//RIGHT TO BOTTOM
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new FilledSquare(mouse_x_1, mouse_y_1,  Math.abs(mouse_x_2 - mouse_x_1)));	

			//LEFT TO BOTTOM
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new FilledSquare(mouse_x_2, mouse_y_1,  Math.abs(mouse_x_1 - mouse_x_2)));	

			//RIGHT TO TOP
			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new FilledSquare(mouse_x_1, mouse_y_2,  Math.abs(mouse_y_2 - mouse_y_1)));	

			//LEFT TO TOP
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
			{
				curr_shape.add(new FilledSquare(mouse_x_2, mouse_y_2,  Math.abs(mouse_y_1 - mouse_y_2)));	
			}

		}

		else if(mousetype.equals("square"))
		{
			//RIGHT TO BOTTOM
			if(mouse_x_2 > mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new Square(mouse_x_1, mouse_y_1,  Math.abs(mouse_x_2 - mouse_x_1)));	

			//LEFT TO BOTTOM
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 > mouse_y_1)
				curr_shape.add(new Square(mouse_x_2, mouse_y_1,  Math.abs(mouse_x_1 - mouse_x_2)));	

			//RIGHT TO TOP
			else if(mouse_x_2 > mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new Square(mouse_x_1, mouse_y_2,  Math.abs(mouse_y_2 - mouse_y_1)));	

			//LEFT TO TOP
			else if(mouse_x_2 < mouse_x_1 && mouse_y_2 < mouse_y_1)
				curr_shape.add(new Square(mouse_x_2, mouse_y_2,  Math.abs(mouse_y_1 - mouse_y_2)));	
			


		}

		else if (mousetype.equals("delete"))
		{
			shape_deleter();
		}


		else if (mousetype.equals("color"))
		{

			drawable_object.add(new Color_Drawable(color_chosen.getRed(), color_chosen.getGreen(), color_chosen.getBlue()));

			if(last_mouse_type.size() >1)
				mousetype = last_mouse_type.get(last_mouse_type.size()-1);
			else
				mousetype = "circle";

		}

		else
		{
			System.out.println("Error: Does not recognize " + mousetype);
		}



	}



}