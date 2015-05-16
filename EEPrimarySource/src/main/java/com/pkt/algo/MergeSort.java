package com.pkt.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 13-04-2015.
 */
public class MergeSort {
    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(1);
        integers.add(6);
        integers.add(4);
        integers.add(5);
        integers.add(10);
        MergeSort mergeSort=new MergeSort();
        List<Integer> sortedElements= mergeSort.sort(integers);
    }

    private List<Integer> sort(List<Integer> integers) {
        mergeSort(integers, new ArrayList<Integer>(), 0, integers.size());
        return null;
    }

    private Integer mergeSort(List<Integer> integers, ArrayList<Integer> tempIntegerList, int i, int size) {
        if(i<size){
            int center =(i+size)/2;
            merge(integers, tempIntegerList, mergeSort(integers, tempIntegerList, i, center),mergeSort(integers,tempIntegerList,center+1,size));

        }else {
            return i;
        }
        return null;
    }

    private void merge(List<Integer> integers, ArrayList<Integer> tempIntegerList, int i, int size) {
        System.out.println("Will be sorting [ "+integers.get(i)+" ] to [ "+integers.get(size)+" ] ");

    }
}
