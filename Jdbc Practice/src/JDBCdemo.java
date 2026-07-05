import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCdemo {
    //load the driver class
    //get connection from db
    public static void main(String args[]) throws ClassNotFoundException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load driver class
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd", "root", "root");
            Statement statement=con.createStatement();
            String query="select * from student";
            ResultSet rs=statement.executeQuery(query);
            System.out.println("----read data---- ");
           while(rs.next())
            {
                System.out.println(
                        rs.getInt("id")+ "|"+
                                rs.getString("stdName")+"|"+
                                rs.getInt("age")
                );
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
