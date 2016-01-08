package viste;

import eventi.SportEvent;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import partite.PartitaVolley;
import risultati.RisultatoVolley;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class VistaCronacaVolley extends JFrame implements Observer{
    private JLabel partitaLabel, lastEventLabel;

    public VistaCronacaVolley() {
        initComponents();
    }

    private void initComponents() {
        partitaLabel = new JLabel("??? - ???");
        lastEventLabel = new JLabel("-");
        
        setLayout(new GridLayout(2, 1));
        add(partitaLabel);
        add(lastEventLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PartitaVolley){
            PartitaVolley partita = (PartitaVolley) o;
            RisultatoVolley ris = (RisultatoVolley) partita.getRisultato();
            SportEvent se = (SportEvent) arg;
            
            partitaLabel.setText(ris.getSquadraA().getAbbreviazione()+" - "+ris.getSquadraB().getAbbreviazione());
            lastEventLabel.setText(se.getDescription());
            
            this.repaint();
        }
    }
}
