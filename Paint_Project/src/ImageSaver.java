import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The class that is run when user clicks the "Save Image" button under File.
 * 
 * Still not finished yet...
 * @author Bilal
 *
 */


public class ImageSaver implements ActionListener {

	BoardCanvas b;
	Frame app;

	public ImageSaver(Frame app, BoardCanvas b) {

		this.b = b;
		this.app = app;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
	

			BufferedImage bi = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);;
			Graphics g2 = bi.createGraphics();
			
			g2 = b.getGraphics();
			g2.setColor(Color.WHITE);
			
			FileDialog fd = new FileDialog(app, "Save as Text", 1);


			fd.setVisible(true);

			String file_name = fd.getFile();
			String directory = fd.getDirectory();

			ImageIO.write(bi, "jpg", new File(directory + file_name));


			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
