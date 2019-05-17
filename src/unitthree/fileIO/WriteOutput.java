
package unitthree.fileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WriteOutput implements Serializable {
    
    public static void writeObjects(String fileName, List<unitthree.TicketLog> log)
            throws FileNotFoundException, IOException{
        
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            for(int i=0; i<log.size();i++){
                oos.writeObject(log.get(i));
                System.out.println("Writing file:\tTicketNo " + 
                    log.get(i).getTicketNumber() + 
                    "\tTicket Type  " + log.get(i).getTicketAmount() +
                    "\tAmount " + log.get(i).getTicketAmount());
            }
        }
        catch(IOException e){
            System.out.println("Caught error in LotWriter.");
            // Do Nothing
        }
        oos.close();
    }
}