package first.one;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Page2 {

	Page2(){
		// TODO Auto-generated method stub
		//顶级容器
		JFrame frame=new JFrame("密码管理系统0.0");
		frame.setBounds(500, 100, 700, 800);
		frame.setSize(1000, 800);
		Container contentPane= frame.getContentPane();
		//两个面板
		JPanel panel1=new JPanel(new GridLayout(3,3,10,10));
		panel1.setSize(1000,700);
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setSize(1000,100);
		//标签元素，文本，按钮
		JLabel name=new JLabel("name");
		JLabel passwords=new JLabel("passwords");
		JLabel remake=new JLabel("remake");
		
		JTextArea nametext=new JTextArea();
		JTextArea passwordstext=new JTextArea();
		JTextArea remaketext=new JTextArea();
		
		JButton save=new JButton("save");
		JButton cancel=new JButton("cancel");
		panel1.add(name);
		panel1.add(nametext);
		
		
		panel1.add(passwords);
		panel1.add(passwordstext);
		panel1.add(remake);
		panel1.add(remaketext);
		panel2.add(save);
		save.setBounds(380, 720, 80, 40);
		panel2.add(cancel);
		cancel.setBounds(600, 720, 80, 40);
		contentPane.add(panel1);
		contentPane.add(panel2);
		
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String s=nametext.getText()+",";
				String c=passwordstext.getText()+",";
				String h=remaketext.getText();		
				JOptionPane.showMessageDialog(null,s+c+h,"系统消息",JOptionPane.PLAIN_MESSAGE);
						 	 
			}
            });
			
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Page2 cg=new Page2();
	}


}
