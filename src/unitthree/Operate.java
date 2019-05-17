
package unitthree;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import unitthree.fileIO.ReadInput;
import unitthree.fileIO.WriteOutput;

public class Operate {

    private static List<Ticket> lot = new ArrayList<>();
    public static List<TicketLog> ticketLog = new ArrayList<>();
    public static List<TicketLog> todayLog = new ArrayList<>();
    String fileName = "lotArchive.csv";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Operate lot = new Operate();
    }
    
    public Operate() throws IOException, FileNotFoundException, ClassNotFoundException{
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
            int tl1 = inTicket.getTicketNumber();
            String tl2 = inTicket.getRate();
            double tl3 = inTicket.getAmount();
            
            TicketLog tl = new TicketLog(tl1, tl2, tl3);
            todayLog.add(tl);
        }
        WriteOutput wo = new WriteOutput();
        wo.writeObjects(fileName, (List<TicketLog>) todayLog);
        
        

        List<Ticket> todayLogTest = ReadInput.ReadObjectFile(fileName);
        
        for(int i=0; i < todayLogTest.size(); i++){
            Ticket ticket = todayLogTest.get(i);
            System.out.println("Ticket Number " + ticket.getTicketNumber()
                    + ", Ticket type of Rate " + ticket.getRate()
                    + ", Ticket Amount " + ticket.getAmount());
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
