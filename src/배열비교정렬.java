import java.lang.Comparable;
import java.util.Arrays; //퀵소트 사용하기 위해 import

class 배열비교정렬 implements Comparable<배열비교정렬> {
    String name; //이름
    int id; //학번
    double score; //학점
    public 배열비교정렬(String name, int id, double score){
        this.name = name;
        this.id = id;
        this.score = score;
    }
    public String toString(){ //출력용 toString오버라이드
        return "이름: "+name+", 학번: "+id+", 학점: "+score;
    }
    /* 기본 정렬 기준: 학번 오름차순 */
    public int compareTo(배열비교정렬 another배열비교정렬) {
        return name.compareTo(another배열비교정렬.name);
    }

}

class main {
    public static void main(String[] args) {
        배열비교정렬 배열비교정렬[] = new 배열비교정렬[5];
        //순서대로 "이름", 학번, 학점
        배열비교정렬[0] = new 배열비교정렬("Dave", 20120001, 4.2);
        배열비교정렬[1] = new 배열비교정렬("Amie", 20150001, 4.5);
        배열비교정렬[2] = new 배열비교정렬("Emma", 20110001, 3.5);
        배열비교정렬[3] = new 배열비교정렬("Brad", 20130001, 2.8);
        배열비교정렬[4] = new 배열비교정렬("Cara", 20140001, 4.2);
        Arrays.sort(배열비교정렬); //퀵소트
        for(int i=0;i<5;i++) //toString에 정의된 형식으로 출력
            System.out.println(배열비교정렬[i]);
    }
}
