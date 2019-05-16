
package unitthree;

public class TicketFactory {
    public Ticket makeTicket(int ticketType){
        Ticket newTicket = null;
        if(ticketType == 1){
            return new HourlyTicket();
        }
        else if(ticketType == 2){
            return new SpecialEventTicket();
        }
        else if(ticketType == 9){
            return new BusinessCustomer();
        }
        else return null;
    }
}
