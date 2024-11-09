
#include <stdio.h>
#include <stdlib.h>

// Definition of the Node structure for the linked list
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node with given data
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node)); // Allocate memory for a new node
    newNode->data = data; // Set the data for the new node
    newNode->next = NULL; // Initialize the next pointer to NULL
    return newNode;
}

// Function to insert a node at the end of the linked list
void insertEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data); // Create a new node

    // If the linked list is empty, set the new node as the head
    if (*head == NULL) {
        *head = newNode;
        return;
    }

    // Traverse the list to find the last node
    struct Node* temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    // Set the next of the last node to the new node
    temp->next = newNode;
}

// Function to print the linked list
void printList(struct Node* head) {
    struct Node* temp = head; // Start from the head node
    while (temp != NULL) {
        printf("%d -> ", temp->data); // Print the data of the current node
        temp = temp->next; // Move to the next node
    }
    printf("NULL\n"); // End of the list
}

// Function to delete a node with a given key from the linked list
void deleteNode(struct Node** head, int key) {
    struct Node* temp = *head, *prev = NULL;

    // If the head node itself holds the key to be deleted
    if (temp != NULL && temp->data == key) {
        *head = temp->next; // Change the head to the next node
        free(temp); // Free the old head node
        return;
    }

    // Search for the key in the list and keep track of the previous node
    while (temp != NULL && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }

    // If the key was not found in the list
    if (temp == NULL) return;

    // Unlink the node from the list
    prev->next = temp->next;

    // Free the memory of the node to be deleted
    free(temp);
}

int main() {
    struct Node* head = NULL; // Initialize an empty linked list

    // Insert some nodes into the linked list
    insertEnd(&head, 10);
    insertEnd(&head, 20);
    insertEnd(&head, 30);

    // Print the linked list
    printf("Linked list: ");
    printList(head);

    // Delete a node and print the modified list
    deleteNode(&head, 20);
    printf("After deleting 20: ");
    printList(head);

    return 0;
}
