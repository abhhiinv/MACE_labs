#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
    int data;
    struct node* next;
}node;

node *tail = NULL;

node *create(int value){
    node *new = (node*)malloc(sizeof(new));
    new->data = value;
    new->next = NULL;
    return new;
}

void insertBeg(int value){
    node *new = create(value);
    if(tail == NULL)
        tail=new;
    else{
        tail=new;
    }
}
