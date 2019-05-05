package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DepartmentDAOImpl;
import model.Department;
import model.Item;
import service.BussService;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblItemName;
	private JTextArea txtItemName;
	private JLabel lblID;
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JLabel lblDepartment;
	private JTextField txtItemID;
	private JTextField txtItemPrice;
	private JTextField txtItemQuantity;
	private JComboBox<Department> cmbDepartment;
	private InventorySaveEvent listener;
	private JButton btnSaveUpdate;
	private Item itemUpdated;
	private BussService srv;
	private Department updatedDpt;
	
	public UpdateFrame(InventorySaveEvent listener,Object item) {
		this.srv = new BussService();
		this.itemUpdated= (Item) item;
		this.listener = listener;
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblItemName = new JLabel("ITEM NAME");
		lblItemName.setBounds(52, 11, 102, 14);
		contentPane.add(lblItemName);
		
		txtItemName = new JTextArea();
		txtItemName.setBounds(164, 11, 185, 20);
		contentPane.add(txtItemName);
		txtItemName.setColumns(10);
		txtItemName.setText(itemUpdated.getItemname());
		
		lblID = new JLabel("ID");
		lblID.setBounds(52, 57, 102, 14);
		contentPane.add(lblID);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(52, 106, 102, 14);
		contentPane.add(lblPrice);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(52, 158, 102, 14);
		contentPane.add(lblQuantity);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(52, 211, 102, 14);
		contentPane.add(lblDepartment);
		
		txtItemID = new JTextField();
		txtItemID.setBounds(164, 54, 185, 20);
		contentPane.add(txtItemID);
		txtItemID.setColumns(10);
		txtItemID.setText("" +	itemUpdated.getId());
		
		txtItemPrice = new JTextField();
		txtItemPrice.setBounds(164, 103, 185, 20);
		contentPane.add(txtItemPrice);
		txtItemPrice.setColumns(10);
		txtItemPrice.setText("" +(int)itemUpdated.getPrice());
		
		txtItemQuantity = new JTextField();
		txtItemQuantity.setBounds(164, 155, 185, 20);
		contentPane.add(txtItemQuantity);
		txtItemQuantity.setColumns(10);
		txtItemQuantity.setText("" +(int) itemUpdated.getQuantity());
		
		cmbDepartment = new JComboBox<Department>();
		cmbDepartment.setBounds(164, 208, 185, 20);
		contentPane.add(cmbDepartment);
		
		
		List<Department> depts;
		try {
			depts = srv.getAllDepartments();
			DefaultComboBoxModel<Department> cmbModel
			=new DefaultComboBoxModel<>(
					depts.toArray(new Department[depts.size()]));
			DepartmentDAOImpl depImp = new DepartmentDAOImpl();
			cmbDepartment.setModel(cmbModel);
			cmbDepartment.setEditable(rootPaneCheckingEnabled);
			updatedDpt =depImp.findById(itemUpdated.getDepartmentid());
			cmbDepartment.setSelectedItem((Object)updatedDpt);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		btnSaveUpdate = new JButton("Save");
		btnSaveUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSaveUpdate_actionPerformed(arg0);
			}
		});
		btnSaveUpdate.setBounds(335, 259, 89, 23);
		contentPane.add(btnSaveUpdate);
	}
	protected void do_btnSaveUpdate_actionPerformed(ActionEvent arg0) {
		
		try {
			DepartmentDAOImpl depart=new DepartmentDAOImpl();
			int departID =depart.findByName(cmbDepartment.getSelectedItem().toString()).getId();
			
			itemUpdated.setId(Integer.parseInt(txtItemID.getText()));
			itemUpdated.setItemname(txtItemName.getText());
			itemUpdated.setDepartmentid(departID);
			itemUpdated.setPrice(Double.parseDouble(txtItemPrice.getText()));
			itemUpdated.setQuantity(Integer.parseInt(txtItemQuantity.getText()));
			
			srv.updateItem(itemUpdated);
			listener.itemUpdated();
			this.dispose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
