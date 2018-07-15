package first.one;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Page1 extends JFrame {
	//设置两个面板
	JPanel panelnorth=new JPanel(new BorderLayout());
	JPanel panelsouth=new JPanel(new FlowLayout());
	JPanel panelcenter=new JPanel();
	JPanel paneladd=new JPanel();
	JPanel panelMain = new JPanel();
	
	JTextField serach1=new JTextField();
	JButton search=new JButton("搜索");
	
	JTextArea content=new JTextArea("oejeo jfoe ");
	
	JButton savein=new JButton("保存");
	JButton add=new JButton("添加");
	JButton del=new JButton("删除");
	JLabel lable=new JLabel("姓名");
	
	
	
	Page1(){
		
		
		panelMain.setLayout(new BorderLayout());
		//加入到面板
		
	
	
		paneladd.add(lable);
		
		panelcenter.add(content);
		
		panelsouth.add(savein);
		panelsouth.add(add);
		panelsouth.add(del);
		
		panelnorth.add(serach1,BorderLayout.CENTER);
		panelnorth.add(search,BorderLayout.EAST);
		
		
		
		this.setContentPane(panelMain);
		
		//加入到顶级容器
		
		this.setBounds(500, 100,700,800);
		this.setTitle("密码管理");
		panelMain.add(panelnorth,BorderLayout.NORTH);
		panelMain.add(panelsouth,BorderLayout.SOUTH);
		panelMain.add(paneladd,BorderLayout.CENTER);
		paneladd.setVisible(false);
		panelMain.add(panelcenter,BorderLayout.CENTER);
		
		
		//
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//content.setText(serach1.getText());
				//content.setForeground(Color.BLUE);
				
				Page1.this.panelMain.remove(panelcenter);
				Page1.this.panelMain.add(paneladd);//,BorderLayout.CENTER);
				paneladd.setVisible(true);
				
				
			
			}
			
		});
		savein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent c) {
				// TODO Auto-generated method stub
				String nametest=savein.getText();
				if(nametest.equals("保存"))
				{
					Page1.this.panelMain.setVisible(false);
					Page1.this.panelMain.setVisible(true);
					Page1.this.panelMain.remove(panelcenter);
					Page1.this.panelMain.add(paneladd);
					paneladd.setVisible(true);
					add.setText("cancel");
				    del.setVisible(false);
				    
					savein.setText("提交");
					/*if(savein.getText().equals("提交"))
					{	Page1.this.panelMain.remove(panelcenter);
						Page1.this.panelMain.add(paneladd);
						paneladd.setVisible(true);
						savein.setText("保存");
						//JOptionPane.showMessageDialog(null,"保存成功","系统消息",JOptionPane.PLAIN_MESSAGE);
						//add.setText("cancel");
					    //del.setVisible(false);
					}*/
				}
				else
				{
					Page1.this.panelMain.setVisible(false);
					Page1.this.panelMain.setVisible(true);
					Page1.this.panelMain.remove(paneladd);
					Page1.this.panelMain.add(panelcenter);
					panelcenter.setVisible(true);
					savein.setText("保存");
					add.setText("添加");
					del.setVisible(true);
				}
				
			
				
				/*String savetest=savein.getText();
				if(savetest.equals("提交"))
				{
				*	Page1.this.panelMain.remove(paneladd);
					Page1.this.panelMain.add(panelcenter);
					panelcenter.setVisible(true);
					
					JOptionPane.showMessageDialog(null,"保存成功","系统消息",JOptionPane.PLAIN_MESSAGE);
					
					
				}*/
			}
			
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Page1();

	}

}
