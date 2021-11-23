package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list;
    @BeforeEach
    public void helper(){
        list = Arrays.asList(1,2,4,2);
    }


    @Test
    public void deduplicate() {
        List<Integer> expected = Arrays.asList(1,2,4);

        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 2, 4);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_mockito() {
        List<Integer> expected = Arrays.asList(1,2,4);

        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }

}
