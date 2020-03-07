package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

   private T[] input;
   private ArrayList<T> array;

    public ArrayUtility(T[] array) {
        this.array = new ArrayList<T>(Arrays.asList(array));
        this.input = array;
    }

    public T[] removeValue(T valueToRemove) {

        while (this.array.contains(valueToRemove)) {
            this.array.remove(valueToRemove);
        }

        return this.array.toArray(Arrays.copyOf(this.input, this.array.size()));
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        int count = 0;
        for (T obj : this.array) {
            if (obj.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }


    public int countOccurrences(T item) {

        int count = 0;
        for (T obj : this.array) {
            if (item.equals(obj)) {
                count++;
            }
        }
        return count;

    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        this.array.addAll(new ArrayList<T>(Arrays.asList(arrayToMerge)));
        return countOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        this.array.addAll(new ArrayList<T>(Arrays.asList(arrayToMerge)));
        T mostCommon = this.array.get(0);
        int count = 0;
        HashSet<T> set = new HashSet<T>(this.array);
        for (T item : set) {
            int thisItemCount = countOccurrences(item);
            if (thisItemCount > count) {
                count = thisItemCount;
                mostCommon = item;
            }
        }
        return mostCommon;
    }


}
