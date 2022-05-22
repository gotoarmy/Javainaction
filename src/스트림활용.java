import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class 스트림활용 {
    public static void main(String... args) {
        List<dish> dishes = Arrays.asList(
                new dish(mealType.vegetarian, 150),
                new dish(mealType.meet, 250),
                new dish(mealType.meet, 350),
                new dish(mealType.vegetarian, 200),
                new dish(mealType.vegetarian, 100),
                new dish(mealType.vegetarian, 150));
        List<dish> copy =dishes;
        List<dish> veget = dishes.
                stream()
                .filter(dish::isveget)
                .distinct()
                .collect(toList());
        Collections.sort(copy, new Comparator<dish>() {
            @Override
            public int compare(dish o1, dish o2) {
                return o1.calories -o2.calories;
            }
        }); //컬렉션 소트
        //정렬된 리스트에서 더빠른 연산을 위한 takewhile
        int bs =2;


    }
}
enum mealType{
    /** 채식**/ vegetarian,
    /** 육식**/ meet;
}
class dish{
    mealType mealType;
    int calories=0;
    public dish(mealType a,int calories)
    {
        this.mealType =a;
        this.calories =calories;
    }
    public boolean isveget()
    {
        if (this.mealType == mealType.vegetarian) return true;
        else return false;
    }

}
