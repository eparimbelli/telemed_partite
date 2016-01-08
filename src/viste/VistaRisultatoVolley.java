package viste;

import eventi.SportEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import partite.PartitaVolley;
import risultati.RisultatoVolley;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class VistaRisultatoVolley extends JFrame implements Observer{
    
    private JPanel mainPanel, squadraAPanel, squadraBPanel, bottomAPanel, bottomBPanel;
    private JLabel squadraALabel, squadraBLabel, puntiALabel, puntiBLabel, setALabel, setBLabel, timeOutALabel, timeOutBLabel, currentSetLabel;

    public VistaRisultatoVolley() {
        initComponents();
    }

    private void initComponents() {
        squadraALabel = new JLabel("???");
        squadraBLabel = new JLabel("???");
        
        puntiALabel = new JLabel("0");
        puntiBLabel = new JLabel("0");
        
        setALabel = new JLabel("0");
        setBLabel = new JLabel("0");
        
        timeOutALabel = new JLabel("0");
        timeOutBLabel = new JLabel("0");
        
        bottomAPanel = new JPanel(new GridLayout(1, 2));
        bottomAPanel.add(setALabel);
        bottomAPanel.add(timeOutALabel);
        
        bottomBPanel = new JPanel(new GridLayout(1, 2));
        bottomBPanel.add(timeOutBLabel);
        bottomBPanel.add(setBLabel);
        
        squadraAPanel = new JPanel(new GridLayout(3, 1));
        squadraAPanel.add(squadraALabel);
        squadraAPanel.add(puntiALabel);
        squadraAPanel.add(bottomAPanel);
        
        squadraBPanel = new JPanel(new GridLayout(3, 1));
        squadraBPanel.add(squadraBLabel);
        squadraBPanel.add(puntiBLabel);
        squadraBPanel.add(bottomBPanel);
        
        mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(squadraAPanel);
        mainPanel.add(squadraBPanel);
        
        currentSetLabel = new JLabel("0");
        
        add(mainPanel,BorderLayout.CENTER);
        add(currentSetLabel,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PartitaVolley){
            PartitaVolley partita = (PartitaVolley) o;
            RisultatoVolley ris = (RisultatoVolley) partita.getRisultato();
            SportEvent se = (SportEvent) arg;
            
            squadraALabel.setText(ris.getSquadraA().getAbbreviazione());
            squadraBLabel.setText(ris.getSquadraB().getAbbreviazione());
            
            puntiALabel.setText(Integer.toString(ris.getPuntiSquadraA()));
            puntiBLabel.setText(Integer.toString(ris.getPuntiSquadraB()));
            
            setALabel.setText(Integer.toString(ris.getSetA()));
            setBLabel.setText(Integer.toString(ris.getSetB()));
            
            timeOutALabel.setText(Integer.toString(ris.getTimeOutA()));
            timeOutBLabel.setText(Integer.toString(ris.getTimeOutB()));
            
            currentSetLabel.setText(Integer.toString(ris.getNumeroSet()));
            
            this.repaint();
        }
    }

    
}
