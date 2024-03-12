import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayTeste = {6,3,7,9,2,1,4,8,5};
        Integer[] arrayOrdenado = Quicksort.sort(arrayTeste);
        Arrays.stream(arrayOrdenado).forEach(n -> System.out.print(n + " "));
    }
}
