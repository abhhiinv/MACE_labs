#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} node;

node* head = NULL;
node* temp = NULL;

node* createNode(int val){
    node* new = (node*) malloc (sizeof(node));
    new->data = val;
    new->next = NULL;
    return new;
}

void insert(int val){
    node* new = createNode(val);
    new->next = head;
    head = new;
}

void insertEnd(int val){
    node* new = createNode(val);
    if(head == NULL){
        head = new;
        return;
    }
    temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp->next = new;
}

void delete(){
    if(head == NULL) return;
    temp = head;
    head = head->next;
    printf("%d deleted\n",temp->data);
    free(temp);
}

void deleteEnd(){
    if(head==NULL) return;
    if(head->next == NULL){
        printf("%d deleted",head->data);
        free(head);
        head = NULL;
        return;
    }
    temp = head;
    while(temp->next->next != NULL){
        temp = temp->next;
    }
    printf("%d deleted",temp->next->data);
    free(temp->next);
    temp->next = NULL;
}

void display(){
    if(head == NULL){
        printf("Nothing to display\n");
        return;
    }
    temp = head;
    while(temp != NULL){
        printf("%d->",temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

int main(){
    int ch,val;
    while(1){
        printf("\n1)Insertion at beginning\n2)Deletion from beiginning\n3)Insert from end\n4)Delete from end\n5)Display\n6)Exit");
        printf("Enter your choice : ");
        scanf("%d",&ch);
        switch(ch){
            case 1:
                printf("Enter value to insert from beginning: ");
                scanf("%d",&val);
                insert(val);
                break;
            case 2:
                delete();
                break;
            case 3:
                printf("Enter value to insert at end: ");
                scanf("%d",&val);
                insertEnd(val);
                break;
            case 4: 
                deleteEnd();
            case 5:
                display();
                break;
            case 6:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
