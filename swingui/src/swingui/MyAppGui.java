package swingui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyAppGui implements ActionListener{

	private Logger log = Logger.getLogger(MyAppGui.class.getName());
	private JFrame frame = null;
	private JPanel mainPanel= null;
	private JButton btn0 = null;
	private JButton btn1 = null;
	private CellAutoCanvas caCanvas = null;

	public MyAppGui() {
		log.info("App Started");
		initGUI();
	}

	private void initGUI(){
		frame = new JFrame();
		frame.setTitle("MyAppGui");
		frame.setSize(400, 300);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(),BorderLayout.NORTH);
		frame.setVisible(true);
		
		caCanvas = new CellAutoCanvas();
		frame.add(caCanvas,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public JPanel getMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		btn0 = new JButton("Start");
		btn0.addActionListener(this);
		mainPanel.add(btn0);
		
		btn1 = new JButton("Stop");
		btn1.addActionListener(this);
		mainPanel.add(btn1);
		
		return mainPanel;
	}
	public static void main(String[] args) {
		MyAppGui myApp = new MyAppGui();
		System.out.println("We're done - program exiting");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		log.info("We received an action event" + arg0);
		
	}

}
