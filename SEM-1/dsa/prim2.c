#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define MAX 20
#define INF INT_MAX
#define no_edge -1

int n = 0;
int cost[MAX][MAX];
int near[MAX];
int mst[MAX - 1][2];
int min_cost = 0;
int mst_found = 0;

int start_edge(int *k_out, int *l_out)
{
    int k = -1, l = -1;
    int min_val = INF;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (i != j && cost[i][j] < min_val)
            {
                min_val = cost[i][j];
                k = i;
                l = j;
            }
        }
    }
    *k_out = k;
    *l_out = l;
    return min_val;
}

int next_vert()
{
    int j = -1;
    int min_e_cost = INF;
    for (int vert = 0; vert < n; vert++)
    {
        if (near[vert] != -1)
        {
            int mst_neigh = near[vert];
            if (cost[vert][mst_neigh] < min_e_cost)
            {
                min_e_cost = cost[vert][mst_neigh];
                j = vert;
            }
        }
    }
    return j;
}

void read()
{
    printf("Enter the number of vertices (max %d): ", MAX);
    if (scanf("%d", &n) != 1 || n <= 1 || n > MAX)
    {
        printf("Please enter a value between 2 and %d\n", MAX);
        n = 0;
        return;
    }

    // Initialize adjacency matrix
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cost[i][j] = (i == j) ? 0 : INF;

    printf("\nEnter edges in the format: <source> <destination> <cost>\n");
    printf("Example:\n1 2 5\n1 3 7\n2 3 2\n");
    printf("Enter 0 0 0 to stop entering edges.\n");

    while (1)
    {
        int u, v, w;
        printf("Edge (u v w): ");
        if (scanf("%d %d %d", &u, &v, &w) != 3)
        {
            printf("Invalid input! Try again.\n");
            while (getchar() != '\n');
            continue;
        }

        if (u == 0 && v == 0 && w == 0)
            break; // done entering edges

        if (u < 1 || v < 1 || u > n || v > n)
        {
            printf("Invalid vertices! Must be between 1 and %d.\n", n);
            continue;
        }

        if (w <= 0)
        {
            printf("Weight must be positive!\n");
            continue;
        }

        cost[u - 1][v - 1] = w;
        cost[v - 1][u - 1] = w; 
    }

    printf("Graph loaded successfully!\n");
    mst_found = 0;
}

void prims()
{
    if (n == 0)
    {
        printf("Graph not loaded\n");
        return;
    }
    printf("\n-----Prim's is working-----\n");
    min_cost = 0;
    mst_found = 0;
    int k = -1, l = -1;
    int min_val = start_edge(&k, &l);
    if (min_val == INF)
    {
        printf("ERROR:Graph is disconnected or empty\n");
        return;
    }
    min_cost = cost[k][l];
    mst[0][0] = k + 1;
    mst[0][1] = l + 1;
    for (int i = 0; i < n; i++)
    {
        near[i] = (cost[i][l] < cost[i][k]) ? l : k;
    }
    near[k] = -1;
    near[l] = -1;
    for (int i = 1; i < n-1; i++)
    {
        int j = next_vert();
        int min_e_cost = (j != -1) ? cost[j][near[j]] : INF;
        if (j == -1 || min_e_cost == INF)
        {
            printf("Algorithm terminated early, graph is disconnected");
            mst_found = i;
            return;
        }
        mst[i][0] = j + 1;
        mst[i][1] = near[j] + 1;
        min_cost += cost[j][near[j]];
        near[j]=-1;
        for(k= 0; k<n ; k++){
            if(near[k]!=-1){
                if(cost[k][near[k]] > cost[k][j]){
                    near[k]=j;
                }
            }
        }
    }
    mst_found=n-1;
    printf("\nPrim's algorithm completed\n");
}

void display_mst(){
    if(n==0 || !mst_found){
        printf("ERROR:MST has not been calculated, please select 1 and 2 first\n");
        return;
    }
    printf("Total number of vertics: %d\n",n);
    printf("Total number of Edges in MST: %d\n",mst_found);
    printf("MST Edges (A,b)-COST:\n");
    for(int i=0; i<mst_found; i++){
        int u=mst[i][0];
        int v=mst[i][1];
        int e_cost=cost[u-1][v-1];
        printf("%d (%d,%d)-COST:%d\n",i+1,u,v,e_cost);
    }
    printf("Final min total cost:%d\n",min_cost);
}

void main(){
    printf("\n*****Prim's Algorithm*****\n");
    printf("%d is used for No edge (infinity)\n",no_edge);
    int ch;
    while(1){
        printf("1)Read graph(Adjacency matrix)\n");
        printf("2)Prim's Algorithm\n");
        printf("3)Display MST\n");
        printf("4)Exit\n");
        printf("Enter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1:
                read();break;
            case 2:
                prims();break;
            case 3:
                display_mst();break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice!!\n");
        }
    }
}
