package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Vector;
import java.awt.event.ActionEvent;

import DAO.ConnectionManager;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblServer;
	private JTextField txtServer;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPass;
	private JPasswordField txtPass;
	private JButton btnTables;
	private JButton btnRun;
	private JButton btnConnect;
	private JComboBox<Object> comboBoxDb;
	private JSplitPane splitPane;
	private JScrollPane scrollPaneTableArea;
	private JScrollPane scrollPaneQueryArea;
	private JTextArea textArea;
	private JTable table;
	private JPanel panelFilter;
	private JTextField txtFilter;
	private JButton btnFilter;
	private ResultSetMetaData metaData;
	private ResultSet data;
	private Connection conn = null;
	private DatabaseMetaData dbmd =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBounds(5, 5, 1000, 30);

		contentPane.add(panel, BorderLayout.NORTH);

		lblServer = new JLabel("Server:  ");
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setFont(new Font("Times New Roman", Font.BOLD, 13));

		txtServer = new JTextField();
		txtServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setLabelFor(txtServer);
		txtServer.setPreferredSize(new Dimension(200, 25));
		txtServer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtServer.setColumns(10);

		lblUser = new JLabel("User:  ");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 13));

		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setLabelFor(txtUser);
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtUser.setColumns(10);
		txtUser.setPreferredSize(new Dimension(200, 25));

		lblPass = new JLabel("Password:  ");
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 13));

		txtPass = new JPasswordField();
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setLabelFor(txtPass);
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtPass.setEchoChar('*');
		txtPass.setColumns(10);
		txtPass.setPreferredSize(new Dimension(200, 25));

		btnTables = new JButton("Tables");
		btnTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnTables_actionPerformed(arg0);
			}
		});
		btnTables.setHorizontalAlignment(SwingConstants.LEFT);
		btnTables.setFont(new Font("Times New Roman", Font.BOLD, 13));

		btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnRun_actionPerformed(arg0);
			}
		});
		btnRun.setHorizontalAlignment(SwingConstants.LEFT);
		btnRun.setFont(new Font("Times New Roman", Font.BOLD, 13));

		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnConnect_actionPerformed(arg0);
			}
		});

		comboBoxDb = new JComboBox<Object>();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(lblServer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConnect, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBoxDb, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTables, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRun, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(229))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(txtServer, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblServer))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUser)
								.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPass)
								.addComponent(comboBoxDb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRun)
								.addComponent(btnTables, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConnect))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		splitPane = new JSplitPane();
		splitPane.setBackground(new Color(240, 240, 240));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);

		scrollPaneTableArea = new JScrollPane();
		scrollPaneTableArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		splitPane.setRightComponent(scrollPaneTableArea);
		
		table = new JTable();
		scrollPaneTableArea.setViewportView(table);

		scrollPaneQueryArea = new JScrollPane();
		splitPane.setLeftComponent(scrollPaneQueryArea);

		textArea = new JTextArea();
		scrollPaneQueryArea.setViewportView(textArea);
		
		panelFilter = new JPanel();
		contentPane.add(panelFilter, BorderLayout.SOUTH);
		
		txtFilter = new JTextField();
		panelFilter.add(txtFilter);
		txtFilter.setColumns(10);
		
		btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFilter_actionPerformed(arg0);
			}
		});
		panelFilter.add(btnFilter);
	}

	protected void do_btnConnect_actionPerformed(ActionEvent arg0) {

		String pass = new String(txtPass.getPassword());
		if (btnConnect.getText() == "Disconnect") {
			// Disconnect
			try {
				conn.close();
				
				btnConnect.setText("Connect");
				JOptionPane.showMessageDialog(null, "Disconnected");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Could not disconnect");
				e.printStackTrace();
			}

		}
		else if(btnConnect.getText() == "Connect") {
			
			// Connect--
			
			try {
				if(txtServer.getText().trim().isEmpty() &&txtUser.getText().trim().isEmpty()&& pass.isEmpty())
				{
					throw new IllegalArgumentException();
				}
				conn = (Connection) ConnectionManager.getConnection(txtServer.getText(), txtUser.getText(), pass);
			
				btnConnect.setText("Disconnect");

				// get db names
				
				 dbmd = conn.getMetaData();
				 
				ResultSet ctlgs = dbmd.getCatalogs();
				 
				while (ctlgs.next())
				{
					comboBoxDb.addItem(ctlgs.getString(1));
				    
				}
				
				}catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null,"Please provide required info to connect");}
			catch (SQLException e) {		
				
				JOptionPane.showMessageDialog(null, "Credentials are wrong");
				
				e.printStackTrace();
				
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			
		}
			//*--Connect
			
		
			
		}

	
	protected void do_btnTables_actionPerformed(ActionEvent arg0) {
		
		try {
			String[] types = { "TABLE" };
			ResultSet tables = dbmd.getTables(comboBoxDb.getSelectedItem().toString(), null, "%", types);
			  String tableName = "";
		     while (tables.next()) {
		       tableName = tables.getString(3);
		       textArea.append("Select * from " +tableName +"; \n");
		       	
		     }
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void do_btnRun_actionPerformed(ActionEvent arg0) {
		String query = textArea.getSelectedText(); 
//		System.out.println(query);
		String dbquery= "use " + comboBoxDb.getSelectedItem().toString() + " ;";
		
		try {
			PreparedStatement pmt = conn.prepareStatement(dbquery);
			pmt.executeQuery();
			PreparedStatement psmt = conn.prepareStatement(query);
			if(psmt.execute(query))
			{
			data=psmt.executeQuery();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Affected rows: " + psmt.getUpdateCount());
			}
			 metaData = data.getMetaData();
			
			Vector<String> columnNames = new Vector<>();
			int columnCount= metaData.getColumnCount();
			for(int column=1;column<=columnCount;column++) 
			{
				columnNames.add(metaData.getColumnName(column));
			}
			
			Vector<Vector<Object>> rowData= new Vector<Vector<Object>>();
			while(data.next()) 
			{
				Vector<Object> vector = new Vector<>();
				for(int columnIndex=1;columnIndex<=columnCount;columnIndex++) 
				{
					vector.add(data.getObject(columnIndex));
				}
				rowData.add(vector);
			}
			table.setModel(new DefaultTableModel(rowData,columnNames));
			table.setAutoCreateRowSorter(true);

			
		
		}catch (SQLSyntaxErrorException e1) {
			JOptionPane.showMessageDialog(null, ("There is a problem with your query"));
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	protected void do_btnFilter_actionPerformed(ActionEvent arg0) {
		 TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel())); 
		    sorter.setRowFilter(RowFilter.regexFilter("(?i)" +txtFilter.getText()));

		   table.setRowSorter(sorter);
		
		
	}
}
