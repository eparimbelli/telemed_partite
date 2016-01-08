package risultati;

import squadre.Squadra;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class RisultatoVolley extends Risultato{
    
    private int numeroSet, timeOutA, timeOutB, setA, setB;

    public RisultatoVolley(Squadra squadraA, Squadra squadraB) {
        super(squadraA, squadraB);
        
        numeroSet = 0;
        timeOutA = 0;
        timeOutB = 0;
        setA = 0;
        setB = 0;
    }
    
    public void nuovoSet(){
        numeroSet++;
        timeOutA = 0;
        timeOutB = 0;
        resetPuntiSquadraA();
        resetPuntiSquadraB();
    }
    
    public void addTimeOutSquadraA(){
        timeOutA++;
    }

    public void addTimeOutSquadraB(){
        timeOutB++;
    }
    
    public void addSetA(){
        setA++;
    }
    
    public void addSetB(){
        setB++;
    }

    public int getNumeroSet() {
        return numeroSet;
    }

    public int getTimeOutA() {
        return timeOutA;
    }

    public int getTimeOutB() {
        return timeOutB;
    }

    public int getSetA() {
        return setA;
    }

    public int getSetB() {
        return setB;
    }
}
