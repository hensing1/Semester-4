package AbstraktUndCo;

public abstract class Landfahrzeug extends Fortbewegungsmittel{
    private Motor motor;
    private int kilometerstand;
    
    public Landfahrzeug(int baujahr) {
        super(baujahr);
        this.motor = new Motor(false, 6, 90);
    }
    
    public Landfahrzeug(int baujahr, boolean isDiesel, int anzahlZylinder, int ps) {
        super (baujahr);
        this.motor = new Motor(isDiesel, anzahlZylinder, ps);
    }

    public Motor getMotor() {
        return motor;
    }
    
    class Motor {
        private boolean läuft, isDiesel, kaputt;
        private int anzahlZylinder, ps, revs;
        
        public Motor(boolean isDiesel, int anzahlZylinder, int ps) {
            this.läuft = false;
            this.isDiesel = isDiesel;
            this.kaputt = true; //tja 
            this.anzahlZylinder = anzahlZylinder;
            this.ps = ps;
            this.revs = 0;
        }
        
        public void mehrBrumm() throws MotorLäuftNichtException, MotorKaputtException{
            if (!this.läuft)
                throw new MotorLäuftNichtException();
            
            if (this.kaputt)
                throw new MotorKaputtException();
            
            revs += 50;
            if (revs > 2000) {
                this.kaputt = true;
                throw new MotorKaputtException();
            }
        }
        
        public void wenigerBrumm() throws MotorLäuftNichtException, MotorKaputtException {
            if (!this.läuft)
                throw new MotorLäuftNichtException();
            
            if (this.kaputt)
                throw new MotorKaputtException();
            
            revs = Math.max(revs - 50, 0);
        }
        
        public void machKaputt() {
            this.kaputt = true;
        }
        
        public void reparieren() {
            this.kaputt = false;
        }
        
        public void anschalten() {
            this.läuft = true;
        }
        
        public void ausschalten() {
            this.läuft = false;
        }

        public boolean läuft() {
            return läuft;
        }

        public boolean isDiesel() {
            return isDiesel;
        }

        public boolean isKaputt() {
            return kaputt;
        }

        public int getAnzahlZylinder() {
            return anzahlZylinder;
        }

        public int getPs() {
            return ps;
        }

        public int getRevs() {
            return revs;
        }
        
        public class MotorLäuftNichtException extends Exception {
            public MotorLäuftNichtException() {
                super();
            }
            
            public MotorLäuftNichtException(String message) {
                super(message);
            }
        }
        
        public class MotorKaputtException extends Exception {
            public MotorKaputtException() {
                super("KAPUTT!!!!!");
            }
        }
    }
}
