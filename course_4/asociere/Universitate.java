package asociere;

import java.util.Arrays;

public class Universitate {
    private String nume;
    private Departament[] departamente;

    public Universitate(String nume, Departament[] departamente) {
        this.nume = nume;
        this.departamente = (Departament[]) Arrays.copyOf(departamente, departamente.length);
    }

    public String toString() {
        String var10000 = this.nume;
        return "Universitate [ nume " + var10000 + ", departamente " + Arrays.toString(this.departamente) + ")";
    }
}
