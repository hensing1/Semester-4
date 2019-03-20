package AbstraktUndCo;

public abstract class Fortbewegungsmittel {
    
    private int baujahr;
    private String beschreibung;
    
    public Fortbewegungsmittel(int baujahr) {
        this.baujahr = baujahr;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    
    public abstract void bremsen();
}
