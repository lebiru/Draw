/*
 * Bilal Abdul-Nabi, 2012
 * Dr. Peter Boothe
 * Manhattan College
 * CopyLeft License, Freedom 3
 */

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Main {

	public static void main(String[] args) {

		/**
		 * Here we define the main components of our program.
		 * The program mainly consists of a canvas, frame, a menu, and menu items.
		 */
		
		Frame app = new Frame("Draw!");
		BoardCanvas b = new BoardCanvas();
		app.add(b);
		
		app.addWindowListener(new Closer());
		b.addMouseListener(new Clicky(app,b));
		b.addMouseMotionListener(new ActiveShapeRendering(app, b));
		
		MenuBar bar = new MenuBar();
		
		Menu fileMenu = new Menu("File");
		MenuItem open = new MenuItem("Open");
		MenuItem exit = new MenuItem("Exit");
		MenuItem text_save = new MenuItem("Save as Text");
		MenuItem image_save = new MenuItem("Save Image");
		MenuItem clear = new MenuItem("Clear");

		Menu shapeMenu = new Menu("Shapes");
		MenuItem square = new MenuItem("Square");
		MenuItem circle = new MenuItem("Circle");
		MenuItem rectangle = new MenuItem("Rectangle");
		MenuItem color = new MenuItem("Color");
		MenuItem filledcircle = new MenuItem("Filled Circle");
		MenuItem filledsquare = new MenuItem("Filled Square");
		MenuItem line = new MenuItem("Line");
		MenuItem filledrectangle = new MenuItem("Filled Rectangle");
		MenuItem delete = new MenuItem("Delete");
		
		open.addActionListener(new Opener(app,b));
		exit.addActionListener(new Exiter(app));
		text_save.addActionListener(new Saver(app, b));
		clear.addActionListener(new Clear(app, b));
		image_save.addActionListener(new ImageSaver(app, b));
		
		fileMenu.add(open);
		fileMenu.add(text_save);
		fileMenu.add(image_save);
		fileMenu.add(clear);
		fileMenu.add(exit);
		
		
		
		shapeMenu.add(circle);
		shapeMenu.add(square);
		shapeMenu.add(rectangle);
		shapeMenu.add(color);
		shapeMenu.add(filledcircle);
		shapeMenu.add(filledsquare);
		shapeMenu.add(line);
		shapeMenu.add(filledrectangle);
		shapeMenu.add(delete);
		Clicky c = new Clicky(app, b);
		
		square.addActionListener(new ShapeButtonListener(app, b, square, c));
		circle.addActionListener(new ShapeButtonListener(app, b, circle, c));
		rectangle.addActionListener(new ShapeButtonListener(app, b, rectangle, c));
		color.addActionListener(new ShapeButtonListener(app, b, color, c));
		filledcircle.addActionListener(new ShapeButtonListener(app, b, filledcircle, c));
		filledsquare.addActionListener(new ShapeButtonListener(app, b, filledsquare, c));
		line.addActionListener(new ShapeButtonListener(app, b, line, c));
		filledrectangle.addActionListener(new ShapeButtonListener(app, b, filledrectangle, c));
		delete.addActionListener(new ShapeButtonListener(app, b, delete, c));
		
		bar.add(fileMenu);
		bar.add(shapeMenu);
		app.setMenuBar(bar);
		
	
		app.pack();
		app.setVisible(true);
		
	}

}
