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
    String[] data;
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
	public void load() {	
		try {
		    w = new FileReader("D:\\thuchanh1.txt");
			w1 = new BufferedReader(w);
			while((s=w1.readLine())!=null) {
				data = s.split("[&]");
				thongtin tt = new thongtin(data[0],data[1],data[2],data[3]);
				list.add(tt);
			}
			thongtin[] str = new thongtin[list.size()];
			Enumeration<thongtin> m = list.elements();
			int i=0;
			while(m.hasMoreElements()) {
				str[i] = (thongtin) m.nextElement();
			}
			textField.setText(str[0].ten);
			textField_1.setText(str[0].ngaysinh);
			textField_2.setText(str[0].email);
			textField_3.setText(str[0].sdt);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField.setBounds(148, 10, 260, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_1.setBounds(148, 50, 260, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_2.setBounds(148, 99, 260, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_3.setBounds(148, 152, 260, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		load();
		JButton btnNewButton = new JButton("save");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
				try {
					t = new FileWriter("D:\\thuchanh1.txt");
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
					System.out.println(e.getMessage());
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
