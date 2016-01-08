package viste;

import eventi.SportEvent;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import partite.PartitaCalcio;
import risultati.RisultatoCalcio;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class VistaRisultatoCalcio extends JFrame implements Observer{

    private JPanel squadraAPanel, squadraBPanel, miscPanel;
    private JLabel squadraALabel, squadraBLabel, puntiALabel, puntiBLabel, tempoLabel;

    public VistaRisultatoCalcio() {
        initComponents();
    }
    
    private void initComponents(){
        squadraALabel = new JLabel("???");
        squadraBLabel = new JLabel("???");
        
        puntiALabel = new JLabel("0");
        puntiBLabel = new JLabel("0");
        
        tempoLabel = new JLabel("X");
        
        squadraAPanel = new JPanel(new GridLayout(2, 1));
        squadraAPanel.add(squadraALabel);
        squadraAPanel.add(puntiALabel);
        
        squadraBPanel = new JPanel(new GridLayout(2, 1));
        squadraBPanel.add(squadraBLabel);
        squadraBPanel.add(puntiBLabel);
        
        miscPanel = new JPanel(new GridLayout(1, 1));
        miscPanel.add(tempoLabel);
        
        setLayout(new GridLayout(1, 3));
        add(squadraAPanel);
        add(miscPanel);
        add(squadraBPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PartitaCalcio){
            PartitaCalcio partita = (PartitaCalcio) o;
            RisultatoCalcio ris = (RisultatoCalcio) partita.getRisultato();
            SportEvent se = (SportEvent) arg;
            
            squadraALabel.setText(ris.getSquadraA().getAbbreviazione());
            squadraBLabel.setText(ris.getSquadraB().getAbbreviazione());
            
            puntiALabel.setText(Integer.toString(ris.getPuntiSquadraA()));
            puntiBLabel.setText(Integer.toString(ris.getPuntiSquadraB()));
            
            tempoLabel.setText(Integer.toString(ris.getTempo()));
            
            this.repaint();
        }
    }
    
}
