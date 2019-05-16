
package unitthree;

import java.time.Duration;
import java.time.LocalTime;

public class Ticket {
    private int ticketNumber;
    public LocalTime hourlyIn;
    private LocalTime hourlyOut;
    private String rate;
    public Clock timeIn;
    public Clock timeOut;
    
    public static int nextNumber = 1;
    
    public Duration timeParked(){
        Duration hoursParked = Duration.between(hourlyIn, hourlyOut); //.toHours()
        return hoursParked;
    }
    
    public int getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    public LocalTime getHourlyIn() { return hourlyIn; }

    public Clock getTimeIn() { return timeIn; }
    public void setTimeIn(Clock timeIn) {
        this.timeIn = timeIn;
    }

    public Clock getTimeOut() { return timeOut; }
    public void setTimeOut(LocalTime timeOut) {
        this.hourlyOut = timeOut;
    }
    
    public String getRate() { return rate; }
    public void setRate(String rate) {
        this.rate = rate;
    }
    
    public void displayRateType(){
        System.out.println("The customer pays " + getRate());
    }
    
    public void showTicketNumber(){
        System.out.println("This is ticket number " + getTicketNumber());
    }
    
}
