package Com.Dao.Dao;




import Com.Dao.User.User;

import java.sql.*;

public class Dao {

    static String userName;
    static String userPassword;
    static Connection connection;
    static PreparedStatement stmt;
    static ResultSet resultSet;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {

            System.out.println(ex);
        }
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/user?useSSL=false";
            String user = "root";
            String password = "mysql123456";
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception ss) {
            System.out.println(ss);

        }


        return connection;


    }


    public String getUserName() {

        try {
            String sql = "SELECT * FROM userinformation WHERE user_name LIKE ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, "张%");

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                userName = resultSet.getString("user_name");

            }
             System.out.println(userName);


        } catch (Exception DD) {
            System.out.println(DD);
        }

        return userName;
    }

    public String getUserPassword() {
        try {
            String sql = "SELECT * FROM userinformation WHERE user_password LIKE ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, "12345%");
            // stmt.setString(2, "123456");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                userPassword = resultSet.getString("user_password");

            }
            System.out.println(userPassword);


        } catch (Exception DD) {
            System.out.println(DD);
        }

        return userPassword;
    }



    public User getHehe(String name, String password) {
        User us = new User();
        if(this.userName.equals(name) && this.userPassword.equals(password)){
            return us;

        }
        return null;
    }


    public void closeAll() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Dao compare = new Dao();
        User us = new User();
        compare.getConnection();
        // compare.getUserName();
        //compare.getUserPassword();
        us.setName(compare.getUserName());
        us.setPassword(compare.getUserPassword());

        compare.closeAll();



    }
}
