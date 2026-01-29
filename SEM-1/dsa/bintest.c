#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *left, *right;
} Node;

int value;
Node *root = NULL;

Node* createNode(int value) {
    Node *ptr = (Node*)malloc(sizeof(Node));
    ptr->data = value;
    ptr->left = ptr->right = NULL;
    return ptr;
}

Node* insert(Node *root, int value) {
    if (root == NULL) {
        return createNode(value);
    }
    if (root->left == NULL) {
        root->left = insert(root->left, value);
    }
    else if (root->right == NULL) {
        root->right = insert(root->right, value);
    }
    else {
        root->left = insert(root->left, value);
    }
    return root;
}

Node* findMin(Node* node) {
    while (node->left != NULL) {
        node = node->left;
    }
    return node;
}

Node* delete(Node* root, int value) {
    if (root == NULL) {
        return NULL;
    }
    if (value < root->data) {
        root->left = delete(root->left, value);
    }
    else if (value > root->data) {
        root->right = delete(root->right, value);
    }
    else {
        if (root->left == NULL && root->right == NULL) {
            free(root);
            return NULL;
        }
        else if (root->left == NULL) {
            Node* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            Node* temp = root->left;
            free(root);
            return temp;
        }
        else {
            Node* successor = findMin(root->right);
            root->data = successor->data;
            root->right = delete(root->right, successor->data);
        }
    }
    return root;
}

/* ---------------- Queue Helpers ---------------- */
typedef struct queue {
    Node* node;
    struct queue* next;
} Queue;

void enqueue(Queue** front, Queue** rear, Node* n) {
    Queue* temp = (Queue*)malloc(sizeof(Queue));
    temp->node = n;
    temp->next = NULL;
    if (*rear) {
        (*rear)->next = temp;
    } else {
        *front = temp;
    }
    *rear = temp;
}

Node* dequeue(Queue** front, Queue** rear) {
    if (*front == NULL) return NULL;
    Queue* temp = *front;
    Node* n = temp->node;
    *front = (*front)->next;
    if (*front == NULL) *rear = NULL;
    free(temp);
    return n;
}

int isEmpty(Queue* front) {
    return front == NULL;
}

/* ---------------- Tree Printing ---------------- */
void printTree(Node* root) {
    if (root == NULL) {
        printf("(empty)\n");
        return;
    }

    Queue *front = NULL, *rear = NULL;
    enqueue(&front, &rear, root);

    while (!isEmpty(front)) {
        int levelSize = 0;
        Queue* temp = front;
        while (temp) {
            levelSize++;
            temp = temp->next;
        }

        for (int i = 0; i < levelSize; i++) {
            Node* node = dequeue(&front, &rear);
            if (node) {
                printf("%d ", node->data);
                if (node->left) enqueue(&front, &rear, node->left);
                if (node->right) enqueue(&front, &rear, node->right);
            }
        }
        printf("\n"); // new line for each level
    }
}

/* ---------------- Main Menu ---------------- */
int main() {
    int ch;
    while (1) {
        printf("\n*** Binary Tree ***\n");
        printf("1) Insertion\n2) Deletion\n3) Print Tree\n4) Exit\n");
        scanf("%d", &ch);
        switch (ch) {
            case 1:
                printf("Enter the value to insert: ");
                scanf("%d", &value);
                root = insert(root, value);
                break;

            case 2:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                root = delete(root, value);
                break;

            case 3:
                printf("Tree structure (level by level):\n");
                printTree(root);
                break;

            case 4:
                exit(0);
                break;

            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
