import entity.Customer;
import service.BillingService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        BillingService service=new BillingService();
        while(true)
        {
            System.out.println(("1. Add Customer with vehichle \n2. Generate Invoice\n3. Show Invoice\n4. Exit"));
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Customer name: ");
                    String name=sc.next();
                    System.out.println("phone: ");
                    String phone=sc.next();
                    service.customerService.addCustomer(new Customer(0,name,phone));
                    System.out.println("enter vehicle number");
                    String Vehiclenum=sc.next();
                    System.out.println("enter vehicle model");
                    String model=sc.next();
                    Customer CustomerBasedOnNum=service.customerService.getCustomerBasedOnNum(num);
                    service
                    break;

                case 2:
                    System.out.println("Enter customer Id: ");
                    int cid=sc.nextInt();
                    System.out.println("Enter Vehicle Id ");
                    int vid=sc.nextInt();
                    System.out.println("Enter the no. of services");
                    int n=sc.nextInt();
                    List<Integer> sids=new ArrayList<>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println("Enter the service id");
                        sids.add(sc.nextInt());
                    }
                    service.createInvoice(cid,vid,sids);
                    break;
                case 3:
                    service.showAllInvoices();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("not a valid choice");
                    break;


            }
        }
    }
}
