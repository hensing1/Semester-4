package AbstraktUndCo;

public class Auto extends Landfahrzeug{
    private boolean kofferraumKlappeOffen;
    
    public Auto(int baujahr) {
        super(baujahr);
        kofferraumKlappeOffen = false;
    }
    
    public Auto(String bezeichnung, int baujahr, boolean isDiesel, int anzahlZylinder, int ps) {
        super (baujahr, isDiesel, anzahlZylinder, ps);
        setBeschreibung(bezeichnung);
    }

    @Override
    public void bremsen(){
        try {
            motor.wenigerBrumm();
        } catch (Motor.MotorKaputtException mke) {
            System.out.println(mke.toString());
        } catch (Motor.MotorLäuftNichtException mlne) {
            System.out.println(mlne.toString());
        } finally {
            System.out.println("Henning ist doof!");
        }
    }

    public boolean isKofferraumKlappeOffen() {
        return kofferraumKlappeOffen;
    }

    public void setKofferraumKlappeOffen(boolean kofferraumKlappeOffen) {
        this.kofferraumKlappeOffen = kofferraumKlappeOffen;
    }
    
}
