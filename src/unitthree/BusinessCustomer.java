
package unitthree;

public class BusinessCustomer extends Ticket{
    
    public BusinessCustomer(){
        setTicketNumber(nextNumber);
        nextNumber++;
        setRate("Business Customer");
    }
}
