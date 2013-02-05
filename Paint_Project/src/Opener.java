import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Opener implements ActionListener {

	Frame app;
	BoardCanvas board;
	String text_string;
	String[] line_piece;

	public Opener(Frame app, BoardCanvas b) {

		this.app = app;
		this.board = b;
	}

	public void actionPerformed(ActionEvent arg0) {

		//pop up a file dialog
		FileDialog open = new FileDialog(app);
		open.setVisible(true);
		//get the received file
		String filename = open.getFile();
		String directory = open.getDirectory();

		if(filename != null && directory != null)
		{
			//Clears the object list so that the canvas is cleared up
			board.drawable_object.clear();

			try{
				BufferedReader br = new BufferedReader(new FileReader(directory + filename));
				String line = br.readLine();

				while(line != null) {

					//We split the contents of the line by spaces and examine each piece
					text_string = line;
					line_piece = line.split(" ");

					/*
					 * If the first part of the line is equal to the shape,
					 * Then turn the rest of the pieces into integers and
					 * have those integers as the constructor arguments
					 * for the respective shape.
					 */


					if (line_piece[0].equals("rectangle")) {
						board.drawable_object.add(new Rectangle(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3]),
								Integer.parseInt(line_piece[4])));
					}

					else if (line_piece[0].equals("circle")) {
						board.drawable_object.add(new Circle(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3])));
					}

					else if (line_piece[0].equals("filledrectangle")) {

						board.drawable_object.add(new FilledRectangle(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]), 
								Integer.parseInt(line_piece[3]),
								Integer.parseInt(line_piece[4])));
					}
					else if (line_piece[0].equals("color")) {
						board.drawable_object.add(new Color_Drawable(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3])));
					}
					else if (line_piece[0].equals("square")) {
						board.drawable_object.add(new Square(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3])));
					}
					else if (line_piece[0].equals("filledsquare")) {
						board.drawable_object.add(new FilledSquare(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3])));
					}
					else if (line_piece[0].equals("filledcircle")) {
						board.drawable_object.add(new FilledCircle(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3])));

					}

					else if (line_piece[0].equals("line")) {
						board.drawable_object.add(new Line(
								Integer.parseInt(line_piece[1]),
								Integer.parseInt(line_piece[2]),
								Integer.parseInt(line_piece[3]),
								Integer.parseInt(line_piece[4])));
					}

					board.repaint();
					line = br.readLine();
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {

				e.printStackTrace();

			}
		}
	}
}
