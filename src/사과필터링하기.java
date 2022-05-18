import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 사과필터링하기 {
    //메인매서드 사과생성
    public static void main(String... args) {
        List<사과> inventory = Arrays.asList(
                new 사과("스폰지밥", 10, "blue"),
                new 사과("뚱이", 20, "green"),
                new 사과("징징이", 30, "red")
        );
        사과필터링하기 필터 =new 사과필터링하기();
        List<사과> 팔수있는사과 = 필터.필터링(inventory,사과필터링하기::무거운사과인가);
        System.out.print(팔수있는사과);
    }
    //사과거르기 메서드
    public List<사과> 필터링(List<사과> inventory, Predicate<사과> p)
    {
        List<사과> 팔수있는사과=new ArrayList<사과>();
        for(사과 apple :inventory)
        {
            if(p.Test(apple))
            {
                팔수있는사과.add(apple);
            }
        }
                return 팔수있는사과;
    }
    interface Predicate<사과>{
        boolean Test(사과 t);
    }
    //1.프리디케이트 인자를받음 o
    //2.프리디케이트 인터페이스 구현 {불리언}자동으로 만들어짐 o
    //3.인자로 불리언매서드를 받음 o
    //4.불리언매서드를 구현 o -->정적인이유 여기서만 쓸꺼니까

    public static boolean 무거운사과인가(사과 apple)
    {
        return apple.getweight()>10;
    }
    public static boolean 청록색인가(사과 사과)
    {
        return "녹"==사과.getcolor();
    }
//리턴값이 29번 줄을 만족하면 21번줄로들어가서 불리언으로들어감
//조건이 맞다면 팔수있는사과에 리스트로 들어감
}
 class 사과
{
    String 이름 ="";
    int weight =0;
    String color="";

    public 사과(String 이름, int weight,String 색) {
        this.이름 = 이름;
        this.weight = weight;
        this.color = 색;
    }

    public String getcolor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public String get이름() {
        return 이름;
    }

    public void set이름(String 이름) {
        this.이름 = 이름;
    }

    public int getweight() {
        return weight;
    }

    public void setweight(int weight) {
        this.weight = weight;
    }
   @SuppressWarnings("boxing")
   @Override
   public String toString() {
        return String.format("apple{color='%s', weight=%d}", color, weight);
    }  //요고 왜넣는거
}
