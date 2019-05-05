package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class WordFilter extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordFilter frame = new WordFilter();
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
	public WordFilter() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 24, 245, 132);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(120, 181, 89, 23);
		contentPane.add(btnOk);
	}
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		//File Paths
		Path filePath = Paths.get("C:/Users/MSÝ/Desktop/longtext.txt");
		Path newFilePath = Paths.get("C:/Users/MSÝ/Desktop/newlongtext.txt");
		// read the text from the textArea
					String[] areaText= textArea.getText().split(",");
			      
			       StringBuilder buffer = new StringBuilder();
			    			       
		try(	FileReader reader = new FileReader(filePath.toFile());
				BufferedReader bReader = new BufferedReader(reader);
				FileWriter writer = new FileWriter(newFilePath.toFile());
				BufferedWriter bWriter = new BufferedWriter(writer);
				)
	{	
			String line = "";
			
		while((line =bReader.readLine()) != null) 
		{
			buffer.append(line);
			
		}
		String result = buffer.toString();
		
		for (String fileText:areaText) {
			
			
				result =result.replaceAll("(?i)" + fileText  , "--------");
			
		}
		
		bWriter.append(result + " ");
	
		
	} catch (FileNotFoundException e1) {
		// TODO: handle exception
	}
		catch (IOException e) {
		// TODO: handle exception
	}   
		
	}
}
