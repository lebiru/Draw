import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exiter implements ActionListener {

	/*
	 * Exiter class added to Main's MenuItem so that
	 * Clicking "Exit" will close the program
	 */
	
	Frame app;
	public Exiter(Frame app) 
	{
		this.app = app;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		System.exit(0);
	}

}
