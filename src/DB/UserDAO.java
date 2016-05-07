package DB;

import ControlCenter.UserController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sarleon on 16-5-6.
 */
public class UserDAO {
    private static UserController userController=UserController.getInstance();
    public  static  boolean login(User user){
        Connection connection=BaseConnection.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT * FROM user WHERE username=? AND password=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
             resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){

                    System.out.println(resultSet.getRow());
                    System.out.println(user.getUsername()+"登陆成功");

                return true;
            } else {
                System.out.println("登录失败");
                return  false;
            }


        } catch (Exception e){

        } finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if (preparedStatement != null) {
                     preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    public static boolean register(User user){
        Connection connection=BaseConnection.getConnection();
        PreparedStatement preparedStatement=null;

        String sql="INSERT INTO user (username,password) VALUES (?,?)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            int res=preparedStatement.executeUpdate();
            if(res>0){
                System.out.println("成功注册"+user.getUsername());
                return true;
            } else {
                System.out.println("注册失败");
                return false;
            }
        } catch (Exception e){

        } finally {
            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;

    }


}
