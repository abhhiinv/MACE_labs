#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
    int data;
    struct Node *left , *right;
}node;

node* root=NULL;

node* create(int value){
    node* newNode=(node*)malloc(sizeof(node));
    newNode->data=value;
    newNode->left=newNode->right=NULL;
    return newNode;
}

node* insert(node* root,int value){
    if(root==NULL){
        return create(value);
    }
    if(value<root->data)
        root->left=insert(root->left,value);
    else if(value>root->data)
        root->right=insert(root->right,value);
    return root;
}

node* findMin(node* root){
    while(root&&root->left!=NULL){
        root=root->left;
    }
    return root;
}

node* search(node* root,int value){
    if(root==NULL)
        return NULL;
    if(root->data==value)
        return root;
    if(value<root->data){
        return search(root->left,value);
    }
    else if(value>root->data){
        return search(root->right,value);
    }
}

node* delete(node* root,int value){
    if(root==NULL)
        return root;
    if(value<root->data){
        root->left=delete(root->left,value);
    }
    else if(value>root->data){
        root->right=delete(root->right,value);
    }
    else{
        if(root->left==NULL){
            node* temp=root->right;
            free(root);
            return temp;
        }else if(root->right==NULL){
            node* temp=root->left;
            free(root);
            return temp;
        }
        node* temp=findMin(root->right);
        root->data=temp->data;
        root->right=delete(root->right,temp->data);
    }
    return root;
}

void inorder(node* root){
    if(root!=NULL){
        inorder(root->left);
        printf("%d ",root->data);
        inorder(root->right);
    }
}
void preorder(node* root){
    if(root!=NULL){
        printf("%d ",root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(node* root){
    if(root!=NULL){
        postorder(root->left);
        postorder(root->right);
        printf("%d ",root->data);
    }
}

void main(){
    node* temp=NULL;
    int ch,value;
    while(1){
        printf("\n*****Binary Search Tree*****\n");
        printf("1)Insert\n2)Search\n3)Deletion\n4)Inorder\n5)Preorder\n6)Postorder\n7)Exit\n");
        printf("Enter your choice :");
        scanf("%d",&ch);
        switch(ch){
            case 1:
                printf("Enter the elements of the tree :");
                scanf("%d",&value);
                root=insert(root,value);
                break;
            case 2:
                printf("Enter the value to search :");
                scanf("%d",&value);
                temp=search(root,value);
                if(temp!=NULL)
                    printf("%d found\n",value);
                else
                    printf("%d not found\n",value);
                break;
            case 3:
                printf("Enter the value to delete :");
                scanf("%d",&value);
                root=delete(root,value);
                break;
            case 4:
                printf("Inorder traversal :");
                inorder(root);
                break;
            case 5:
                printf("Preorder traversal :");
                preorder(root);
                break;
            case 6:
                printf("Postorder traversal :");
                postorder(root);
                break;
            case 7:
                exit(0);
            default:
                printf("Invalid choice!!\n");
        }
    }
}