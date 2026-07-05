import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollinsensitive {
    //load the driver class
    //get connection from db
    public static void main(String args[]) throws ClassNotFoundException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load driver class
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd", "root", "root");
            Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query="select * from student";
            ResultSet rs=statement.executeQuery(query);
            System.out.println("----Scrollinsensitive,Readonly---- ");
            rs.last();
            System.out.println("Last row: "+rs.getInt("id"));
            System.out.println("Last row: "+rs.getString("stdName"));

            rs.first();
            System.out.println("Last row: "+rs.getInt("id"));
            System.out.println("Last row: "+rs.getString("stdName"));

            rs.absolute(2);
            System.out.println("Last row: "+rs.getInt("id"));
            System.out.println("Last row: "+rs.getString("stdName"));
            /*while(rs.next())
            {
                System.out.println(
                        rs.getInt("id")+ "|"+
                                rs.getString("stdName")+"|"+
                                rs.getInt("age")
                );
            }*/

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
