public interface Washable {
    //public static final = implicit
    int impermebil = 0;
    int resistant = 0;
    int fragile = 0;
    int exoplosive = 0;

    //public abstract
    void wash();

    //public
    default boolean needsWashing() {
        System.out.println("by deafult wash everything");
        return true;
    }
}
