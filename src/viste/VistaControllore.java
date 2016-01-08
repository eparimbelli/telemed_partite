package viste;

import controllori.SportEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class VistaControllore extends JFrame{
    private SportEventDispatcher controller;
    
    private JButton nextButton;

    public VistaControllore(SportEventDispatcher controller) {
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents(){
        nextButton = new JButton("NEXT");
        
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextEvent();
            }
        });
        
        add(nextButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}
