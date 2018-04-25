package test_file1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
class thongtin{
	public String ten;
	public String ngaysinh;
	public String email;
	public String sdt;
	public thongtin() {
	}
	public thongtin(String ten, String ngaysinh, String email, String sdt) {
		this.ten=ten;
		this.ngaysinh=ngaysinh;
		this.email=email;
		this.sdt=sdt;
	}
}
public class test6 extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    Vector<thongtin> list = new Vector<thongtin>();
    FileWriter t ;
    PrintWriter y;
    FileReader w;
    BufferedReader w1;
    String s;
    private JLabel lblNgySinh;
    private JLabel lblEmail;
    private JLabel lblSinThoi;
	public void save(String s,String t,String a,String b) {
		thongtin y = new thongtin(s,t,a,b);
		list.add(y);
	}
	public void them() {
		String data[] = new String[4];
		try {
		w = new FileReader("D:\\t.txt");
		w1 = new BufferedReader(w);
		while((s=w1.readLine())!=null) 
			data = s.split("[&]");
			thongtin tt = new thongtin(data[0],data[1],data[2],data[3]);
		list.add(tt);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void load() {
		them();
		try {
			thongtin[] str = new thongtin[list.size()];
			Enumeration<thongtin> m = list.elements();
			int i=0;
			while(m.hasMoreElements()) {
			str[i] = (thongtin) m.nextElement();
			textField.setText(str[i].ten);
			textField_1.setText(str[i].ngaysinh);
			textField_2.setText(str[i].email);
			textField_3.setText(str[i].sdt);
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	public void email(JTextField textField_2) throws Exception{
		String s = textField_2.getText();
		String kt = "^[\\w-]+@([\\w- ]+\\.)+[\\w-]+$";
		boolean w = s.matches(kt);
		if(w==false) throw new Exception("dia chi email sai");
	}
	public void ngaysinh(JTextField textField_1) throws Exception{
		String s = textField_1.getText();
		String kt = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		boolean w = s.matches(kt);
		if(w==false) throw new Exception("nhap sai ngay sinh");
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test6 window = new test6();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setTitle("bai 2");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	public test6() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 20));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField("");
		textField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField.setBounds(148, 10, 260, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_1.setBounds(148, 50, 260, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("");
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_2.setBounds(148, 99, 260, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("");
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_3.setBounds(148, 152, 260, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		load();
		JButton btnNewButton = new JButton("save");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				ngaysinh(textField_1);
				email(textField_2);
				save(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());	
					t = new FileWriter("D:\\t.txt");
					y = new PrintWriter(t);
				Enumeration<thongtin> venum = list.elements();
				while(venum.hasMoreElements()) {
					thongtin tt = venum.nextElement();
					String s =  tt.ten+"&"+tt.ngaysinh+"&"+tt.email+"&"+tt.sdt;
				    y.println(s);
				    y.flush();
				}
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(62, 208, 85, 30);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTn = new JLabel("t\u00EAn");
		lblTn.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTn.setBounds(10, 10, 93, 30);
		frame.getContentPane().add(lblTn);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnCancel.setBounds(269, 208, 106, 30);
		frame.getContentPane().add(btnCancel);
		
		lblNgySinh = new JLabel("ng\u00E0y sinh");
		lblNgySinh.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNgySinh.setBounds(10, 50, 93, 30);
		frame.getContentPane().add(lblNgySinh);
		
		lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblEmail.setBounds(10, 99, 93, 30);
		frame.getContentPane().add(lblEmail);
		
		lblSinThoi = new JLabel("s\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblSinThoi.setBounds(10, 152, 128, 30);
		frame.getContentPane().add(lblSinThoi);
	}
}
