package test;

import controllori.SportEventDispatcher;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import partite.PartitaCalcio;
import partite.PartitaVolley;
import squadre.Squadra;
import viste.VistaControllore;
import viste.VistaCronacaCalcio;
import viste.VistaCronacaVolley;
import viste.VistaRisultatoCalcio;
import viste.VistaRisultatoVolley;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class Tester {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
//        Squadra juve = new Squadra("Juventus F.C.", "JUV");
//        Squadra roma = new Squadra("A.S. Roma", "ROM");
//        PartitaCalcio juveRoma = new PartitaCalcio(juve, roma);
//        
//        SportEventDispatcher dispatcher = new SportEventDispatcher(juveRoma);
//        dispatcher.acquisisciEventi(new File("files/JUV-ROM.txt"));
//        
//        VistaControllore vControllore = new VistaControllore(dispatcher);
//        
//        VistaRisultatoCalcio vRisultatoCalcio = new VistaRisultatoCalcio();
//        VistaCronacaCalcio vCronacaCalcio = new VistaCronacaCalcio();
//        juveRoma.addObserver(vCronacaCalcio);
//        juveRoma.addObserver(vRisultatoCalcio);
//        
//        vRisultatoCalcio.setLocation(300, 100);
//        vRisultatoCalcio.setSize(200, 200);
//        vCronacaCalcio.setLocation(200, 400);
//        vCronacaCalcio.setSize(1000,100);
//        
//        vControllore.setVisible(true);
//        vRisultatoCalcio.setVisible(true);
//        vCronacaCalcio.setVisible(true);
//        
        Squadra a = new Squadra("Squadra A", "SQA");
        Squadra b = new Squadra("Squadra B", "SQB");
        PartitaVolley pVolley = new PartitaVolley(a, b);
        
        SportEventDispatcher volleyDispatcher = new SportEventDispatcher(pVolley);
        volleyDispatcher.acquisisciEventi(new File("files/volley1.txt"));
        
        VistaControllore vControllore = new VistaControllore(volleyDispatcher);
        
        VistaRisultatoVolley vrv = new VistaRisultatoVolley();
        VistaCronacaVolley vcv = new VistaCronacaVolley();
        pVolley.addObserver(vcv);
        pVolley.addObserver(vrv);

        vrv.setLocation(300, 100);
        vrv.setSize(200, 200);
        vcv.setLocation(200, 400);
        vcv.setSize(1000,100);

        vControllore.setVisible(true);
        vrv.setVisible(true);
        vcv.setVisible(true);
    }
}
