package seProject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login implements ActionListener {

	JFrame frame;
	
	JTextField acc = new JTextField();
	JButton btnLogin = new JButton("login");
	JButton btnReg = new JButton("register");
	JPasswordField pas = new JPasswordField();
	
	String[][]arr=new String[2][500];
	int count=0;
	boolean ifLog=false;
	JLabel labelLog = new JLabel("");
	String username;
	int useI=0;
	private final JLabel out = new JLabel("");

	public login() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		acc.setBounds(162, 41, 96, 21);
		frame.getContentPane().add(acc);
		acc.setColumns(10);
		
		JLabel lblAccount = new JLabel("Username");
		lblAccount.setBounds(22, 44, 96, 15);
		frame.getContentPane().add(lblAccount);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 104, 96, 15);
		frame.getContentPane().add(lblPassword);
		
		btnLogin.addActionListener(this) ;
		btnLogin.setBounds(309, 100, 87, 23);
		frame.getContentPane().add(btnLogin);
		
		btnReg.addActionListener(this) ;
		btnReg.setBounds(309, 163, 87, 23);
		frame.getContentPane().add(btnReg);
		
		pas = new JPasswordField();
		pas.setBounds(162, 101, 96, 21);
		frame.getContentPane().add(pas);
		labelLog.setBounds(37, 237, 46, 15);
		
		frame.getContentPane().add(labelLog);
		out.setBounds(22, 167, 236, 15);
		
		frame.getContentPane().add(out);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object obj = arg0.getSource();
		if(obj==btnReg) {
			for(int i=0;i<500;i++) {
				if(!acc.getText().equals(arr[0][i])) {
					arr[0][count]=acc.getText();
					arr[1][count]=pas.getText();
					count+=1;
					break ;
				}else
					out.setText("Can't use this username!");
			}
		}
		if(obj==btnLogin) {
			int tmp = 0;
			boolean flag=false; 
			if(arr[0][0]==null) {
				out.setText("Should register an account!");
			}else {
				for(int i=0;i<count;i++) {
					if(arr[0][i].equals(acc.getText())) {
						tmp=i;
						flag=true;
						break;
					}
				}
				if(flag) {
					if(arr[1][tmp].equals(pas.getText())) {
						ifLog=true;
						out.setText("Sucess!");
						if(ifLog==true) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										use u = new use();
										u.frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
					}else
						out.setText("Passworld or username error!");
				}else
					out.setText("Passworld or username error!");
			}
		}
	}
}
