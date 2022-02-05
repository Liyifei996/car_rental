package show;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import window.WindowBoxLayout2;
import window.connect;

public class repaircar extends JFrame implements ActionListener {
	JTextField field1,field2,field3,field4,field5;
	JPanel jPanel4,jPanel5;
	Box box1,box2,box3,box4,box5,box6,box7,baseBox;
	JButton buttonOfQueDing,buttonOfReset,buttonOfQuXIAO;
	JTable table;
     connect conn=new connect();
     Object a[][];
     Object name[] = {"�������","��������","����״̬"};
	private JButton buttonOfXinxiliulan;
	private JButton buttonOfxiuche;
	private JButton buttonOffanhui;
	private JButton buttonOffanhuan;
	private JLabel label1;
	private JLabel label2;
	private JTextField field;
	public repaircar()//�����˳���
	{
		
		init();
		setVisible(true);

		setBounds(700, 200, 800, 500);
		setTitle("����ά����Ϣ");
		xinXiLiuLan();
	}
	public void xinXiLiuLan()//��Ϣ����ķ�������Ϊɾ�����ݺ��ˢ��һ�£��Զ����ô˺�����
	{
		int i=0;
		 while(i<30)
		 {
			 a[i][0]=" ";
			 a[i][1]=" ";
			 a[i][2]=" ";
			 
			 
			
			 i++;
		 }
		 i=0;
		
		
		 conn.connDB();
		 try {
			conn.stmt = conn.con.createStatement();
			 String sql= "select * from carlist where carhire='repairing' ";
			 conn.rs = conn.stmt.executeQuery(sql);
			 while(conn.rs.next())
			 {
				 String number = conn.rs.getString("carnumber");
				 String carname = conn.rs.getString("carname");
			
				 String carhire = conn.rs.getString("carhire");
				
				
				 a[i][0]=number;
				 a[i][1]=carname;
				 a[i][2]=carhire;
			
			
				
				
				 i++;
				 
			 }
			 conn.closeDB();
			 repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 conn.closeDB();
	}
	
	void init()
	{
		
			label1 = new JLabel("����������Ϣ����ϵͳ----����ά��ϵͳ��201931051147���˷ɣ�");
	
			buttonOfXinxiliulan = new JButton("  ˢ��  ");
			buttonOfXinxiliulan.addActionListener(this);
			
			buttonOfxiuche = new JButton("   ���      ");
			buttonOfxiuche.addActionListener(this);
			
			buttonOffanhuan=new JButton(" �������� ");
			buttonOffanhuan.addActionListener(this);
			
			buttonOffanhui=new JButton("  ����  ");
			buttonOffanhui.addActionListener(this);
			
			
			label2 = new JLabel("���޳�����ţ�");
			
			field = new JTextField();
			field2 = new JTextField();
			field3 = new JTextField();
			
			
			a = new Object[50][6];
			table = new JTable(a, name);//����Ĵ���
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(table);
			baseBox =Box.createHorizontalBox();
			box1 = Box.createVerticalBox();
			
			box1.add(Box.createVerticalStrut(20));
			box1.add(buttonOfXinxiliulan);
			box1.add(Box.createVerticalStrut(15));
			box1.add(label2);
			box1.add(Box.createVerticalStrut(5));
			box1.add(field);
			box1.add(Box.createVerticalStrut(5));
			box1.add(buttonOfxiuche);
			box1.add(Box.createVerticalStrut(5));
			box1.add(field2);
			box1.add(Box.createVerticalStrut(5));
			box1.add(buttonOffanhuan);
			box1.add(Box.createVerticalStrut(5));
			box1.add(buttonOffanhui);
			
			
			
		
			
			
			
			box2 = Box.createHorizontalBox();
			box2.add(Box.createHorizontalStrut(10));
			box2.add(box1);   //��ߵİ�ť������ box����
			
			jPanel4 = new JPanel();
			jPanel5 = new JPanel();
			jPanel4.setLayout(new BorderLayout());
			jPanel4.add(box2,BorderLayout.NORTH);//����ߵİ�ť���ַŵ�jpanel4�С�
			

			jPanel5.setLayout(new BorderLayout());
			jPanel5.add(label1,BorderLayout.NORTH);
			jPanel5.add(scrollPane,BorderLayout.CENTER);//�ѱ�� ��jpanel5��
		
			this.setLayout(new BorderLayout());
			add(jPanel5,BorderLayout.EAST);
			add(jPanel4,BorderLayout.WEST);//���������panel�ŵ���������

		
		
	}
	
	
	
	
	public static boolean isNumeric(String str){
		   for (int i = str.length();--i>=0;){   
		    if (!Character.isDigit(str.charAt(i))){
		     return false;
		    }
		   }
		   return true;
		  }//�ж� ���������ǲ���������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if(source==buttonOfXinxiliulan) {
			xinXiLiuLan();
		}
		

		
		else if(source == buttonOfxiuche)
		{	conn.connDB();
			if(field.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "����д������");
			}
			else if(!isNumeric(field.getText()))
			{
				JOptionPane.showMessageDialog(null, "��� ������������");
			}

