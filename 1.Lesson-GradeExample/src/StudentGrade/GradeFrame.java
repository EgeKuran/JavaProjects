package StudentGrade;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class GradeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblGrade;
	private JTextField txtName;
	private JTextField txtGrade;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	JList<Grade> gradeList = new JList<>();
	private List<Grade> grades = new ArrayList<>();
	private JButton btnLoad;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeFrame frame = new GradeFrame();
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
	public GradeFrame() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setBounds(10, 58, 46, 14);
		contentPane.add(lblGrade);
		
		txtName = new JTextField();
		txtName.setBounds(116, 8, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(116, 55, 86, 20);
		contentPane.add(txtGrade);
		txtGrade.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(116, 123, 89, 23);
		contentPane.add(btnAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 158, 257, 76);
		contentPane.add(scrollPane);
		
		gradeList = new JList<Grade>();
		scrollPane.setViewportView(gradeList);
		
		btnLoad = new JButton("Load");
		btnLoad.setBounds(17, 123, 89, 23);
		contentPane.add(btnLoad);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSave_actionPerformed(e);
			}
		});
		btnSave.setBounds(222, 123, 89, 23);
		contentPane.add(btnSave);
	}
	
	private void saveData() 
	{
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(new File("data.dat")));){
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadData() 
	{
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("data.dat"));
			
			
				grades =( ArrayList<Grade>) reader.readObject();
				Grade[] gradeArr = new Grade[grades.size()];

			DefaultComboBoxModel<Grade>mdl = new DefaultComboBoxModel<>(grades.toArray(gradeArr));	
			gradeList.setModel(mdl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		Grade grd = new Grade(txtName.getText(), txtGrade.getText());
		grades.add(grd);
		
		DefaultComboBoxModel<Grade>mdl = new DefaultComboBoxModel<>();		
	}
	protected void do_btnSave_actionPerformed(ActionEvent e) {
	}
}
