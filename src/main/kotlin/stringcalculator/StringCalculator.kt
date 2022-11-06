package stringcalculator

class StringCalculator {

    private val DELIMITER = " "

    fun calculate(input: String): Int {
        inputValidate(input)

        val splitInput = input.split(DELIMITER)

        var total = splitInput.first().toInt()

        for (index in 1..splitInput.lastIndex step 2) {
            val sign = splitInput[index]
            val operand = splitInput[index + 1].toInt()

            val operation = Operation.of(sign)
            total = operation.calculate(total, operand)
        }

        return total
    }

    private fun inputValidate(input: String?) {
        require(!input.isNullOrBlank()) { "빈값이나 null은 허용되지 않습니다" }
    }
}
