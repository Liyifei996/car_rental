package window;

import java.sql.*;

public class start {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WindowBoxLayout window1 = new WindowBoxLayout();//用子类COmponentInWindow创建对象

    }
}

//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/car?useSSL=false&serverTimezone=UTC";
//
//
//    // 数据库的用户名与密码，需要根据自己的设置
//    static final String USER = "root";
//    static final String PASS = "haohaoxuexiybwa123";
//
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            System.out.println("连接数据库...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT Accountnumber, Password FROM account";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                String id  = rs.getString("Accountnumber");
//                String name = rs.getString("Password");
//
//                // 输出数据
//                System.out.print("用户名: " + id);
//                System.out.print(",密码: " + name);
//                System.out.print("\n");
//            }
//            // 完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Goodbye!");
//    }
//
//
//}
