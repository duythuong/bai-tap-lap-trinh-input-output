package test_file1;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class test4 {

	private JFrame frame;
	private FileWriter f=null;
	private FileReader fr=null;
	private BufferedReader br=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test4 window = new test4();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setTitle("bai 3");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public test4() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 434, 208);
		frame.getContentPane().add(textArea);
		
		JButton btnSaveAs = new JButton("save as");
		btnSaveAs.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser;
				chooser=new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Save as..");
				if(chooser.showSaveDialog(btnSaveAs)==JFileChooser.APPROVE_OPTION)
				{
					String filename=chooser.getSelectedFile().getAbsolutePath();
					test_bai3(filename);
				}		
			}
			private void test_bai3(String filename) {
				try {
					String st=textArea.getText();
					FileWriter f=new FileWriter(filename);
					f.write(st);
					f.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		btnSaveAs.setBounds(65, 218, 121, 33);
		frame.getContentPane().add(btnSaveAs);
		
		JButton btnOpen = new JButton("open");
		btnOpen.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser;
				chooser=new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("open..");
				if(chooser.showOpenDialog(btnOpen)==JFileChooser.APPROVE_OPTION)
				{
					String filename1=chooser.getSelectedFile().getAbsolutePath();
					test_bai3(filename1);
				}
				
			}

			private void test_bai3(String filename1) {
				try {
					textArea.setText("");
					fr=new FileReader(filename1);
					br=new BufferedReader(fr);
					String s;
					while((s=br.readLine()) !=null)
					{
						textArea.append(s+"\n");
					}
					fr.close();
					
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				// TODO Auto-generated method stu	
			}
		});
		btnOpen.setBounds(235, 218, 89, 33);
		frame.getContentPane().add(btnOpen);
	}
}
