#include <stdio.h>
#include <string.h>

// Function prototypes
unsigned long binaryToDecimal(char *binary, int length);
int validate(char *binary, int length);

int main(void)
{
    char binary[65];  // Array to store binary input
    int length;       // Length of the binary input
    unsigned long decimal;  // Variable to hold the converted decimal value

    // Read binary input from the user
    scanf("%64s", binary);
    length = strlen(binary);  // Get the length of the input

    // Validate the binary input
    if (validate(binary, length))
    {
        // Convert binary to decimal if valid
        decimal = binaryToDecimal(binary, length);
        printf("%s in binary is %lu in decimal\n", binary, decimal);
    }
    else
    {
        // Error message for invalid input
        printf("The input should be a binary number, containing only zeros(0) and ones(1).\n");
    }

    return 0;  // Exit the program
}

// Function to convert binary string to decimal
unsigned long binaryToDecimal(char *binary, int length)
{
    int i;
    unsigned long decimal = 0;  // Initialize decimal value
    unsigned long weight = 1;    // Weight starts at 1 (2^0)

    // Move pointer to the last character of the binary string
    binary += length - 1;

    // Loop through the binary string from right to left
    for (i = 0; i < length; ++i, --binary)
    {
        if (*binary == '1')  // Check if the current bit is 1
            decimal += weight;  // Add weight to decimal if it's 1
        weight *= 2;  // Update weight for the next bit
    }

    return decimal;  // Return the computed decimal value
}

// Function to validate if the string is a binary number
int validate(char *binary, int length)
{
    int i;
    for (i = 0; i < length; ++i, binary++)
    {
        // Check if the character is not '0' or '1'
        if ((*binary != '0') && (*binary != '1'))
            return 0;  // Return 0 for invalid character
    }
    return 1;  // Return 1 if all characters are valid
}

