package partite;

import eventi.SportEvent;
import java.util.Calendar;
import risultati.RisultatoCalcio;
import squadre.Squadra;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class PartitaCalcio extends Partita{
    
    private int tempoNonGioco;

    public PartitaCalcio(Squadra sA, Squadra sB) {
        super();
        setRisultato(new RisultatoCalcio(sA, sB));
        
        tempoNonGioco = 0;
    }

    @Override
    public void submitEvent(SportEvent se) {
        switch(se.getType()){
            case "C-00":
                inizioPartita(se.getTime());
                break;
            case "C-99":
                finePartita();
                break;
            case "C-01":
                finePrimoTempo();
                break;
            case "C-02":
                inizioSecondoTempo();
                break;
            case "C-04":
                golA();
                break;
            case "C-05":
                golB();
                break;
            case "C-98":
                break;
            default:
                //exception...
                break;
        }
        
        super.submitEvent(se);
    }
    
    private void finePrimoTempo(){
    }
    
    private void inizioSecondoTempo(){
        ((RisultatoCalcio)getRisultato()).addTempo();
        intervallo(30);
    }
    
    private void intervallo(int minuti){
        tempoNonGioco += minuti;
    }
    
    private void golA(){
        ((RisultatoCalcio)getRisultato()).addPuntiSquadraA();
    }
    
    private void golB(){
        ((RisultatoCalcio)getRisultato()).addPuntiSquadraB();
    }

    public int getMinutesFromStart(Calendar date){
        long eventMillis = date.getTimeInMillis();
        long startMillis = timeInizio.getTimeInMillis();
        long delta = eventMillis-startMillis;
        int deltaMin = (int) delta/60000;
        
        
        return deltaMin-tempoNonGioco;
    }
}
