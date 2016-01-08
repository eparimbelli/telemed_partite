package risultati;

import squadre.Squadra;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class RisultatoCalcio extends Risultato{
    
    private int tempo;

    public RisultatoCalcio(Squadra squadraA, Squadra squadraB) {
        super(squadraA, squadraB);
        tempo = 1;
    }

    public void addTempo(){
        tempo++;
    }

    public int getTempo() {
        return tempo;
    }
}
