package viste;

import eventi.SportEvent;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import partite.PartitaCalcio;
import risultati.RisultatoCalcio;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class VistaCronacaCalcio extends JFrame implements Observer{
        private JLabel partitaLabel, lastEventLabel, minutoLabel;

    public VistaCronacaCalcio() {
        initComponents();
    }

    private void initComponents() {
        partitaLabel = new JLabel("??? - ???");
        lastEventLabel = new JLabel("-");
        minutoLabel = new JLabel("0");
        
        setLayout(new GridLayout(3, 1));
        add(partitaLabel);
        add(minutoLabel);
        add(lastEventLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PartitaCalcio){
            PartitaCalcio partita = (PartitaCalcio) o;
            RisultatoCalcio ris = (RisultatoCalcio) partita.getRisultato();
            SportEvent se = (SportEvent) arg;
            
            partitaLabel.setText(ris.getSquadraA().getAbbreviazione()+" - "+ris.getSquadraB().getAbbreviazione());
            minutoLabel.setText(Integer.toString(partita.getMinutesFromStart(se.getTime())));
            lastEventLabel.setText(se.getDescription());
            
            this.repaint();
        }
    }
}
