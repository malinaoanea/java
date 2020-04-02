import java.lang.reflect.Array;
import java.util.Arrays;

public class MovieTest {
    public static void main(String[] args) {
        Movie[] movies = { new Movie("Breaking Bad", 2014, 9.4), new Movie("Star wars", 1997, 8.8),
        new Movie(("Die Hard"), 1990, 8), new Movie("Terminator", 1994, 75)};

        System.out.println(Arrays.toString(movies));
        Arrays.sort(movies);
        System.out.println(Arrays.toString(movies));
    }
}
