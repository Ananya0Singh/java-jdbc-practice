import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertUsingPrepare
{
    //load the driver class
    //get connection from db
    public static void main(String args[]) throws ClassNotFoundException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load driver class
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd", "root", "root");
            //Statement statement=con.createStatement();
            String query = "INSERT INTO student VALUES (?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,6);
            ps.setString(2,"Asha");
            ps.setInt(3,60);
            int update=ps.executeUpdate();
            System.out.println("rows updated =>"+update);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
