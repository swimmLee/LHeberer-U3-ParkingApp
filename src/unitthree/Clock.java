
package unitthree;

import java.time.LocalTime;
import java.util.Random;

public interface Clock {
    
    LocalTime clockIn();
    LocalTime clockOut();
    
}

class ClockTime implements Clock{
    Random randNum = new Random();
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
}
