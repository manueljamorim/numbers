import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterTestG extends Specification{
    def "SORTER"(){
        given:
        def list = Arrays.asList(1,2,4,2,5,5,7,3,4)
        def sorter = new ListSorter()

        when:
        def result = sorter.sort(list)

        then:
        result == Arrays.asList(1, 2, 2, 3,4,4,5,5,7)

    }

}
