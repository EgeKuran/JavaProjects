package DBConnection;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
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
		txtUser.setBounds(149, 26, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(149, 87, 86, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLogin_actionPerformed(arg0);
			}
		});
		btnLogin.setBounds(146, 148, 89, 23);
		contentPane.add(btnLogin);
		
		lblResult = new JLabel("New label");
		lblResult.setBounds(172, 204, 46, 14);
		contentPane.add(lblResult);
	}
	protected void do_btnLogin_actionPerformed(ActionEvent arg0) {
		
		try(Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost/addressbook?useSSL=false", "root", "123456");){
//			Statement stmt = conn.createStatement();
			String query = "Select count(*)as cnt from user u where" + "u.username=? and u.password=?";
			PreparedStatement psmt = (PreparedStatement) conn.prepareStatement(query);
			psmt.setString(1, txtUser.getText());
			psmt.setString(1, txtPass.getText());
			ResultSet rs = psmt.executeQuery(query);
			rs.next();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	
	}
}
