package AbstraktUndCo;

//wie geht ein default

public interface Test {
    int hi = 5; //das ding ist static final weil anders macht keinen sinn

    default int gibMichMeinInt() { //guck mal default
        return hi;
    }

    void troll(); // ASO MAN BRAUCHT DAS abstract KEYWORD GAR NICHT
                  // JAVA IST BEHINDERT

    static String nochMehrTroll() {
        //du willst mich doch verarschen
        //hier braucht man NICHT den default identifier

        return "P3N15";
    }

    // static void ohOh(); //und das hier geht NICHT!!!!
}
