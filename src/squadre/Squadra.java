package squadre;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class Squadra {
    private String nome, abbreviazione;

    public Squadra(String nome, String abbreviazione) {
        this.nome = nome;
        this.abbreviazione = abbreviazione;
    }

    public String getNome() {
        return nome;
    }

    public String getAbbreviazione() {
        return abbreviazione;
    }
    
    
}
