/*
 * File:     QuickSort
 * Package:  org.dromakin
 * Project:  netology_stream_api_homework_1
 *
 * Created by dromakin as 09.01.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.01.09
 */

package org.dromakin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    private static final Logger logger = LogManager.getLogger(QuickSort.class);

    /**
     * This method sort the input ArrayList using quick sort algorithm.
     * @param input the ArrayList of integers.
     * @return sorted ArrayList of integers.
     */
    public List<Integer> quicksort(List<Integer> input){

        logger.debug("Quicksort started...");

        if(input.size() <= 1){
            return input;
        }

        int middle = (int) Math.ceil((double)input.size() / 2);
        int pivot = input.get(middle);

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i) <= pivot){
                if(i == middle){
                    continue;
                }
                less.add(input.get(i));
            }
            else{
                greater.add(input.get(i));
            }
        }

        return concatenate(quicksort(less), pivot, quicksort(greater));
    }

    /**
     * Join the less array, pivot integer, and greater array
     * to single array.
     * @param less integer ArrayList with values less than pivot.
     * @param pivot the pivot integer.
     * @param greater integer ArrayList with values greater than pivot.
     * @return the integer ArrayList after join.
     */
    private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){

        List<Integer> list = new ArrayList<>(less);

        list.add(pivot);

        list.addAll(greater);

        return list;
    }

    /**
     * This method generate a ArrayList with length n containing random integers.
     * @param size the length of the ArrayList to generate.
     * @return ArrayList of random integers with length n.
     */
    private List<Integer> generateRandomNumbers(int size) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            intList.add(ThreadLocalRandom.current().nextInt(-100, 100));
        }

        return intList;
    }


    /**
     * @return ArrayList of random integers with random length.
     */
    private List<Integer> generateRandomNumbers() {
        final int size = ThreadLocalRandom.current().nextInt(5, 30);
        return generateRandomNumbers(size);
    }


    public static void main(String[] args) {
        QuickSort app = new QuickSort();

        // Generate an integer array of random length
        List<Integer> input = app.generateRandomNumbers();

        // Before sort
        logger.info(input);

        // After sort
        logger.info(app.quicksort(input));

    }


}
