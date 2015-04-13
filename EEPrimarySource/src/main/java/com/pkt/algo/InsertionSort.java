package com.pkt.algo;

/**
 * Created by pankaj on 08-04-2015.
 */
public class InsertionSort<T extends Comparable> {


    public T[] sort(T[] args) {
        for(int i=2;i<args.length;i++){
            T key=args[i];
            int j=i-1;
            while (j>0 && key.compareTo(args[j])>0){
                    T temp=args[j+1];
                    args[j+1]=args[j];
                    args[j]=temp;
                j--;
            }
        }
        return args;
    }
}
