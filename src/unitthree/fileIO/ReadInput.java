
package unitthree.fileIO;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import unitthree.Ticket;

public class ReadInput implements Serializable {
    
    public static List<Ticket> ReadObjectFile(String fileName) throws
        IOException, FileNotFoundException, ClassNotFoundException,
        EOFException {
        
        List<Ticket> archiveTicket = new ArrayList<>();
        Object obj;
        
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        try {
            obj = ois.readObject();
            
            while(obj != null){
                Ticket ticket = (Ticket) obj;
                archiveTicket.add(ticket);
                obj = ois.readObject();
            }
        }
        catch(EOFException e){//Do nothing.
        }
        
        ois.close();
        
        return archiveTicket;
    }
    
    public static String ReadStringFile(String fileName) throws
        IOException, FileNotFoundException, ClassNotFoundException,
        EOFException {
        
        try{
            BufferedReader in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: " + fileName 
            + " " + e);
        } catch (Exception e) {
            System.out.println("File Read Error: " + fileName 
            + " " + e);
        }
        
        return "Done";
    }
}
