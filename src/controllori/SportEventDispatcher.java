package controllori;

import eventi.SportEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import partite.Partita;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class SportEventDispatcher {
    private Partita partita;
    private Iterator<SportEvent> sportEventsIter;

    public SportEventDispatcher(Partita partita) {
        this.partita = partita;
    }
    
    public boolean ready(){
        if(sportEventsIter!=null) return true;
        return false;
    }
    
    public void acquisisciEventi(File f) throws IOException, ParseException{
        List<SportEvent> sportEvents = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(f));
        while(br.ready()){
            String[] ls = br.readLine().split("\t");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date date = dateFormat.parse(ls[2]);
            GregorianCalendar time = new GregorianCalendar();
            time.setTime(date);
            
            sportEvents.add(new SportEvent(ls[0], ls[1], time));
        }
        
        sportEventsIter = sportEvents.iterator();
    }
    
    public void nextEvent(){
        if(sportEventsIter.hasNext()){
            partita.submitEvent(sportEventsIter.next());
        } 
       
    }
}
