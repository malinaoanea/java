package polymorphism.zoo;

import polymorphism.zoo.carnivor.Leu;
import polymorphism.zoo.carnivor.Pisica;
import polymorphism.zoo.ierbivor.Cal;
import polymorphism.zoo.ierbivor.Elefant;
import polymorphism.zoo.omnivor.Caine;
import polymorphism.zoo.omnivor.Urs;

import java.util.Scanner;

public class ZooTest {
    public static void main( String[] args) {
        //Integer nrAnimaleZoo = Integer.valueOf(args[0]);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Precizati nr max de animle ce pot fi gazduite la zoo: ");
        int nrAnimaleZoo = scanner.nextInt();
        scanner.close();

        Zoo zooBucureesti = new Zoo(nrAnimaleZoo);
        adaugaAnimaleLaZoo(zooBucureesti);

        for( int i = 0 ; i < zooBucureesti.animaleZoo.length; i++) {
            Animal animal = zooBucureesti.animaleZoo[i];
            animal.afiseazaDetalii();

        }
    }

    public static void adaugaAnimaleLaZoo(Zoo zoo) {
        Leu leu = new Leu("simba", 7);
        zoo.adaugaAnimal(leu);
        Elefant elefant = new Elefant("eli", 10);
        zoo.adaugaAnimal(elefant);
        Urs urs = new Urs("fran", 4);
        zoo.adaugaAnimal(urs);
        Pisica pisica = new Pisica("tom", 4);
        zoo.adaugaAnimal(pisica);
        Caine caine = new Caine("toto", 3);
        zoo.adaugaAnimal(caine);
        Cal cal = new Cal("thunder", 5);
        zoo.adaugaAnimal(cal);

    }
}
