package window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


import show.*;
import method.*
        ;

public class WindowBoxLayout2 extends JFrame implements ActionListener {//继承类JFrame
    Box boxH;
    Box boxVone;
    Box boxVTwo;
    JButton button1;//设置登录按钮
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;


    public WindowBoxLayout2(){//WindowBoxLayout重写构造方法


        setLayout(new java.awt.FlowLayout());
        this.init();
        this.backpictuer();

        setVisible(true);//设置为可视化
        this.setTitle("车辆租赁系统");//窗口标题
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//释放当前窗口
        this.setBounds(700, 200, 500, 700);//设置窗口大小距离屏幕左面像素，上方像素，窗口的宽，高，在这里
        //窗口位置设置居中


        validate();

    }
    void init(){



        button1=new JButton("车辆信息管理");//设置登录按钮
        button2=new JButton("租车信息管理");
        button3=new JButton("还车信息管理");
        button4=new JButton("修车信息管理");
        button5=new JButton("利润分析");
        button1.setBackground(Color.getHSBColor(225,230,246));
        button2.setBackground(Color.getHSBColor(225,230,246));
        button3.setBackground(Color.getHSBColor(225,230,246));
        button4.setBackground(Color.getHSBColor(225,230,246));
        button5.setBackground(Color.getHSBColor(225,230,246));



        button1.addActionListener( this);
        button2.addActionListener( this);
        button3.addActionListener( this);
        button4.addActionListener( this);
        button5.addActionListener( this);//添加监视器




        button1.setLocation(100, 50);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        button1.setPreferredSize(new Dimension(150,150));//设置大小
        button2.setPreferredSize(new Dimension(150,150));
        button3.setPreferredSize(new Dimension(150,150));
        button4.setPreferredSize(new Dimension(150,150));
        button5.setPreferredSize(new Dimension(150,150));

        this.setVisible(true);//设置为可视化
        this.validate();





    }
    void backpictuer() {
        ImageIcon bg=new ImageIcon("background2.jpg");//设置背景图片
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
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        String username = null;

        String user_password = null;
        connect conn=new connect();

        if(source == button1) {

            this.dispose();
            new checkcar();


        }
        if(source == button2) {

            this.dispose();
            new zuche();


        }
        if(source == button3) {

            this.dispose();
            new huanche();

        }
        if(source == button4) {

            this.dispose();
            new repaircar();

        }
        if(source == button5) {

            this.dispose();
            new carprofit();

        }
    }
}
