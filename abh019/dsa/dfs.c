#include<stdio.h>
#define MAX_VERTICES 20

// Global variables for the DFS function
int adj[MAX_VERTICES][MAX_VERTICES]; // Adjacency Matrix
int visited[MAX_VERTICES];          // Array to keep track of visited vertices
int n;                              // Number of vertices

// Function to perform Depth First Search
void dfs(int start_vertex) {
    int j;
    
    // 1. Mark the current vertex as visited
    visited[start_vertex] = 1;
    
    // 2. Print the current vertex
    printf("%d -> ", start_vertex);
    
    // 3. Recurse for all unvisited adjacent vertices
    for (j = 0; j < n; j++) {
        // Check if there is an edge AND the neighbor is not visited
        if (adj[start_vertex][j] == 1 && visited[j] == 0) {
            dfs(j); // Recursive call
        }
    }
}

void main() {
    int i, j, start_node;
    
    printf("\n*****DEPTH FIRST SEARCH (DFS) TRAVERSAL*****\n");
    
    // 1. Get graph size
    printf("\nEnter the number of vertices (max %d): ", MAX_VERTICES);
    scanf("%d", &n);
    
    // Initialize the adjacency matrix and visited array
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
        visited[i] = 0;
    }
    
    // 2. Read the Adjacency Matrix
    printf("Enter the Adjacency Matrix (0 or 1 for each connection):\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            printf("Edge from %d to %d: ", i, j);
            scanf("%d", &adj[i][j]);
        }
    }
    
    // 3. Get the starting vertex
    printf("\nEnter the starting vertex for DFS (0 to %d): ", n - 1);
    scanf("%d", &start_node);
    
    // Check if start node is valid
    if (start_node < 0 || start_node >= n) {
        printf("Invalid starting vertex.\n");
        return;
    }
    
    // 4. Perform DFS
    printf("\nDFS Traversal Order:\n");
    dfs(start_node);
    printf("END\n\n");
}