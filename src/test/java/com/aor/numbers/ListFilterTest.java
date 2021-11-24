package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    List<Integer> list;
    @BeforeEach
    public void helper(){
        list = Arrays.asList(-1,2,4,-2,5);
    }

    @Test
    public void positives() {
        List<Integer> expected = Arrays.asList(2,4,5);
        ListFilterer new_filterer = new ListFilterer(new PositiveFilter());
        Assertions.assertEquals(expected, new_filterer.filter(list));
    }

    @Test
    public void divisible() {
        List<Integer> expected = Arrays.asList(2,4,-2);
        ListFilterer new_filterer = new ListFilterer(new DivisibleByFilter(2));
        Assertions.assertEquals(expected, new_filterer.filter(list));
    }

    @Test
    public void filtererTestTrue() {
        List<Integer> expected = list;
        GenericListFilter stub = Mockito.mock(GenericListFilter.class);
        Mockito.when(stub.accept(Mockito.anyInt())).thenReturn(true);

        ListFilterer new_filterer = new ListFilterer(stub);
        Assertions.assertEquals(expected, new_filterer.filter(list));
    }

    @Test
    public void filtererTestFalse() {
        List<Integer> expected = new ArrayList<>();

        GenericListFilter stub = Mockito.mock(GenericListFilter.class);
        Mockito.when(stub.accept(Mockito.anyInt())).thenReturn(false);

        ListFilterer new_filterer = new ListFilterer(stub);
        Assertions.assertEquals(expected, new_filterer.filter(list));
    }


}
