package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Department;
import model.Item;
import service.BussService;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class InventoryFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JComboBox comboBox;
	private BussService srv;
	private JButton btnGetInventory;
	private JScrollPane scrollPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryFrame frame = new InventoryFrame();
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
	public InventoryFrame() {
		srv = new BussService();
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
		
		comboBox = new JComboBox();
		panel.add(comboBox);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 404, 196);
		panel_1.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		List<Department> dept;
		try {
			dept = srv.getAllDepartments();
			DefaultComboBoxModel<Department> cmbModel = new DefaultComboBoxModel<>(dept.toArray(new Department[dept.size()]));
			comboBox.setModel(cmbModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		btnGetInventory = new JButton("Get Inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGetInventory_actionPerformed(arg0);
			}
		});
		panel.add(btnGetInventory);
	}

	protected void do_btnGetInventory_actionPerformed(ActionEvent arg0) {
		
		List<Item> items = srv.getItemsByDeptId((Department)comboBox.getSelectedItem());
		
	}
}
