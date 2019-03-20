package AbstraktUndCo;

public abstract class Fortbewegungsmittel {
    
    private int baujahr;
    
    public Fortbewegungsmittel(int baujahr) {
        this.baujahr = baujahr;
    }

    public int getBaujahr() {
        return baujahr;
    }
}
