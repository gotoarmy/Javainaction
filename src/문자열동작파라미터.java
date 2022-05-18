import java.util.List;

public class 문자열동작파라미터 {
    public void howPrint(List<FilteringApples.Apple> inven, Stringformat stringformat)
    {
        for(FilteringApples.Apple APPLE :inven)
        {
            String answer=stringformat.printStr(APPLE);
            System.out.println(answer);
        }


    }
}
class printcolor implements Stringformat
{

    @Override
    public String printStr(FilteringApples.Apple apple) {
        return "applecolor:"+apple.getColor();
    }
}
class  printweight implements  Stringformat
{

    @Override
    public String printStr(FilteringApples.Apple apple) {
        return "appleweigh:"+apple.getWeight();
    }
}

