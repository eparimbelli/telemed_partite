package risultati;

import squadre.Squadra;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class Risultato {
    
    private Squadra squadraA, squadraB;
    protected int puntiSquadraA, puntiSquadraB;

    public Risultato(Squadra squadraA, Squadra squadraB) {
        this(squadraA, squadraB, 0, 0);
    }

    public Risultato(Squadra squadraA, Squadra squadraB, int puntiSquadraA, int puntiSquadraB) {
        this.squadraA = squadraA;
        this.squadraB = squadraB; 
        this.puntiSquadraA = puntiSquadraA;
        this.puntiSquadraB = puntiSquadraB;
    }
    
    public void addPuntiSquadraA(){
        puntiSquadraA++;
    }

    public void resetPuntiSquadraA(){
        puntiSquadraA = 0;
    }
    
    public void addPuntiSquadraB(){
        puntiSquadraB++;
    }
    
    public void resetPuntiSquadraB(){
        puntiSquadraB = 0;
    }

    public Squadra getSquadraA() {
        return squadraA;
    }

    public Squadra getSquadraB() {
        return squadraB;
    }

    public int getPuntiSquadraA() {
        return puntiSquadraA;
    }

    public int getPuntiSquadraB() {
        return puntiSquadraB;
    }
    
    
}
