package polymorphism.zoo;

public class Zoo {
    private final int nrMaxAnimale;
    Animal[] animaleZoo;
    private int indexCurrent;

    public Zoo(int nrMaxAnimale) {
        this.nrMaxAnimale = nrMaxAnimale;
        this.animaleZoo = new Animal[nrMaxAnimale];
    }

    public void adaugaAnimal(Animal animal) {
        if (indexCurrent < animaleZoo.length ) {
            animaleZoo[indexCurrent] = animal;
            System.out.println("Animal adaugat " + animal.getClass()  + " la pozitia " + indexCurrent++);
        }
        else {
            throw new RuntimeException("Nu ati introdus un numar intreg pozitiv");
        }
    }


}
