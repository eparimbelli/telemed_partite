package partite;

import eventi.SportEvent;
import risultati.RisultatoVolley;
import squadre.Squadra;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class PartitaVolley extends Partita {

    public PartitaVolley(Squadra sA, Squadra sB) {
        super();
        setRisultato(new RisultatoVolley(sA, sB));
    }
    
    @Override
    public void submitEvent(SportEvent se) {
        switch (se.getType()) {
            case "V-00":
                inizioPartita(se.getTime());
                break;
            case "V-99":
                finePartita();
                break;
            case "V-01":
                nuovoSet();
                break;
            case "V-02":
                fineSet();
                break;
            case "V-03":
                puntoA();
                break;
            case "V-04":
                puntoB();
                break;
            case "V-05":
                timeOutA();
                break;
            case "V-06":
                timeOutB();
                break;
            case "V-98":
                break;
            default:
                //exception...
                break;
        }

        super.submitEvent(se);
    }
    
    private void nuovoSet(){
        ((RisultatoVolley)getRisultato()).nuovoSet();
    }
  
    private void fineSet(){
        if(getRisultato().getPuntiSquadraA()>getRisultato().getPuntiSquadraB()){
            ((RisultatoVolley)getRisultato()).addSetA();
        }
        else{
            ((RisultatoVolley)getRisultato()).addSetB();
        }
    }
    
    private void puntoA(){
        ((RisultatoVolley)getRisultato()).addPuntiSquadraA();
    }
    
    private void puntoB(){
        ((RisultatoVolley)getRisultato()).addPuntiSquadraB();
    }
    
    private void timeOutA(){
        ((RisultatoVolley)getRisultato()).addTimeOutSquadraA();
    }
    
    private void timeOutB(){
        ((RisultatoVolley)getRisultato()).addTimeOutSquadraB();
    }
}
