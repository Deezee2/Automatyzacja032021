package Day1.Pkg1;

public class Class1 {
    public int publiczne;
    protected int protektowana;
    int zadna;
    private int prywatna;

    public void metoda(){
        publiczne=1;
        protektowana=1;
        zadna=1;
        prywatna=1;
    }

    public int getPubliczne() {
        return publiczne;
    }

    public int getProtektowana() {
        return protektowana;
    }

    public int getZadna() {
        return zadna;
    }

    public int getPrywatna() {
        return prywatna;
    }

    public void setPubliczne(int publiczne) {
        this.publiczne = publiczne;
    }

    public void setProtektowana(int protektowana) {
        this.protektowana = protektowana;
    }

    public void setZadna(int zadna) {
        this.zadna = zadna;
    }

    public void setPrywatna(int prywatna) {
        this.prywatna = prywatna;
    }
}

//Class2 - ten sam pkg, dziedziczy po 1 - do których zmiennych dostęp?
//Class3 - ten sam pkg, nie dziedziczy, tylko tworzy obiekt klasy 1 - do których zmiennych dostęp?
//Class4 - inny pkg, dziedziczy po 1 - do których pól dostęp?
//Class5 - inny pkg, nie dziedziczy, tylko tworzy obiekt klasy 1 - do których pól dostęp?

