package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Department;
import model.Item;
import service.BussService;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.JobAttributes;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryFrame extends JFrame implements InventorySaveEvent{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JComboBox<Department> comboBox;
	
	private BussService srv;
	private JButton btnGetInventory;
	private JScrollPane scrollPane;
	private JList<Item> list;
	private JButton btnNewDepartment;
	private JButton btnUpdate;
	private Object o;
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
		setBounds(100, 100, 520, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		comboBox = new JComboBox<Department>();
		panel.add(comboBox);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<Item>();
		
		MouseAdapter mouseListener = new MouseAdapter()  {
		      @SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent mouseEvent) {
			        list = (JList<Item>) mouseEvent.getSource();
			        if (mouseEvent.getClickCount() == 1) {
			          int index = list.locationToIndex(mouseEvent.getPoint());
			          if (index >= 0) {
			             o = list.getModel().getElementAt(index);
			            System.out.println("Double-clicked on: " + o.toString());
			          }
			        }
			      }
			    };
			  list.addMouseListener(mouseListener);
		
	
		scrollPane.setViewportView(list);
		
		try {
			List<Department> depts = srv.getAllDepartments();
			DefaultComboBoxModel<Department> cmbModel
			=new DefaultComboBoxModel<>(
					depts.toArray(new Department[depts.size()]));
			
			comboBox.setModel(cmbModel);
			
			btnGetInventory = new JButton("Get Inventory");
			btnGetInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnGetInventory_actionPerformed(e);
				}
			});
			panel.add(btnGetInventory);
			
			btnNewDepartment = new JButton("New Department");
			btnNewDepartment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnNewDepartment_actionPerformed(e);
				}
			});
			panel.add(btnNewDepartment);
			
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_btnUpdate_actionPerformed(arg0);
				}
			});
			panel.add(btnUpdate);
			
		} catch (Exception e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
			
		}
		
		
		
		
		
	}

	protected void do_btnGetInventory_actionPerformed(ActionEvent e) {
		refreshList();
		
	}

	@Override
	public void inventorySaved() {
		
		
		refreshCombobox();
		
	}
	
	public void refreshList() {
		try {
			List<Item> items =
					srv.getItemsByDeptId(((Department)comboBox.getSelectedItem()).getId());
			
			DefaultComboBoxModel<Item> itemMdl 
			= new DefaultComboBoxModel<>(items.toArray(new Item[items.size()]));
			
			list.setModel(itemMdl);
			
			
			
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
	}
	
	public void refreshCombobox() {
		List<Department> depts;
		try {
			depts = srv.getAllDepartments();
			DefaultComboBoxModel<Department> cmbModel
			=new DefaultComboBoxModel<>(
					depts.toArray(new Department[depts.size()]));
			
			comboBox.setModel(cmbModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	protected void do_btnNewDepartment_actionPerformed(ActionEvent e) {
		
		SaveDepartmentFrame frm = new SaveDepartmentFrame(this);
		frm.setVisible(true);
		
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		
		if(o!=null) {
			
		UpdateFrame frmUpdate = new UpdateFrame(this,o);
		frmUpdate.setVisible(true);}
		
		else 
		{
			JOptionPane.showMessageDialog(null, "Make a selection");
		}
	}
	
	@Override
	public void itemUpdated() {
		refreshList();
		refreshCombobox();
		
	}
	
}
