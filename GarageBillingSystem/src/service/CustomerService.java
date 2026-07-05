package service;
import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException
    {
        Connection con=DbConfig.getConnected();
        PreparedStatement ps=con.prepareStatement("insert into customers(name,phone) values (?,?)");
        ps.setString(1,customer.getName());
        ps.setString(2,customer.getPhone());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    public List<Customer> getAllCustomers() throws SQLException
    {
        List<Customer> list=new ArrayList<>();
        Connection con=DbConfig.getConnected();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from customers");
        while(rs.next())
        {
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("name"),rs.getString("phone")));
        }
        return list;
    }
    public Customer getCustomerBasedOnNum(String number) throws SQLException
    {
        Customer customer=new Customer();
        Connection con=DbConfig.getConnected();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from customers where phone="+number);
        while(rs.next())
        {
            customer=new Customer(rs.getInt("id"),
                    rs.getString("name"),rs.getString("phone"));
        }
        return customer;
    }

}
