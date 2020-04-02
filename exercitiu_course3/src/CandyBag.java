package candy;

public class CandyBag {
    private int maxBoxes;
    private CandyBox[] boxes;
    private int currentBox;

    public CandyBag(int maxBoxes){
        this.maxBoxes = maxBoxes;
        this.boxes = new CandyBox[maxBoxes];
        this.currentBox = 0;
    }

    public void addBox(CandyBox box) {
        if ( currentBox + 1 > maxBoxes ) {
            System.out.println("Too many boxes to be added!");
        }
        else {
            this.boxes[ this.currentBox++ ] = box;
        }
    }

    public static void main(String[] args) {
        CandyBag bag = new CandyBag(6);

        bag.addBox(new Heidi(2));
        bag.addBox(new Lindt(3, 4, 2));
        bag.addBox(new Heidi(0.5f));
        bag.addBox(new Milka(2, 1));
        bag.addBox(new Milka(3, 2));
        bag.addBox(new Lindt(3, 2, 4));

        for (CandyBox box : bag.boxes) {
            System.out.println(box);

            if (box instanceof Heidi) {
                ((Heidi)box).printHeidiDim();
            } else if (box instanceof Lindt) {
                ((Lindt)box).printLindtDim();
            } else if (box instanceof Milka) {
                ((Milka)box).PrintMilkaDim();
            }
        }

        System.out.println(bag.boxes[1].equals(bag.boxes[5]));

    }
}
