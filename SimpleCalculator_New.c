#include <stdio.h>

int main() {
    char operator;        // Variable to store the operator
    double num1, num2;   // Variables to store the two numbers
    double result;       // Variable to store the result of the operation

    // Prompt the user for an operator
    printf("Enter an operator (+, -, *, /): ");
    scanf("%c", &operator); // Read the operator from user input

    // Prompt the user for two numbers
    printf("Enter two numbers: ");
    scanf("%lf %lf", &num1, &num2); // Read the two numbers

    // Perform the calculation based on the operator
    switch (operator) {
        case '+':
            result = num1 + num2; // Addition
            printf("%.2lf + %.2lf = %.2lf\n", num1, num2, result);
            break;
        case '-':
            result = num1 - num2; // Subtraction
            printf("%.2lf - %.2lf = %.2lf\n", num1, num2, result);
            break;
        case '*':
            result = num1 * num2; // Multiplication
            printf("%.2lf * %.2lf = %.2lf\n", num1, num2, result);
            break;
        case '/':
            if (num2 != 0) { // Check for division by zero
                result = num1 / num2; // Division
                printf("%.2lf / %.2lf = %.2lf\n", num1, num2, result);
            } else {
                printf("Error! Division by zero.\n"); // Error message for zero division
            }
            break;
        default:
            printf("Invalid operator.\n"); // Error message for invalid operator
            break;
    }

    return 0; // End of the program
}

