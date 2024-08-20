package com.example.calculator

// Enum class for operations
enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}
// Calculator class with properties, constructor, and a method to perform operations
class Calculator(private val operand1: Double, private val operand2: Double) {
    // Function to perform operations based on the provided enum value
    fun performOperation(operation: Operation): Double {
        return when (operation) {
            Operation.ADD -> operand1 + operand2
            Operation.SUBTRACT -> operand1 - operand2
            Operation.MULTIPLY -> operand1 * operand2
            Operation.DIVIDE -> {
                if (operand2 != 0.0) {
                    operand1 / operand2
                } else {
                    throw IllegalArgumentException("Division by zero is not allowed")
                }
            }
        }
    }
}
