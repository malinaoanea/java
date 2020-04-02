public class Exemplul1 {
    public static void main(String[] args) {
        Washable washable;

        washable = new Car();//referinta de tip washable
        washable.wash();

        Washable dog = new Dog();
        if( dog.needsWashing() ) {
            dog.wash();
        }

    }
}
