package service;

import entity.invoice;

import java.sql.SQLException;
import java.util.List;

public class BillingService {
    public CustomerService customerService=new CustomerService();
    public InvoiceService invoiceService=new InvoiceService();
    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException
    {
        String sids="";
        for(int serviceId:serviceIds)
        {
            sids+=serviceIds;
        }
        invoiceService.addInvoice(new invoice(0,customerId,vehicleId,Integer.parseInt(sids)));

        System.out.println("Invoice generated successfully...");
    }
    public void showAllInvoices() throws SQLException
    {
        List<invoice> invoices=invoiceService.getAllInvoice();
        for(invoice Invoice:invoices)
        {
            System.out.println(Invoice);
        }
    }
}
