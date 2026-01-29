#include<stdio.h>
#include<stdlib.h>
#define SIZE 10

void inputSet(int *set){
    
    printf("Enter the elements from 0 to %d, -1 to stop: ",SIZE-1);
    int x;
    while(1){
        scanf("%d",&x);
        if(x==-1) break;
        if(x>=0 && x<SIZE)  //*set |= (1<<x);
            *set= *set|(1<<x);
        else
            printf("Invalid element!\n");
    }
}

void displaySet(int set){

    int i;
    printf("{");
    for(i=0;i<SIZE;i++){
        if(set&(1<<i)){
            printf("%d,",i);
        }
    }
    printf("}\n");
}

void main(){

    int ch,result, setA=0, setB=0 ;

    printf("\nSet A: ");
    inputSet(&setA);
    printf("Set A=");
    displaySet(setA);

    printf("\nSet B: ");
    inputSet(&setB);
    printf("Set B=");
    displaySet(setB);

    while(1){
        printf("\n*****Set Operations Menu*****\n");
        printf("1)Union\n2)Intersection\n3)Difference A-B\n4)Difference B-A\n5)Display set A & B\n6)Exit\n");
        printf("Enter choice: ");
        scanf("%d",&ch);

        switch(ch){
            case 1:
                result=setA | setB;
                printf("Union: ");
                displaySet(result);
                break;
            case 2:
                result=setA & setB;
                printf("Intersection:");
                displaySet(result);
                break;
            case 3:
                result=setA & ~setB;
                printf("Difference A-B: ");
                displaySet(result);
                break;
            case 4:
                result=setB & ~setA;
                printf("Difference B-A: ");
                displaySet(result);
                break;
            case 5:
                printf("Set A= ");
                displaySet(setA);
                printf("\n");
                printf("Set B= ");
                displaySet(setB);
                printf("\n");
                break;
            case 6:
                exit(0);
            default:
                printf("Invalid choice!\n");
        }
    }
}