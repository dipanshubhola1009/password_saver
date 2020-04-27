
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.*;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class password extends JFrame {
    
	//password setting
	public String defaultpass = "bhola" ;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField username;
	private JTextField textField;
	private JLabel lblWebsite;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JLabel showpassword;
	private JTextField enterpassword;
	private JButton submit;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
       
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					password frame = new password();
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
	public void setnew(String w,String u , String p) throws IOException {
		 File path = new File("pass.txt");	
		 FileWriter fr = new FileWriter(path, true);
		 BufferedWriter br = new BufferedWriter(fr);
		 PrintWriter pr = new PrintWriter(br);
		 pr.println(w);
		 pr.println(u);
		 pr.println(p);
		 pr.println();
		 pr.close();
		 br.close();
		 fr.close();
	}
	public String Ency(String w) {
		String given=w;
		String converted= "";
		for(int i=0;i<given.length();i++)
		{   int x= given.charAt(i);
		    x-=128;
		    char a =(char)x;
		    converted+=a;
		}
	    return converted;
	}
	public String Dncy(String w) {
		String given=w;
		String converted= "";
		for(int i=0;i<given.length();i++)
		{   int x= given.charAt(i);
		    x+=128;
		    char a =(char)x;
		    converted+=a;
		}
	    return converted;
		
	}
	public password() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dipan\\Desktop\\logo.png"));
		setTitle("Password saver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 585);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("PASSWORD SAVER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setPreferredSize(new Dimension(90, 50));
		lblNewLabel.setToolTipText("Size =34\r\n");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 496, 44);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(34, 205, 453, 44);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(34, 183, 148, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(34, 273, 148, 22);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setVisible(true);
		textField.setColumns(10);
		textField.setBounds(34, 295, 453, 44);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newweb = Ency(textField_1.getText());
				String newuser = Ency(username.getText());
				String newpass = Ency(textField.getText());
				try {
					setnew(newweb,newuser,newpass);
					username.setText("");
					textField.setText("");
					textField_1.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(117, 371, 273, 44);
		contentPane.add(btnNewButton);
		
		lblWebsite = new JLabel("website");
		lblWebsite.setVisible(true);
		lblWebsite.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWebsite.setBounds(34, 97, 148, 22);
		contentPane.add(lblWebsite);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(34, 117, 453, 44);
		contentPane.add(textField_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(33, 259, 454, 254);
		contentPane.add(scrollPane);
		
		
		JTextArea outputstream = new JTextArea();
		scrollPane.setViewportView(outputstream);
		outputstream.setTabSize(20);
		outputstream.setWrapStyleWord(true);
		outputstream.setDragEnabled(true);
		outputstream.setAutoscrolls(false);
		outputstream.setFont(new Font("Tahoma", Font.PLAIN, 24));
		outputstream.setVisible(false);
	
		
		btnNewButton_1 = new JButton("Show Passwords");
		btnNewButton_1.setHideActionText(true);
		btnNewButton_1.setInheritsPopupMenu(true);
		btnNewButton_1.setIgnoreRepaint(true);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setVisible(false);
				username.setVisible(false);
				lblPassword.setVisible(false);
				lblNewLabel_1.setVisible(false);
				textField.setVisible(false);
				lblWebsite.setVisible(false);
				btnNewButton.setVisible(false);
				
				
				showpassword.setVisible(true);
				enterpassword.setVisible(true);
				submit.setVisible(true);
				outputstream.setVisible(true);
				scrollPane.setVisible(true);
				
				
				
				
				btnNewButton_1.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(34, 453, 453, 49);
		contentPane.add(btnNewButton_1);
		
		showpassword = new JLabel("Enter Password");
		showpassword.setVisible(false);
		showpassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		showpassword.setBounds(34, 97, 148, 22);
		contentPane.add(showpassword);
		
		enterpassword = new JTextField();
		enterpassword.setColumns(10);
		enterpassword.setVisible(false);
		enterpassword.setBounds(34, 117, 453, 44);
		contentPane.add(enterpassword);
		

		
		
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(defaultpass.compareTo(enterpassword.getText())==0) {
					String line= null;
					outputstream.setText("");
					try {
					File path = new File("pass.txt");
					FileReader pathread = new FileReader(path);
					BufferedReader read = new BufferedReader(pathread);
					while((line = read.readLine()) != null) {
				    outputstream.setText(outputstream.getText()+Dncy(line)+"\n");
					
					}
					}
					catch(Exception a) {}
					}
				
				else {
					outputstream.setText("Wrong password");
			}
				
		}
		});
		submit.setVisible(false);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		submit.setBounds(117, 198, 273, 44);
		contentPane.add(submit);
		
		
		
		
		
		
		
		
		
	}
}
