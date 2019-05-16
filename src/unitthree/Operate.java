
package unitthree;

import static java.lang.Integer.parseInt;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operate {

    private static List<Ticket> lot = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Operate lot = new Operate();
    }
    
    public Operate(){
        Scanner kb = new Scanner(System.in);
        int ans;
        TicketFactory ticketFactory = new TicketFactory();
        Ticket inTicket = null;
        do{
            displayTicketMenu();
            ans = parseInt(kb.nextLine());
            if(ans == 1 || ans == 2 || ans == 9){
                int typeOfTicket = ans;
                inTicket = ticketFactory.makeTicket(typeOfTicket);
            }
            if(ans == 3)
                break;
            if(inTicket != null){
                doStuff(inTicket);
                lot.add(inTicket);
                if(ans == 1){
                    System.out.println(inTicket.getTimeIn());
                    System.out.println("Time in " + inTicket.getHourlyIn());
                }
            }
            else System.out.println(
                    "Error: please enter 1, 2 or 3 (9) next time.");
        } while(ans != 3);
        
        showParkedCars();
        
        while(!lot.isEmpty()){
            inTicket = lot.remove(0);
            doStuff(inTicket);
            
            if(inTicket.getTicketNumber() == 1){
                //inTicket.timeOut = new ClockTime();
                //hourlyOut = inTicket.timeOut.clockOut();
                inTicket.setTimeOut(inTicket.timeOut.clockOut());
                //Duration parkDuration = Duration.between(inTicket.hourlyIn, inTicket.hourlyOut);
                //int hoursParked = (int)parkDuration.toHours();
                Duration time = inTicket.timeParked();
                System.out.println("Time parked " + time + "\n");
            }
        }
    }
    
    public void showParkedCars(){
        for(Ticket n : lot){
            System.out.println("\n\tnext");
            doStuff(n);
        }
    }
    
    public static void doStuff(Ticket aTicket){
        aTicket.showTicketNumber();
        aTicket.displayRateType();
    }
    
    public void displayTicketMenu(){
        System.out.println("Choose the type of ticket from the following:");
        System.out.println("1. Hourly Parking.");
        System.out.println("2. Special Event Parking.");
        System.out.println("3. Close the Parking Lot.");
        System.out.println("9. Business Customer.");
        //return "Done";
    }
}
