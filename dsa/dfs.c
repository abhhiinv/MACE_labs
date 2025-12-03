#include<stdio.h>
#define MAX 20

// Global variables
int adj[MAX][MAX]; // Adjacency Matrix
int visited[MAX];          // Array to keep track of visited vertices
int n;                              // Number of vertices

// Function to perform Depth First Search
void dfs(int start_vertex) {
    int j;
    
    // 1. Mark the current vertex as visited
    visited[start_vertex] = 1;
    
    // 2. Print the current vertex
    printf("%d -> ", start_vertex);
    
    // 3. Recurse for all unvisited adjacent vertices
    // We check the adjacency matrix for neighbors
    for (j = 0; j < n; j++) {
        // Check if there is an edge AND the neighbor is not visited
        if (adj[start_vertex][j] == 1 && !visited[j]) {
            dfs(j); // Recursive call
        }
    }
}

void main() {
    int i, j, e; // 'e' for number of edges
    int u, v;    // u and v for edge endpoints
    int start_node;
    
    printf("\n*****DEPTH FIRST SEARCH (DFS) TRAVERSAL*****\n");
    
    // 1. Get graph size
    printf("\nEnter the number of vertices (max %d): ", MAX);
    scanf("%d", &n);
    
    // Get number of edges
    printf("Enter the number of edges: ");
    scanf("%d", &e);
    
    // Initialize the adjacency matrix and visited array
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
        visited[i] = 0;
    }
    
    // 2. Read the edges using the u-v method (Edge List)
    printf("Enter the edges:\n");
    printf("u v\n");
    for (i = 0; i < e; i++) {
        // Read the two connected vertices
        printf("Edge %d: ", i + 1);
        scanf("%d %d", &u, &v);
        
        // Add the edge to the Adjacency Matrix
        // This assumes an undirected graph (connection in both directions)
        if (u > 0 && u <= n && v > 0 && v <= n) {
            adj[u-1][v-1] = 1;
            adj[v-1][u-1] = 1;
        } else {
            printf("Error: Invalid vertex number (1-%d). Skipping edge.\n",n);
            i--; // Re-read this edge
        }
    }
    
    // 3. Get the starting vertex
    printf("\nEnter the starting vertex for DFS (0 to %d): ", n);
    scanf("%d", &start_node);
    
    // Check if start node is valid
    if (start_node < 0 || start_node > n) {
        printf("Invalid starting vertex.\n");
        return;
    }
    
    // 4. Perform DFS
    printf("\nDFS Traversal Order:\n");
    dfs(start_node);
    printf("END\n\n");
}
