package study.carracing

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Racing
import carracing.domain.Winners
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTest {

    @Test
    fun `단일 우승자 반환 테스트`() {
        val car1 = Car("lee", moveStrategy = StandardStrategy(2))
        val car2 = Car("kim", moveStrategy = StandardStrategy(3))
        val car3 = Car("park", moveStrategy = StandardStrategy(6))
        val cars = Cars(listOf(car1, car2, car3))
        val winners = Winners(Racing(cars).race()).getWinners()

        assertThat(winners).isEqualTo("park")
    }

    @Test
    fun `다중 우승자 반환 테스트`() {
        val car1 = Car("lee", moveStrategy = StandardStrategy(3))
        val car2 = Car("kim", moveStrategy = StandardStrategy(5))
        val car3 = Car("park", moveStrategy = StandardStrategy(6))
        val cars = Cars(listOf(car1, car2, car3))
        val winners = Winners(Racing(cars).race()).getWinners()
        assertThat(winners).isEqualTo("kim,park")
    }
}
