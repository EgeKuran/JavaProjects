package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Department;
import service.BussService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveDepartmentFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblDepartment;
	private JTextField txtDepartment;
	private JButton btnSave;
	private JButton btnCancel;

	private InventorySaveEvent listener;
	
	
	public SaveDepartmentFrame(InventorySaveEvent listener) {
		this.listener = listener;
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(30, 37, 138, 16);
		contentPane.add(lblDepartment);
		
		txtDepartment = new JTextField();
		txtDepartment.setBounds(181, 31, 228, 28);
		contentPane.add(txtDepartment);
		txtDepartment.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSave_actionPerformed(e);
			}
		});
		btnSave.setBounds(292, 85, 117, 29);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setBounds(163, 85, 117, 29);
		contentPane.add(btnCancel);
	}
	protected void do_btnSave_actionPerformed(ActionEvent e) {
		//1) Save Data
		//2) Inform main frame
		
		BussService srv = new BussService();
		Department dept = new Department();
		dept.setDepartmentname(txtDepartment.getText());
		try {
			srv.saveDepartment(dept);
			listener.inventorySaved();
			
			this.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		
		
	
		
		
		
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	
	}
}
