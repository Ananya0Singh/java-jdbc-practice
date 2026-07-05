package service;

import config.DbConfig;
import entity.Customer;
import entity.invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    public void addInvoice(invoice Invoice) throws SQLException
    {
        Connection con= DbConfig.getConnected();
        PreparedStatement ps=con.prepareStatement("insert into INVOICE(customer_id,vehicle_id,service_id) values (?,?.?)");
        ps.setInt(1,Invoice.getCustomerId());
        ps.setInt(2,Invoice.getVehicleId());
        ps.setInt(3,Invoice.getServiceId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
    public List<invoice> getAllInvoice() throws SQLException
    {
        List<invoice> list=new ArrayList<>();
        Connection con=DbConfig.getConnected();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from invoice");
        while(rs.next())
        {
            list.add(new invoice(rs.getInt("id"),
                    rs.getInt("customer_id"),rs.getInt("vehicle_id"),rs.getInt("service_id")));
        }
        return list;
    }
}
