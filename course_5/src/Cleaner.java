//public class Cleaner {
//    public static void  cleanObject(Object object) {
//        if( object instanceof Car ) {
//            ((Car) object).wash();
//        }
//
//        else if( object instanceof Window ) {
//            ((Window) object).wash();
//        }
//
//        else if( object instanceof  Cup ) {
//            ((Cup) object).wash();
//        }
//
//        else if( object instanceof Dog ){
//            ((Dog) object).wash();
//        }
//        else {
//            throw new RuntimeException("unsuported object type");
//        }
//    }
//
//    public static void clean(WashableObject washableObject) {
//        washableObject.wash();
//        //inlocuieste toate liniile de cod de dinainte
//
//    }
//
//    public  static void main(String[] args) {
//        Dog dog = new Dog();
//        //cleanObject(dog);
//        clean(dog);
//
//        Window window = new Window();
//        //cleanObject(window);
//        clean(window);
//
//        Car car = new Car();
//        //cleanObject(car);
//        clean(car);
//
//        Cup cup = new Cup();
//        //cleanObject(cup);
//        clean(cup);
//
//        String unknownTupe = "unkown type";
//        //cleanObject(unknownTupe);
//        //clean(unknownTupe);
//    }
//}
