public class ex3 {
    public static void clean(Washable washable) {
        washable.wash();
    }

    public static void main(String[] args) {
        Cup cup = new Cup();
        clean(cup);

        Washable car = new Car();
        clean(car);

        Washable washableWindow = new Washable() {
            @Override
            public void wash() {
                System.out.println("washing annonymous object");
            }
        };

        washableWindow.wash();

        Washable n1 = new Car() {
            @Override
            public void wash() {
                System.out.println("new car wah");
            }
        };
        n1.wash();
    }
}
