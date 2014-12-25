package by.minsk.wasilus;

/**
 * Created by Witold on 25.12.2014.
 */
public class Main {
    public static void main(String[] args) {
    ArrayStringIterable arrayStringIterable=new ArrayStringIterable(new String[]{"0","1","2","3"});
        if (arrayStringIterable.iterator().hasNext()){
            System.out.println("OK");
        }else {
            System.out.println("NO");
        }

        for (String rez:arrayStringIterable){
            System.out.println(rez);

        }

    }
}
