
package unitthree;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class HourlyTicket extends Ticket{
    
    public HourlyTicket(){
        setTicketNumber(nextNumber);
        nextNumber++;
        setRate("Hourly");
        //timeOut = new ClockTime();
        timeIn = new ClockTime();
        hourlyIn = timeIn.clockIn();
        timeOut = new ClockTime();
        //setTimeIn(clockIn);
    }
    
    /*
    public Duration timeParked(LocalTime hourlyIn, LocalTime hourlyOut){
        Duration hoursParked = Duration.between(hourlyIn, hourlyOut); //.toHours()
        return hoursParked;
    }
    */
    /*
    
    //Random randNum = new Random();
    @Override
    public LocalTime clockIn(){
        int hour = randNum.nextInt(5) + 7;
        int min = randNum.nextInt(60);
        LocalTime hm = LocalTime.of(hour, min);
        return hm;
    }
    
    @Override
    public LocalTime clockOut(){
        int hour = randNum.nextInt(11) + 13;
        int min = randNum.nextInt(60);
        LocalTime hm = LocalTime.of(hour, min);
        return hm;
    }
    */
}
