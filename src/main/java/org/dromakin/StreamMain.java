/*
 * File:     StreamMain
 * Package:  org.dromakin
 * Project:  netology_stream_api_homework_1
 *
 * Created by dromakin as 09.01.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.01.09
 * copyright - Echelon Inc. 2023
 */

package org.dromakin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

    private static final Logger logger = LogManager.getLogger(StreamMain.class);

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        logger.info("Get stream");
        Stream<Integer> stream = intList.stream();

        StringBuilder msg = new StringBuilder();
        msg
                .append("Filtering > 0 numbers => ")
                .append("Filtering % 2 == 0 numbers => ")
                .append("Sorting natural order => ")
                .append("sout");

        logger.info(msg);
        logger.info("Result:");
        stream
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(logger::info);

    }

}
