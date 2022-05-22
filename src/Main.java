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
        //동작원리 전제조건:임플리먼트 후 클래스네 매서드 구현
        //인자에 객체생성, howprint내의 string format.printStr부분에
        //Printcolor,printweight가 구현한 매서드가 들어가서 결과를 호출

    }

}
