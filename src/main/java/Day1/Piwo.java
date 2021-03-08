package Day1;

public  class Piwo {
    private int wiekDozwolony = 18;
//    private double moc;
//    private String nazwa;
    protected double moc;
    protected String nazwa;

    public boolean czyPiwo(int wiek) {
        if (wiek >= wiekDozwolony) {
            return true;
        } else {
            return false;
        }
    }

    public String czyPiwoTekst(int wiek) {
        if (wiek >= wiekDozwolony) {
            return "Może pić piwo "+nazwa+" o mocy "+moc+"%";
        } else {
            return "Nie może pić piwa "+nazwa+" o mocy "+moc+"%";
        }
    }

    public Piwo(String nazwa, double moc){ // konstruktor
        this.nazwa = nazwa;
        this.moc = moc;
    }

    @Override
    public String toString() {  // używa jej do get(1)
        return "Piwo{" +
                "moc=" + moc +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}


