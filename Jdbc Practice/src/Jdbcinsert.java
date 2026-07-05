import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbcinsert
{
    //load the driver class
    //get connection from db
    public static void main(String args[]) throws ClassNotFoundException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load driver class
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd", "root", "root");
            Statement statement=con.createStatement();
            String query="insert into student(id,stdName,age) values(4,'Aman',50)";
            int update=statement.executeUpdate(query);
            System.out.println("inserted"+update+"rows  ");


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
