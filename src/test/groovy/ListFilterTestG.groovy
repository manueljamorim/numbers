import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.GenericListFilter
import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListFilterer
import com.aor.numbers.PositiveFilter
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import spock.lang.Specification

class ListFilterTestG extends Specification{
    def "POSITIVES"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filterer = new ListFilterer(new PositiveFilter())

        when:
        def result = filterer.filter(list)

        then:
        result == Arrays.asList(2,4,5)
    }

    def "DIVISIBLE"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filterer = new ListFilterer(new DivisibleByFilter(2))

        when:
        def result = filterer.filter(list)

        then:
        result == Arrays.asList(2,4,-2)
    }


    def "Filterer Test --> True"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filter_mock = Mock(GenericListFilter)
        filter_mock.accept(_) >> true
        def filterer = new ListFilterer(filter_mock)

        when:
        def result = filterer.filter(list)

        then:
        result == list
    }

    def "Filterer Test --> False"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filter_mock = Mock(GenericListFilter)
        filter_mock.accept(_) >> false
        def filterer = new ListFilterer(filter_mock)

        when:
        def result = filterer.filter(list)

        then:
        result == Arrays.asList()
    }

}
