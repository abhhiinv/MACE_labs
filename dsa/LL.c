#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
    int data;
    struct node* next;
}node;

node *head = NULL;
node *temp = NULL;

node *create(int value){
    node *new = (node*)malloc(sizeof(node));
    new->data = value;
    new->next = NULL;
    return new;
}

void insertBeg(int value){
    node *new = create(value);
    if(head == NULL)
        head=new;
    else{
        new->next=head;
        head = new;
    }
}

void insertEnd(int value){
    node* new =create(value);
    if(head == NULL)
        head = new;
    else{
        temp = head;
        while(temp->next != NULL){
            temp = temp->next;
        }
        temp->next = new;
    }
}

void deleteBeg(){
    if(head == NULL)
        return;
    else{
        temp = head;
        temp->next = head;
    }
    printf("%d deleted",temp->data);
    free(temp);
}

void delteEnd(){
    node *prev = NULL;
    if(head == NULL)
        return;
    else{
        temp = head;
        while(temp->next != NULL){
            prev = temp;
            temp = temp->next;
        }
    }
    printf("%d deleted",temp->data);
    free(temp);
}

void display(){
    temp = head;
    while(temp->next != NULL){
        printf("%d->",temp->data);
        temp = temp->next;
    }
    printf("%d->NULL\n",temp->data);
}

void main(){
    int ch,val;
    while(1){
        printf("1)Insert Begin\n2)Insert End\n3)Delete Begin\n4)Delete End\n5)Display\n6)Exit\n");
        scanf("%d",&ch);
        switch (ch)
        {
        case 1 :
            printf("Enter value : ");
            scanf("%d",&val);
            insertBeg(val);
            break;
        case 2:
            printf("Enter value : ");
            scanf("%d",&val);
            insertEnd(val);
            break;
        case 3:
            
            delete
        default:
            break;
        }
    }
}
