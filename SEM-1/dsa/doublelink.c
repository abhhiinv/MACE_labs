#include<stdio.h>
#include<stdlib.h>

typedef struct node{
    int data;
    struct node *prev;
    struct node *next;
}Node;

int  count=0;
Node* head = NULL;
Node* tail = NULL;

Node* createNode(int value){
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data =value;
    newNode->next =NULL;
    newNode->prev =NULL;
    return newNode;
}

void insertBegin(int value){
    Node* newNode = createNode(value);
    if(head==NULL){
        head=tail=newNode;
    }else{
        newNode->next =head;
        head->prev =newNode;
        head =newNode;
    }
    count++;
}

void insertEnd(int value){
    Node* newNode = createNode(value);
    if(head==NULL){
        head=tail=newNode;
    }else{
        tail->next =newNode;
        newNode->prev =tail;
        tail =newNode;
    }
    count++;
}

void deleteBegin(){
    if(head==NULL){
        printf("List is empty\n");
        return;
    }
    Node* temp =head;
    if(head == tail){
        head = tail = NULL;
    }else{
        head=head->next;
        head->prev=NULL;   
    }
    printf("%d Deleted\n",temp->data);
    free(temp);
    count--;
}

void deleteEnd(){
    if(head==NULL){
        printf("List is empty\n");
        return;
    }
    Node* temp =tail;
    if(head == tail){
        head = tail = NULL;
    }else{
        tail=tail->prev;
        tail->next=NULL;
    }
    printf("%d Deleted\n",temp->data);
    free(temp);
    count--;
}

void traverseBegin(){
    Node* temp =head;
    if(head==NULL){
        printf("List is empty\n");
        return; 
    }else{
        printf("Traversal forward:");
        while(temp!=NULL){
             printf("%d\t",temp->data);
            temp=temp->next;
        }
        printf("\n");
    }
}

void traverseEnd(){
    Node* temp =tail;
    if(head==NULL){
        printf("List is empty\n");
        return; 
    }else{
        printf("Traversal backward:");
        while(temp!=NULL){
            printf("%d\t",temp->data);
            temp=temp->prev;
        }
        printf("\n");
    }
}

void countNode(){
    printf("The count is : %d\n",count);
}

int main(){
    int choice,value;

    while(1){
        printf("***Doubly linked list operations***\n");
        printf("1)Insert from beginning\n2)Insert from end\n3)Delete from beginning\n4)Delete from end\n5)Traverse from beginning\n6)Traverse from end\n7)Count of nodes\n8)Exit\n");
        printf("Enter your choice :");
        scanf("%d",&choice);
        
        switch(choice){
            case 1: printf("Enter the value: ");
                    scanf("%d",&value);
                    insertBegin(value);
                    break;
            
            case 2: printf("Enter the value: ");
                    scanf("%d",&value);
                    insertEnd(value);
                    break;
            
            case 3: deleteBegin();
                    break;

            case 4: deleteEnd();
                    break;

            case 5: traverseBegin();
                    break;

            case 6: traverseEnd();
                    break;

            case 7: countNode();
                    break;

            case 8: exit(0);

            default: printf("Invalid choice\n");
        }
    }
    return 0;
}