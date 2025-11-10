#include <stdio.h>
#define MAX 100

int q[MAX];
int front = -1, rear = -1;

void enq(int vert) {
    if (rear == MAX - 1)
        printf("Queue Overflow!!!\n");
    else {
        if (front == -1) front = 0;
        q[++rear] = vert;
    }
}

int deq() {
    if (front == -1 || front > rear)
        return -1;
    else
        return q[front++];
}

int isEmpty() {
    return (front == -1 || front > rear);
}

void BFS(int adj[MAX][MAX], int n, int start) {
    int visit[MAX] = {0};
    int i, vert;
    front = rear = -1; 

    printf("\nBFS starting from vertex %d: ", start + 1);
    enq(start);
    visit[start] = 1;

    while (!isEmpty()) {
        vert = deq();
        printf("%d=>", vert + 1);
        for (i = 0; i < n; i++) {
            if (adj[vert][i] == 1 && visit[i] == 0) {
                enq(i);
                visit[i] = 1;
            }
        }
    }
    printf("NULL\n");
}

int main() {
    int n, e, u, v, start;
    int adj[MAX][MAX] = {0};

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    printf("Enter each edge as a pair of vertices (u v) between 1 and %d:\n", n);
    for (int i = 0; i < e; i++) {
        scanf("%d %d", &u, &v);

        if (u < 1 || u > n || v < 1 || v > n) {
            printf("Invalid edge! Please enter between 1 and %d.\n", n);
            i--;
            continue;
        }

        
        adj[u - 1][v - 1] = 1;
        adj[v - 1][u - 1] = 1;
    }

    printf("Enter the starting vertex (1 to %d): ", n);
    scanf("%d", &start);

    BFS(adj, n, start - 1);
    return 0;
}
