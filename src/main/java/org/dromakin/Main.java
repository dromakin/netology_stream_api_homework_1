package org.dromakin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        QuickSort app = new QuickSort();

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));

        logger.info("Original list");
        logger.info(intList);

        logger.info("1. Filtering > 0 numbers");
        intList.removeIf(x -> (x <= 0));
        logger.info(intList);

        logger.info("2. Filtering % 2 == 0 numbers");
        intList.removeIf(x -> (x % 2 != 0));
        logger.info(intList);

        logger.info("3. Sorting natural order numbers and sout");
        logger.info(app.quicksort(intList));
    }
}