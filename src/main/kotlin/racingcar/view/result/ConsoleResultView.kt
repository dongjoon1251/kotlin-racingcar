package racingcar.view.result

import racingcar.domain.Car
import racingcar.domain.Cars
import java.util.stream.Collectors.joining

class ConsoleResultView : ResultView {
    companion object {
        private const val CAR_POSITION_CHARACTER = "-"
        private const val RESULT_TITLE = "실행 결과"
        private const val WINNERS_JOINING_DELIMITER = ", "
    }

    override fun showTitle() {
        println("\n" + RESULT_TITLE)
    }

    override fun showStatuses(cars: Cars) {
        cars.getCars().forEach { car -> showStatus(car) }
        println()
    }

    private fun showStatus(car: Car) {
        print("%5s : ".format(car.name.getValue()))
        for (index in (1..car.position)) {
            print(CAR_POSITION_CHARACTER)
        }
        println()
    }

    override fun showWinners(cars: Cars) {
        val winners = cars.getWinners()
            .stream()
            .map { it.name.getValue() }
            .collect(joining(WINNERS_JOINING_DELIMITER))

        println("$winners 가 최종 우승하였습니다.")
    }
}
