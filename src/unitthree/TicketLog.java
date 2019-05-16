
package unitthree;

public class TicketLog {
    
    public int tickeNumber;
    public String ticketType;
    public double ticketAmount;
    
    public TicketLog(int number, String type, double amount){
        this.tickeNumber = number;
        this.ticketType = type;
        this.ticketAmount = amount;
    }

    public int getTicketNumber() {
        return tickeNumber;
    }

    public void setTickeNumber(int tickeNumber) {
        this.tickeNumber = tickeNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
    
    
}
