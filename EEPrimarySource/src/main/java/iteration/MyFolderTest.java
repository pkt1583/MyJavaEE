package iteration;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by pankaj on 16-03-2015.
 */
public class MyFolderTest {
    public static void main(String[] args) {
        Queue<Character> myqueue=new PriorityQueue<>();
        for(int i=0;i<1000000;i++) {
            myqueue.add('p');
            myqueue.add(Character.valueOf((char) i));
            myqueue.add('q');
            myqueue.add('r');
        }
        MyFolder<Character,Integer> myFolder=new MyFolder<>();
        Integer output=myFolder.fold(10, myqueue, new Function2<Character, Integer, Integer>() {
            @Override
            public Integer apply(Character s, Integer integer) {
                return integer+Integer.valueOf(s);
            }
        });
        System.out.println(output);
    }
}
