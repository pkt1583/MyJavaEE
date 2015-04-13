package com.pkt.algo;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by pankaj on 08-04-2015.
 */
public class InsertionSortTest extends TestCase {
    @Test
    public void testInsertionSort(){
        Integer args[]={5,2,4,0,8,6,1,3};
        InsertionSort<Integer> integerInsertionSort=new InsertionSort<>();
        Integer[] sorted= integerInsertionSort.sort(args);
        for(Integer o:sorted){
            System.out.println(o);
        }
    }

}