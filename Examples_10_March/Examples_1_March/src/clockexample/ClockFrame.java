package clockexample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDateTime;

public class ClockFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblHour;
	private JLabel lblmin;
	private JLabel lblsec;

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
			lblmin.setText(String.valueOf(now.getMinute()));
			lblsec.setText(String.valueOf(now.getSecond()));
			
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
		setBounds(100, 100, 333, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHour = new JLabel("00");
		lblHour.setFont(new Font("Courier New", Font.BOLD, 25));
		lblHour.setBounds(74, 54, 30, 21);
		contentPane.add(lblHour);
		
		lblmin = new JLabel("00");
		lblmin.setFont(new Font("Courier New", Font.BOLD, 25));
		lblmin.setBounds(125, 54, 30, 21);
		contentPane.add(lblmin);
		
		lblsec = new JLabel("00");
		lblsec.setFont(new Font("Courier New", Font.BOLD, 25));
		lblsec.setBounds(175, 54, 30, 21);
		contentPane.add(lblsec);
	}
}
