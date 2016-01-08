package partite;

import eventi.SportEvent;
import java.util.Calendar;
import java.util.Observable;
import risultati.Risultato;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public abstract class Partita extends Observable {

    private Risultato risultato;
    protected Calendar timeInizio;
    private boolean finita;

    public Partita() {
        this.finita = false;
    }

    public void submitEvent(SportEvent se){
        setChanged();
        notifyObservers(se);
    }
    
    protected void setRisultato(Risultato risultato){
        this.risultato = risultato;
    }
    
    public Risultato getRisultato(){
        return risultato;
    }

    public boolean isFinita() {
        return finita;
    }

    protected void setFinita(boolean finita) {
        this.finita = finita;
    }
    
    protected void finePartita(){
        setFinita(true);
    }
    
    protected void inizioPartita(Calendar inizio){
        timeInizio = inizio;
    }
}
