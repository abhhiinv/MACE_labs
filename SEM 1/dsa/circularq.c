#include<stdio.h>
#include <stdlib.h>
#define SIZE 5

int rear=-1 ,front=-1;
int q[SIZE], count=0;

void insert(){
    int value;
    if((front==0 && rear==SIZE-1)||(front==(rear+1)%(SIZE))){
        printf("Queue overflow\n");
        return;
    }
    printf("Enter the value :");
    scanf("%d",&value);
    rear++;

    if(front==-1){
        front=0;
    }
    q[rear]=value;
    printf("%d Enqueued \n",value);
    count++;
}

void delete(){
    if(front==-1){
        printf("There is nothing to delete\n");
        return;
    }
    int value=q[front];
    if(front==rear){
        front=rear=-1;
    }else{
        front=(front+1)%SIZE;
    }
    printf("%d Deleted\n",value);
    count--;
}

void display(){
    int i;
    if(front==-1){
        printf("There is nothing to delete\n");
        return;
    }
    if(rear>=front){
        for(i=front;i<=rear;i++){
            printf("%d\t",q[i]);
        }
    }else{
        for(i=front;i<SIZE;i++)
            printf("%d\t",q[i]);
        for(i=0;i<=rear;i++)
            printf("%d\t",q[i]);
    }
    
}

int main(){
    int choice;

    while(1){
        printf("\n**Circular queue menu***\n");
        printf("1)Insert\n2)Delete\n3)Display\n4)Count\n5)Exit\n");
        printf("Enter your choice :");
        scanf("%d",&choice);
        switch(choice){
            case 1: insert(); break;
            case 2: delete(); break;
            case 3: display(); break;
            case 4: printf("The number of elements are %d\n",count);
            case 5: exit(0);
            default : printf("Invalid choice!!\n");
        }
    }
    return 0;
}