			else
			{
				
				try{
					int numberint = Integer.parseInt(field.getText());
					conn.stmt = conn.con.createStatement();
					String str1="select carnumber from carlist where carhire='no lend'";
		
					conn.rs = conn.stmt.executeQuery(str1);
					int flag=0;
					while(conn.rs.next()) {
						String carall = conn.rs.getString("carnumber");
						if(field.getText().equals(carall))
						{flag=1;}

					}
					
				
					
					

					if(flag==1)
					{String str = "update carlist set carhire='repairing'where carnumber="+field.getText()+"";
					conn.stmt.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "���޳ɹ���");
					conn.closeDB();
					xinXiLiuLan();
					}
					else {
						
						JOptionPane.showMessageDialog(null, "����ʧ�ܣ���������ά�޻��ѽ��");
					}
					//this.dispose();
					//new WindowBoxLayout2();
				} catch (SQLException e1) {
//				e1.printStackTrace();
					
				JOptionPane.showMessageDialog(null, "�˱���Ѿ������ã��뻻һ����ţ�");
				}
				
				
			}
			
		}
		else if(source == buttonOffanhui)
		{
			this.dispose();
			new WindowBoxLayout2();
			
		}
		else if(source == buttonOffanhuan)
		{
				
			conn.connDB();
			if(field2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "����д������");
			}
			else if(!isNumeric(field2.getText()))
			{
				JOptionPane.showMessageDialog(null, "��� ������������");
			}
			
			else
			{
				
				try{
					int numberint2 = Integer.parseInt(field2.getText());
					conn.stmt = conn.con.createStatement();
					String str2="select carnumber from carlist where carhire='repairing'";
		
					conn.rs = conn.stmt.executeQuery(str2);
					int flag2=0;
					while(conn.rs.next()) {
						String carall = conn.rs.getString("carnumber");
						if(field2.getText().equals(carall))
						{flag2=1;}

					}
					
				
					
					

					if(flag2==1)
					{
					String str3 = "update carlist set carhire='no lend'where carnumber="+field2.getText()+"";
					conn.stmt.executeUpdate(str3);
					String add ="update carlist set Times_of_repair=Times_of_repair+1";
					conn.stmt.executeUpdate(add);
					JOptionPane.showMessageDialog(null, "���޳ɹ���");
					conn.closeDB();
					xinXiLiuLan();
					}
					else {
						
						JOptionPane.showMessageDialog(null, "����ʧ�ܣ�����δ��ά��״̬");
					}
					//this.dispose();
					//new WindowBoxLayout2();
				} catch (SQLException e1) {
//				e1.printStackTrace();
					
				JOptionPane.showMessageDialog(null, "�˱���Ѿ���ʹ�ã��뻻һ����ţ�");
				}
				
				
			}
			
		}
		
		
	}
}
