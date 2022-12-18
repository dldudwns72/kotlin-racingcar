package carracing.domain

class Cars(cars: List<Car>) : List<Car> by cars {

    init {
        require(cars.size > MIN_CAR_SIZE) { "최소 2대 이상의 자동차를 입력해주세요." }
    }

    companion object {
        private const val MIN_CAR_SIZE = 1
    }
}
