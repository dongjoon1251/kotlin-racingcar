package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest(name = "[{index}]. expr = {argumentsWithNames}")
    @ValueSource(strings = ["1 + 2 + 3 + 4", "2 + 3 * 4 / 2", "10 - 1 + 1 / 2 * 2"])
    fun `사칙연산을 한다`(input: String) {
        // given
        val validator = Validator()
        val calculator = Calculator(operator = Operator())
        validator.validate(input)

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(10)
    }
}
