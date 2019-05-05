package kuran.ege;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.awt.event.ActionEvent;

public class QueueFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtName;
	private JButton btnAdd;
	private JButton btnRetrieve;
	private JScrollPane scrollPane;
	private JTable tblData;
	private ArrayDeque<Customer> queue = new ArrayDeque<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueFrame frame = new QueueFrame();
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
	public QueueFrame() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtName = new JTextField();
		panel.add(txtName);
		txtName.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAdd_actionPerformed(arg0);
			}
		});
		panel.add(btnAdd);
		
		btnRetrieve = new JButton("RETRIEVE");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRetrieve_actionPerformed(e);
			}
		});
		panel.add(btnRetrieve);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblData = new JTable();
		DefaultTableModel tblModel = new DefaultTableModel(null, new String[] {"QUEUE ID", "NAME", "TIME"});
		tblData.setModel(tblModel);
		scrollPane.setViewportView(tblData);
	}

	protected void do_btnAdd_actionPerformed(ActionEvent arg0) {
		
		String name = txtName.getText();
		Customer cust = new Customer(name, LocalTime.now());
		queue.add(cust);
		refresh();
		txtName.setText("");
	}
	protected void do_btnRetrieve_actionPerformed(ActionEvent e) {
		 
		JOptionPane.showMessageDialog(this, "Current Customer: " +queue.pop().getName());
		refresh();
	}
	private void refresh() 
	{
		
		Object[][] tableData = new Object[queue.size()][];
		Customer[] custArray = queue.toArray(new Customer[queue.size()]);
		
		for (int i = 0; i <	queue.size(); i++) {
			tableData[i] = new Object[] {(i+1),custArray[i].getName(), custArray[i].getQueueEnterTime()};
		}
		DefaultTableModel tblModel = new DefaultTableModel(tableData, new String[] {"QUEUE ID", "NAME", "TIME"});
		tblData.setModel(tblModel);
	}
}
