import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Saver implements ActionListener {


	Frame f;
	BoardCanvas b;

	public Saver(Frame app, BoardCanvas b) {
		this.f = app;
		this.b = b;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {

			String s = "";
			for (Drawable d: b.drawable_object)
			{
				s += d.print() + "\n";
			}

			FileDialog fd = new FileDialog(f, "Save as Text", 1);
			
			fd.setVisible(true);
			
			String file_name = fd.getFile();
			String directory = fd.getDirectory();
			FileWriter fw = new FileWriter( directory + file_name);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s);
			bw.close();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}




}
