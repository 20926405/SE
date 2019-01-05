package seProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class use implements ActionListener{

	public JFrame frame;
	JTextField txtSjob = new JTextField();
	JTextField txtjobName = new JTextField();;
	JTextField txtsalary = new JTextField();;
	JTextField txtphone = new JTextField();;
	JButton btnAdd = new JButton("Add Job");
	JButton btnSearch = new JButton("Search");
	JButton btnLogout = new JButton("Logout");
	String[][] arrJ=new String[3][500];
	ArrayList<String[]>jobsearch = new <String[]>ArrayList();
	int i=0;
	int k=0;
	StringBuffer sbf=new StringBuffer();
	JTextArea textAreaOut = new JTextArea();
	login l=new login();
	
	public use() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearch = new JLabel("Job Name");
		lblSearch.setBounds(10, 39, 93, 15);
		frame.getContentPane().add(lblSearch);
		
		txtSjob.setBounds(113, 36, 149, 21);
		frame.getContentPane().add(txtSjob);
		txtSjob.setColumns(10);
		
		btnSearch.addActionListener(this) ;
		btnSearch.setBounds(272, 35, 87, 23);
		frame.getContentPane().add(btnSearch);
		
		txtjobName.setBounds(496, 68, 151, 21);
		frame.getContentPane().add(txtjobName);
		txtjobName.setColumns(10);
		
		txtsalary.setBounds(496, 110, 151, 21);
		frame.getContentPane().add(txtsalary);
		txtsalary.setColumns(10);
		
		txtphone.setBounds(496, 154, 151, 21);
		frame.getContentPane().add(txtphone);
		txtphone.setColumns(10);
		
		JLabel lblJobName = new JLabel("Job Name");
		lblJobName.setBounds(399, 71, 87, 15);
		frame.getContentPane().add(lblJobName);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(399, 113, 87, 15);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(399, 157, 87, 15);
		frame.getContentPane().add(lblPhone);
		
		btnAdd.addActionListener(this) ;
		btnAdd.setBounds(496, 199, 87, 23);
		frame.getContentPane().add(btnAdd);
		
		textAreaOut.setBounds(10, 232, 649, 319);
		frame.getContentPane().add(textAreaOut);
		
		btnLogout.setBounds(496, 35, 87, 23);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(this) ;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o=arg0.getSource();
		if(o==btnAdd) {
			write wr = new write();
			try {
				wr.write(txtjobName.getText(),txtsalary.getText(),txtphone.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(o==btnSearch) {
			jobsearch.clear();
			try {
				FileReader fr = new FileReader("test.txt");
				BufferedReader job = new BufferedReader(fr);
				jobsearch.add(job.readLine().split(" "));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(jobsearch.get(0).length);
			for(int q = 0 ; q < jobsearch.get(0).length-2; q+=3) {
				arrJ[0][i]=jobsearch.get(0)[q];
				arrJ[1][i]=jobsearch.get(0)[q+1];
				arrJ[2][i]=jobsearch.get(0)[q+2];
				i++;
			}
			String tmp=txtSjob.getText().toUpperCase();
			for(int j=0;j<i;j++) {
				if(arrJ[0][j].toUpperCase().matches("(.*)"+tmp+"(.*)")||arrJ[0][j].toUpperCase().matches("(.*)"+tmp)||arrJ[0][j].toUpperCase().matches(tmp+"(.*)")) {
					sbf.append("Job Name: "+arrJ[0][j]+"   Salary: "+arrJ[1][j]+"   Phone: "+arrJ[2][j]);
					sbf.append("\r\n");
				}
			}
			i=0;
		}
		textAreaOut.setText(sbf.toString());
		sbf.delete(0, sbf.length());
		if(o==btnLogout) {
			frame.setVisible(false);;
		}
	}
}
