
#include<stdio.h>
#include<stdlib.h>

char* decimalToBinary(long decimal);

int main(void)
{
    // Convert the decimal number 0 to binary
    char* binary = decimalToBinary(0);

    // Print the resulting binary string
    printf("%s", binary);

    return 0;
}

char* decimalToBinary(long decimal)
{
    // Allocate memory for a 64-bit binary string plus null terminator
    char *binary = malloc(65);
    if (binary == NULL)
        exit(1);  // Exit if memory allocation fails

    binary += 64; // Move pointer to the end of the allocated memory
    *binary = '\0'; // Null-terminate the string

    if (decimal == 0) // Handle the special case where decimal is 0
    {
        --binary;
        *binary = '0';
    }
    else
    {
        // Convert decimal to binary
        while (decimal > 0)
        {
            --binary;
            *binary = decimal % 2 + '0'; // Store the binary digit
            decimal /= 2;
        }
    }
    return binary; // Return the binary string
}
