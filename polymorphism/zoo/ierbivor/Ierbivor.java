package polymorphism.zoo.ierbivor;

import polymorphism.zoo.Animal;

public abstract class Ierbivor extends Animal {

    public Ierbivor(String nume, int varsta) {
        super(nume, varsta);
        this.tipHrana = "vegetatie";
    }

    public void seHraneste() {
        System.out.println("Aceasta este " + this.toString() );
    }
}
