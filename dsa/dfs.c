#include <stdio.h>
#define MAX 20

// Global variables
int adj[MAX][MAX];     // Adjacency Matrix (0..n-1)
int visited[MAX];      // Visited array (0..n-1)
int n;                 // Number of vertices

// Function to perform Depth First Search
void dfs(int start_vertex) {
    int j;

    visited[start_vertex] = 1;

    // Print as 1-based to match user input
    printf("%d -> ", start_vertex + 1);

    for (j = 0; j < n; j++) {
        if (adj[start_vertex][j] == 1 && !visited[j]) {
            dfs(j);
        }
    }
}

int main(void) {  // Standard hosted C signature [web:1]
    int i, j, e;
    int u, v;
    int start_node; // user enters 1..n

    printf("\n*****DEPTH FIRST SEARCH (DFS) TRAVERSAL*****\n");

    printf("\nEnter the number of vertices (max %d): ", MAX);
    scanf("%d", &n);

    if (n < 1 || n > MAX) {
        printf("Error: Number of vertices must be between 1 and %d.\n", MAX);
        return 0;
    }

    printf("Enter the number of edges: ");
    scanf("%d", &e);

    // Initialize adjacency matrix and visited array
    for (i = 0; i < n; i++) {
        visited[i] = 0;
        for (j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
    }

    // Read edges (1..n from user)
    printf("Enter the edges (u v) where u and v are in 1..%d:\n", n);
    for (i = 0; i < e; i++) {
        printf("Edge %d: ", i + 1);
        scanf("%d %d", &u, &v);

        if (u >= 1 && u <= n && v >= 1 && v <= n) {
            adj[u - 1][v - 1] = 1;
            adj[v - 1][u - 1] = 1; // undirected
        } else {
            printf("Error: Invalid vertex number (1-%d). Re-enter this edge.\n", n);
            i--; // retry this edge
        }
    }

    // Starting vertex (1..n from user)
    printf("\nEnter the starting vertex for DFS (1 to %d): ", n);
    scanf("%d", &start_node);

    if (start_node < 1 || start_node > n) {
        printf("Invalid starting vertex.\n");
        return 0;
    }

    printf("\nDFS Traversal Order:\n");
    dfs(start_node - 1);   // convert to 0-based
    printf("END\n\n");

    return 0;
}
