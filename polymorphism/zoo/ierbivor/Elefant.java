package polymorphism.zoo.ierbivor;

public class Elefant extends Ierbivor {
    public  Elefant( String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "";
    }

    @Override
    public void scoateSunet() {

    }
}
