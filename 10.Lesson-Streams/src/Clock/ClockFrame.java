package Clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ClockFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblHour;
	private JLabel lblMin;
	private JLabel lblSec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockFrame frame = new ClockFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClockFrame() {
		initGUI();
		
		Thread timeThread = new Thread(()->{
			while(true) {
				
			
			LocalDateTime now = LocalDateTime.now();
			
			lblHour.setText(String.valueOf(now.getHour()));
			lblMin.setText(String.valueOf(now.getMinute()));
			lblSec.setText(String.valueOf(now.getSecond()));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		
		timeThread.start();
		
		
		
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHour = new JLabel("00");
		lblHour.setBounds(83, 109, 46, 14);
		contentPane.add(lblHour);
		
		lblMin = new JLabel("00");
		lblMin.setBounds(170, 109, 46, 14);
		contentPane.add(lblMin);
		
		lblSec = new JLabel("00");
		lblSec.setBounds(267, 109, 46, 14);
		contentPane.add(lblSec);
	}
}
