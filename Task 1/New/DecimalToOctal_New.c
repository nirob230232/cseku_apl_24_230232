#include<stdio.h>
#include<stdlib.h>

// Function prototype for converting a decimal number to an octal string
char *decimalToOctal(unsigned long decimal);

int main(void)
{
    unsigned long decimal; // Variable to store the input decimal number
    char *octal; // Pointer to store the converted octal string

    // Read a decimal number from the user
    scanf("%lu", &decimal);

    // Convert the decimal number to an octal string
    octal = decimalToOctal(decimal);

    // Print the result
    printf("%lu in dec equals %s in octal\n", decimal, octal);

    return 0;
}

char *decimalToOctal(unsigned long decimal)
{
    // Allocate memory for the octal string (23 bytes to hold large numbers)
    char *octal = malloc(23);
    if(octal == NULL) // Check if memory allocation was successful
        exit(1); // Exit if allocation fails

    // Set the pointer to the end of the allocated memory
    octal += 22;
    *octal-- = '\0'; // Null-terminate the string

    if(decimal == 0) // Special case: if the number is 0
    {
        *octal = '0'; // Set the first character to '0'
    }
    else
    {
        char remainder; // Variable to store the remainder when dividing by 8
        // Loop until the decimal number is fully converted
        while(decimal > 0)
        {
            remainder = (decimal % 8) + '0'; // Calculate the octal digit
            *octal-- = remainder; // Store the digit in the octal string
            decimal = decimal / 8; // Reduce the decimal number by dividing by 8
        }
        octal++; // Adjust the pointer to the start of the octal string
    }

    return octal; // Return the octal string
}

