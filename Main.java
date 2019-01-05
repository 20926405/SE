package seProject;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login lo = new login();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login lo = new login();
					lo.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
