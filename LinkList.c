#include <stdio.h>
#include <stdlib.h>


struct Node {
    int data;
    struct Node* next;
};


struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}


void insertEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
}


void printList(struct Node* head) {
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}


void deleteNode(struct Node** head, int key) {
    struct Node* temp = *head, *prev = NULL;


    if (temp != NULL && temp->data == key) {
        *head = temp->next;
        free(temp);
        return;
    }


    while (temp != NULL && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }


    if (temp == NULL) return;


    prev->next = temp->next;

    free(temp);
}


int main() {
    struct Node* head = NULL;


    insertEnd(&head, 10);
    insertEnd(&head, 20);
    insertEnd(&head, 30);

    printf("Linked list: ");
    printList(head);


    deleteNode(&head, 20);
    printf("After deleting 20: ");
    printList(head);

    return 0;
}

