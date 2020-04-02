public class exemplul2 {
    public  static void washIfPossible(Washable washable) {
        if( washable.needsWashing() ) {
            washable.wash();
        }
    }

    public static void main(String[] args) {

    }
}
