import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        List<dish> copy = dishes;
        List<dish> veget = dishes.
                stream()
                .filter(dish::isveget)
                .distinct()
                .collect(toList());
        Collections.sort(copy, new Comparator<dish>() {
            @Override
            public int compare(dish o1, dish o2) {
                return o1.calories - o2.calories;
            }
        });
        //정렬된 리스트에서 더빠른 연산을 위한 takewhile
        List<dish> slicedmenu = dishes
                .stream()
                .takeWhile(dish -> dish.getCalories() < 200)
                .collect(toList());
        /**정렬된 리스트에서 더빠른 연산을 위한 dropwhile*/
        slicedmenu.clear();
        slicedmenu = dishes
                .stream()
                .dropWhile(dish -> dish.getCalories() < 200)
                .collect(toList());
        //스트림 축소 ,limit(n) ->조건에 맞는 선착순 n개를 리스트에 넣음
        //요소건너뛰기, skip(n) ->조건에 맞는 n개를 스킵하고 그다음 조건에 맞는것부터 리스트에 집어넣음

        //함수를 인자로 받는 map 매서드 (람다와, 인터페이스 객체,매서드참조 가능)
        //맵은 데이터를 가공한다.
        List<Integer> numset = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> squars = numset.stream().map(mem -> mem * mem)
                .collect(toList());
        //숫자쌍만들기
        List<Integer> numset1 = Arrays.asList(1, 2, 3);
        List<Integer> numset2 = Arrays.asList(4, 5);
        List<int[]> mate = numset1.stream()
                .flatMap(i -> numset2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        //적어도 한요소가 일치하는가? anymatch
        if (veget.stream().anyMatch(dish::isveget)){
            System.out.println("한명은 존재함");
        }
        //모든 요소가 프리디케이트를 만족하나? allMatch
        if(veget.stream().allMatch(dish::isveget)) System.out.println("모두 채식주의자");
        //모든 요소가 프리디케이트를 만족하지 않나?
        if(veget.stream().noneMatch(dish::ismeeteater)) System
                .out.println("육식 주의자는 존재하지 않는다");
        //임의의 요소를 반환해서 육식주의자로 한명바꾸자
        Optional<dish> changer =veget.stream()
                .filter(dish::isveget)
                .findAny();
        changer.get().setMealType(mealType.meet);
        System.out.println(changer.get().getMealType());
        //첫번째 요소 찾기
        Optional<dish> first = veget.stream().findFirst();
        List<Integer> numbers =Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> first1 = numbers.stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst();
        //findfirst와 findany -->병렬요소에서는 첫번째를 찾기 어려우니 findany를 사용한다.

        //리듀싱연산 모든 스트림요소를 처리해서 값으로 도출하는 연산 ,폴드라 부르기도함
        //reduce (초기값,binaryoperator<T>,(T,T)-> T)
        List<Integer> numlist = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum =numlist.stream().reduce(0,(a,b)->a+b);
        // a b == (0,1) (1,2) (3,3) (6,4) (10,5) (15,6) ->21
        //초기값없는 버전은 optional<T>를반환
        Optional<Integer>suma =numlist.stream().reduce((a,b)->(a + b));
        //맵 리듀스 ,구글 웹검색에 활용한다고함
        int calo =dishes.stream()
                .map(dish::getCalories).reduce(0,(a,b)->a+b);
        int calosum =dishes.stream().mapToInt(dish::getCalories).sum();
        //객체 스트림 복원하기, 1.추출해서 스트림에 담은 상황 Tstream.boxed();로 스트림객체로 복원할수있음
        IntStream intStream =dishes.stream().mapToInt(dish::getCalories);
        Stream<Integer> boxedstream = intStream.boxed();
        //숫자범위와 관련된 매서드
        IntStream evennum =IntStream.rangeClosed(1,100).filter(n->n%2 ==0);//1,100포함o
        IntStream evennum2 =IntStream.range(1,100).filter(n->n%2 ==0);//1,100포함x
        System.out.println(evennum.count()+" "+evennum2.count());
        //값,배열,함수로 스트림만들기
        Stream<String> stream = Stream.of("Mordern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(s -> System.out.println(s));
        //배열
        int[] numberss = {2, 3, 5, 7, 11, 13};
        int sumas = Arrays.stream(numberss).sum();
        //함수로 스트림 stream.iterate,generate으로 무한 스트림을 만들 수 있다

        int bs =2;


    }
}
enum mealType{
    /** 채식**/ vegetarian,
    /** 육식**/ meet;
}
class dish{
    mealType mealType;

    public mealType getMealType() {
        return mealType;
    }

    public void setMealType(mealType mealType) {
        this.mealType = mealType;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

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
    public boolean ismeeteater()
    {
        if (this.mealType == mealType.meet) return true;
        else return false;
    }
}
