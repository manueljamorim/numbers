import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import org.junit.jupiter.api.Assertions
import spock.lang.Specification

class ListDeduplicatorTestG extends  Specification{

    def "DEDUPLICATE"(){
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def sorter = Mock(GenericListSorter)
        sorter.sort(_) >> Arrays.asList(1, 2, 2, 4,5)
        def deduplicator = new ListDeduplicator(sorter)


        when:
        def result = deduplicator.deduplicate(list)

        then:
        result == Arrays.asList(1,2,4,5)

    }



}
