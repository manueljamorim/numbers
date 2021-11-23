package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    List<Integer> list;
    @BeforeEach
    public void helper(){
        list = Arrays.asList(1,2,4,2);
    }


    @Test
    public void sort() {
        List<Integer> expected = Arrays.asList(1, 2, 2, 4);
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort_coverage() {
        list = Arrays.asList(1,2,4,2,5,5,7,3,4);
        List<Integer> expected = Arrays.asList(1, 2, 2, 3,4,4,5,5,7);
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }


}
