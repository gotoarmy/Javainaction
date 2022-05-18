import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<FilteringApples.Apple> inventory = Arrays.asList(
                new FilteringApples.Apple(80, "green"),
                new FilteringApples.Apple(155, "green"),
                new FilteringApples.Apple(120, "red")
        );
        문자열동작파라미터 print = new 문자열동작파라미터();
        print.howPrint(inventory,new printcolor());
        print.howPrint(inventory,new printweight());

    }

}
