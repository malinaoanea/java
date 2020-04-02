package asociere;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Profesor profesorPrincipalMate = new Profesor(4, "Popescu");
        Profesor profesorSecundarMate = new Profesor(1, "Ionescu");
        Profesor profesorInfo = new Profesor(5, "Angel");
        Profesor profesorMateSiInfo = new Profesor(6, "Petrescu");
        Profesor profesorInfoSiMate = new Profesor(2, "Andrei");
        Departament departamentInfo = new Departament("Informatică");
        departamentInfo.setProfesori(new Profesor[]{profesorInfo, profesorInfoSiMate, profesorMateSiInfo});
        Departament departamentMate = new Departament("Matematică");
        departamentMate.setProfesori(new Profesor[]{profesorPrincipalMate, profesorSecundarMate, profesorMateSiInfo, profesorInfoSiMate});
        Departament[] departamente = new Departament[]{departamentInfo, departamentMate};
        Universitate universitate = new Universitate("Universitatea din București", departamente);
        System.out.println(universitate);
    }
}
