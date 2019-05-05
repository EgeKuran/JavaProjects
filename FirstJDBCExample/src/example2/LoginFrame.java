package example2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnLogin;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(146, 6, 134, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(146, 46, 134, 28);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});
		btnLogin.setBounds(163, 86, 117, 29);
		contentPane.add(btnLogin);
		
		lblResult = new JLabel("New label");
		lblResult.setBounds(129, 139, 213, 16);
		contentPane.add(lblResult);
	}
	protected void do_btnLogin_actionPerformed(ActionEvent e) {
		
		try(
			Connection conn =	DriverManager
				.getConnection("jdbc:mysql://localhost/addressbook","root","1234");
				
					
				)

		{
		
		//Code below can be sql injected
		//Statement stmt = conn.createStatement();
			/*
		String query = "select count(*) as cnt from user u where"
				+ "  u.username='" + txtUser.getText() 
				+"' and u.password = '" +txtPass.getText() + "'";
		*/
			
			String query = "select count(*) as cnt from user u where"
					+ "  u.username=? and u.password = ?";	
		PreparedStatement psmt = conn.prepareStatement(query);
		
			psmt.setString(1, txtUser.getText());
			psmt.setString(2, txtPass.getText());
			
			
		ResultSet rs = psmt.executeQuery();
		
		rs.next();
		
		int userCount =  rs.getInt("cnt");
		
		if(userCount>=1) {
			lblResult.setText("User logged in..");
		}else {
			lblResult.setText("Authentication fail!");
		}
		
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}
}
