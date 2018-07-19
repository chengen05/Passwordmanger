package cj;


import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



@SuppressWarnings("serial")
class Paneladd extends JPanel {
		//标签元素，文本，按钮
		
		static JLabel name=new JLabel("账户");
		static JLabel passwords=new JLabel("密码");
		//static JLabel remake=new JLabel("描述信息");
		//static JTextArea remaketext=new JTextArea();
		static JTextArea nametext=new JTextArea();
		static JTextArea passwordstext=new JTextArea();
		
		Paneladd(){
		this.setLayout(new GridLayout(2,2,10,20)); 
		this.add(name);
		this.add(nametext);
		this.add(passwords);
		this.add(passwordstext);
		//this.add(remake);
		//this.add(remaketext);
		}
		
}