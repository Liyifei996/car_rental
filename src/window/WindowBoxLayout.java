package window;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;







class WindowBoxLayout extends JFrame implements ActionListener{//继承类JFrame
    JTextField zhanghao_field;
    JPasswordField mima_field;

    JButton login_button;
    Box box1,box2,box3,basebBox;//账号，密码，两个radiobutton，两个按钮都是用行式盒子布局。 basebox用列式把他们包裹起来。
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public WindowBoxLayout(){//WindowBoxLayout重写构造方法


        setLayout(new java.awt.FlowLayout());
        this.init();
        this.backpictuer();

        setVisible(true);//设置为可视化
        this.setTitle("车辆租赁系统——管理员登录");//窗口标题
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//释放当前窗口
        this.setBounds(700, 200, 500, 700);//设置窗口大小距离屏幕左面像素，上方像素，窗口的宽，高，在这里
        //窗口位置设置居中



        validate();





    }



    void init(){


        box1 = Box.createHorizontalBox();
        box1.add(new JLabel("用户名:"));
        box1.setForeground(Color.white);

        box1.add(Box.createHorizontalStrut(8));
        zhanghao_field = new JTextField(15);
        box1.add(zhanghao_field);//登陆界面 账号和输入框的一行

        box2 = Box.createHorizontalBox();
        box2.add(new JLabel("密码:    "));
        box2.setForeground(Color.white);

        box2.add(Box.createHorizontalStrut(8));
        mima_field = new JPasswordField(15);
        box2.add(mima_field);//登陆界面密码和输入框的一行

        basebBox = Box.createVerticalBox();
        basebBox.add(Box.createVerticalStrut(50));
        basebBox.add(box1);
        basebBox.add(Box.createVerticalStrut(10));
        basebBox.add(box2);//封装到一个容器中
        add(basebBox);

        box3 = Box.createHorizontalBox();
        login_button = new JButton("登陆");
        login_button.addActionListener( this);//添加监视器
        box3.add(login_button);
        box3.add(Box.createHorizontalStrut(8));
        box3.add(login_button);//登陆按钮

        basebBox = Box.createVerticalBox();
        basebBox.add(Box.createVerticalStrut(50));
        basebBox.add(box3);

        add(basebBox);

    }
    void backpictuer() {
        ImageIcon bg=new ImageIcon("background.jpg");//设置背景图片
        JLabel label =new JLabel(bg);
        label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel jp=(JPanel)this.getContentPane();
        jp.setOpaque(false);
        JPanel panel =new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        this.add(panel);

    }
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed (ActionEvent e) {
        Object source = e.getSource();
        String username = null;

        String user_password = null;
        connect conn=new connect();
        if (source == login_button)//如果点击的是登陆按钮，就会判断radiobutton选择的是什么，做出相应的响应
        {
            if (zhanghao_field.getText().equals("") || mima_field.getText().equals(""))
            {// 判断是否输入了用户名和密码
                JOptionPane.showMessageDialog(null, "登录名和密码不能为空！");
            }
            else
            {
                conn.connDB();
                try
                {
                    conn.stmt = conn.con.createStatement();
                }
                catch (SQLException e2)
                {
                    e2.printStackTrace();
                }


                try {

                    String sql ="select * from account where Accountnumber ='"+zhanghao_field.getText()+"'";
                    rs = conn.stmt.executeQuery(sql);
                    if(rs.next())
                    {
                        username = rs.getString(1);
                        user_password = rs.getString(2);
                        if(!mima_field.getText().equals(user_password))
                        {
                            JOptionPane.showMessageDialog(null, "密码错误！");
                            mima_field.setText("");

                        }
                        else {
                            this.dispose();
                            new WindowBoxLayout2();
                        }

                    }
                }
                catch (HeadlessException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        }




    }


}

