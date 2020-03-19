package polymorphism.zoo.carnivor;

public class Pisica extends Carnivor {
    public Pisica(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "miau";
    }

    @Override
    public void scoateSunet() {
        System.out.println("Pisica miauna");
    }
}
