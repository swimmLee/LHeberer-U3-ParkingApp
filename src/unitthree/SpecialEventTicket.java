
package unitthree;

public class SpecialEventTicket extends Ticket{
    
    public SpecialEventTicket(){
        setTicketNumber(nextNumber);
        nextNumber++;
        setRate("Special Event");
    }
}
