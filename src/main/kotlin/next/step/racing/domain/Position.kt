package next.step.racing.domain

data class Position(val x: Int) {
    fun move(dx: Int): Position = Position(x + dx)
}
