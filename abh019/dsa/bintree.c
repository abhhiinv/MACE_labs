#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int data;
    struct node *left ;
    struct node *right; 
}Node;


int  value;
Node *root=NULL;
Node* createNode(int value){
    Node *ptr = (Node*)malloc(sizeof(Node));
    ptr->data=value;
    ptr->left=ptr->right=NULL;
    return ptr;
}

Node* insert(Node *root,int value){
    if(root == NULL){
        return createNode(value);
    }
    if(root->left == NULL){
        root->left = insert(root->left, value);   
    }
    else if(root->right == NULL){
        root->right = insert(root->right, value); 
    }
    else{
        
        root->left = insert(root->left, value);
    }
    return root;
}


Node* findMin(Node* node){
    while(node->left != NULL){
        node = node->left;
    }
    return node;
}

Node* delete(Node* root, int value){
    if (root == NULL){
        return NULL;
    }
    if (value < root->data){
        root->left = delete(root->left, value);
    }
    else if (value > root->data){
        root->right = delete(root->right, value);
    }
    else{  
                                                                // Node found
        if (root->left == NULL && root->right == NULL){
            free(root);
            return NULL;
        }
        else if (root->left == NULL){
            Node* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL){
            Node* temp = root->left;
            free(root);
            return temp;
        }
        else{
            Node* successor = findMin(root->right);              // inorder successor
            root->data = successor->data;                        // replace value
            root->right = delete(root->right, successor->data);  // delete successor
        }
    }
    return root;
}

void inorder(Node* root){
    if(root!=NULL){
        inorder(root->left);
        printf("%d\t",root->data);
        inorder(root->right);
    }
}

void preorder(Node *root){
    if(root!=NULL){
        printf("%d\t",root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(Node* root){
    if(root!=NULL){
        postorder(root->left);
        postorder(root->right);
        printf("%d\t",root->data);
    }
}


int main(){
    int ch;
    while(1){
        printf("\n*****Binary tree*****\n");
        printf("1)Insertion\n2)Deletion\n3)Inorder\n4)Preorder\n5)Postorder\n6)Exit\n");
        printf("Enter your choice :");
        scanf("%d",&ch);
        switch(ch){

            case 1:
                printf("Enter the value to insert :");
                scanf("%d",&value);
                root = insert(root, value); 
                break;

            
            case 2:
                printf("Enter value to delete :");
                scanf("%d",&value);
                root =delete(root,value);
                break;

            case 3:
                printf("Inorder :");
                inorder(root);
                printf("\n");
                break;

            case 4:
                printf("Preorder :");
                preorder(root);
                printf("\n");
                break;

            case 5:
                printf("Postorder :");
                postorder(root);
                printf("\n");
                break;

            case 6:
                exit(0);
                break;

            default:
                printf("Invalid choice\n");
        }
    } 
    return 0;
}

