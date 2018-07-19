
package cj;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;



@SuppressWarnings("serial")
public class PanelMain extends JFrame {
	/**
	 * 
	 */
	
	JFrame frame=new JFrame();
	//面板
	JPanel paneltop=new JPanel(new BorderLayout());
	//Practice panelcenterold=new Practice();
	Paneladd panelcenteradd=new Paneladd();
	
	
	private JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	 
	   private JTable table = new JTable();
	//paneladd 加入面板
	JPanel panelbuttom=new JPanel(new FlowLayout());
	JPanel panelmain=new JPanel(new BorderLayout());//将JFrame 设置成JPanel
	//组件区，按钮，文本框
	JButton add=new JButton("添加");
	JButton del=new JButton("删除");
	//面板上面区，文本框，搜索按钮
	JTextField searchspace=new JTextField();
	JButton search=new JButton("保存"); 
	
	Account account = new Account();
	AccountDao accountdao = new AccountDao();
	//SelectRecord selectrecord=new SelectRecord();
	
	PanelMain(){
		panelbuttom.add(add);
		panelbuttom.add(del);
		paneltop.add(searchspace);
		paneltop.add(search,BorderLayout.EAST);
		
		this.setBounds(500, 100,700,800);
		this.setTitle("系统管理1.0");
		this.setContentPane(panelmain);
		
		panelmain.add(paneltop,BorderLayout.NORTH);
		panelmain.add(panelcenteradd);
		panelcenteradd.setVisible(false);
		
		 scrollPane.getViewport().add(table);
	     panelmain.add(scrollPane);
	     
	//	panelmain.add(panelcenterold);
		panelmain.add(panelbuttom,BorderLayout.SOUTH);
		 initTable("");
		  
		
		//事件
		       
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nametest=add.getText();
				if(nametest.equals("添加")) 
				{
					PanelMain.this.panelmain.setVisible(false);
					PanelMain.this.panelmain.setVisible(true);
					PanelMain.this.panelmain.remove(scrollPane);
					PanelMain.this.panelmain.add(panelcenteradd);
					panelcenteradd.setVisible(true);
					add.setText("save");
					del.setText("cancel");
				}
				else
				{
					PanelMain.this.panelmain.setVisible(false);
					PanelMain.this.panelmain.setVisible(true);
					
					account.setName(Paneladd.nametext.getText());
					account.setPasswords(Paneladd.passwordstext.getText());
					
					
					if(account.getName().equals("") || account.getPasswords().equals("")) 
					{
						JOptionPane.showMessageDialog(null,"账户和密码不能为空","系统消息",JOptionPane.PLAIN_MESSAGE);	
						
						}
					else {
						accountdao.insert(account);
						JOptionPane.showMessageDialog(null,"保存成功","系统消息",JOptionPane.PLAIN_MESSAGE);
						}
					
					add.setText("添加");
					del.setText("删除");
					
					PanelMain.this.panelmain.remove(panelcenteradd);
					PanelMain.this.panelmain.add(scrollPane);
					scrollPane.setVisible(true);
					Paneladd.nametext.setText(null);
					Paneladd.passwordstext.setText(null);
					//String stringid=Paneladd.remaketext.getText();
					//int intid=Integer.parseInt(stringid);
					//Insertpart.testconten( Paneladd.nametext.getText(), Paneladd.passwordstext.getText());
					//account.setData(data);
					//Paneladd.remaketext.setText(null);
					
					
					//添加确认对话框
					initTable(null);
					PanelMain.this.panelmain.setVisible(false);
					PanelMain.this.panelmain.setVisible(true);
					//PanelMain.this.panelmain.add(panelcenterold);
					//panelcenterold.setVisible(true);
					
				}
			}
			
		});
		
		
		
		
		//搜索事件，完成查询功能
	 search.addActionListener(new ActionListener() {

		@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			int row=table.getSelectedRow();
			if(row<0) {
				JOptionPane.showMessageDialog(null, "错误信息", "请选择你要更新的",JOptionPane.INFORMATION_MESSAGE);
			}        
			else {
			int option=	JOptionPane.showConfirmDialog(panelmain,"确认信息", "即将删除所选数据", 
						JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
				if(option==0) {
					Object value=table.getValueAt(row, 0);
					if(value!=null  && !(value+"").trim().equals("")) {
						int id= Integer.parseInt(table.getValueAt(row, 0)+"");
						account.setId(id);
						account.setPasswords((String)table.getValueAt(row, 2));
						accountdao.updata(account);
					}
				}
			}     
  	           }
   	          });
//			
//		 searchspace.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				initTable(searchspace.getText());
//			}
//				
//			});
		 
		 
		 searchspace.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				initTable(searchspace.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				initTable(searchspace.getText());
			}
			 
		 });
		 //删除操作
		 del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(del.getText().equals("删除")) {
				// TODO Auto-generated method stub
				int row= table.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(null, "错误信息", "请选择你要删除的",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					int option=JOptionPane.showConfirmDialog(panelmain,"确认信息", "即将删除所选数据", 
							JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					//返回消息，0为yes，1位no
					if(option==0) {
						Object value=table.getValueAt(row, 0);
							if(value !=null && !(value +"").trim().equals("")) {
								int id= Integer.parseInt(table.getValueAt(row, 0)+"");
								System.out.println(id);
								accountdao.delete(id);
								initTable(null);
								//刷新数据
							}
					}
				}
			   }//为取消时点击
				else
				{
					PanelMain.this.panelmain.setVisible(false);
					PanelMain.this.panelmain.setVisible(true);
					PanelMain.this.panelmain.remove(panelcenteradd);
					PanelMain.this.panelmain.add(scrollPane);
					scrollPane.setVisible(true);
					//Paneladd.remaketext.setText(null);
					Paneladd.nametext.setText(null);
					Paneladd.passwordstext.setText(null);
					add.setText("添加");
					del.setText("删除");
				}
			}
			 
		 });
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
   	 private void initTable(String keyword) {
		        List<Account> list = null;
		        //2. 如果为空，这查询所有数据，否则按关键字搜索。
		        if(keyword == null || keyword.trim().equals("")) {
		          list =accountdao.findAll();
		         } else {
		            list =accountdao.findByKeyword(keyword);
		        }
		       table.setModel(getTableModel(list));
		     }
	 private DefaultTableModel getTableModel(List<Account> list) {
		DefaultTableModel model = new DefaultTableModel();
		      model.addColumn("id");
		     model.addColumn("账号");
		      model.addColumn("密码");
		      model.addColumn("创建日期");
		    for(Account account: list) {
		    	Vector vector =new Vector();
		    	vector.add(account.getId());
		    	vector.add(account.getName());
		    	vector.add(account.getPasswords());
		    	vector.add(account.getData());
		          model.addRow(vector);
		        }
		        return model;
		   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelMain();

	}
	
}
