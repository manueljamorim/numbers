import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import spock.lang.Specification

class ListAggregatorTestG extends Specification {
    def "SUM"() {
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def aggregator = new ListAggregator()

        when:
        def sum = aggregator.sum(list)

        then:
        sum == 14
    }

    def "MAX"() {
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def aggregator = new ListAggregator()

        when:
        def max = aggregator.max(list)

        then:
        max == 5
    }

    def "MIN"() {
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def aggregator = new ListAggregator()

        when:
        def min = aggregator.min(list)

        then:
        min == 1
    }

    def "DISTINCT"(){
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2,5)) >> Arrays.asList(1, 2, 4,5)
        def aggregator = new ListAggregator()

        when:
        def result = aggregator.distinct(list,deduplicator)

        then:
        result == 4

    }


}
