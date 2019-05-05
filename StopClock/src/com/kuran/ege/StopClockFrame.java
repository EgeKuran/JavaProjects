package com.kuran.ege;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StopClockFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblHour;
	private JLabel lblMin;
	private JLabel lblSec;
	private JLabel lblMsec;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnReset;
	private Thread timeThread;
	private int mSecCounter=0;
	private int secCounter=0;
	private int minCounter=0;
	private int hourCounter=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StopClockFrame frame = new StopClockFrame();
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
	public StopClockFrame() {
		initGUI();
		
		
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblHour = new JLabel("00");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMin = new JLabel("00");
		
		lblSec = new JLabel("00");
		
		lblMsec = new JLabel("00");
		
		btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnStart_actionPerformed(arg0);
			}
		});
		
		btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnStop_actionPerformed(e);
			}
		});
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHour, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(lblMin, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSec, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblMsec, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHour, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(54))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMsec, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(lblSec, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(lblMin, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
							.addGap(126))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void do_btnStart_actionPerformed(ActionEvent arg0) {
		
		timeThread= new Thread(()->
		{
			while(true) 
			{
				mSecCounter++;
				if(mSecCounter==1000) 
				{
					secCounter++;
					mSecCounter=0;
				}
				if(secCounter==60) 
				{
					minCounter++;
					secCounter=0;
				}
				if(minCounter==60) 
				{
					hourCounter++;
					minCounter=0;
				}
				
				lblMsec.setText(String.valueOf(mSecCounter));
				lblSec.setText(String.valueOf(secCounter));
				lblMin.setText(String.valueOf(minCounter));
				lblHour.setText(String.valueOf(hourCounter));
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		if(!timeThread.isAlive())
		{timeThread.start();}
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		mSecCounter=0;
		minCounter=0;
		secCounter=0;
		hourCounter=0;
		
		lblHour.setText("00");
		lblMin.setText("00");
		lblSec.setText("00");
		lblMsec.setText("00");
		
	}
	protected void do_btnStop_actionPerformed(ActionEvent e) {
		timeThread.stop();
	}
}
