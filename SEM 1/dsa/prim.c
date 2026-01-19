#include<stdio.h>
#include<limits.h>
#include<stdbool.h>
#define MAX 20

int minIndex(int V,int weight[MAX],bool visited[MAX]){
    int minValue=INT_MAX,minIn=-1;
    for(int i=0;i<V;i++){
        if(!visited[i] && weight[i] < minValue){
            minValue=weight[i];
            minIn=i;
        }
    }
    return minIn;
}

void primMST(int V,int graph[MAX][MAX]){
    int weight[MAX],parent[MAX],total;
    bool visited[MAX];
    for(int i=0;i<V;i++){
        weight[i]=INT_MAX;
        visited[i]=false;   
    }
    weight[0]=0;
    parent[0]=-1;
    for(int c=0;c<V-1;c++){
        int u=minIndex(V,weight,visited);
        visited[u]=true;
        for(int v=0;v<V;v++){
            if(graph[u][v] && !visited[v] && graph[u][v] < weight[v]){
                parent[v]=u;
                weight[v]=graph[u][v];
            }
        }
    }
    printf("\nEdge\tWeight\n");
    for(int i=1;i<V;i++){
        printf("%d-%d\t%d\n",parent[i],i,graph[i][parent[i]]);
        total+=graph[i][parent[i]];
    }
    printf("Total cost= %d\n",total);
}


void main(){
    int graph[MAX][MAX]={0},V,E,u,v,w;
    printf("Enter number of Vertices: ");
    scanf("%d",&V);
    printf("Enter number of Edges: ");
    scanf("%d",&E);
    printf("Enter the edges: \nu v weight\n");
    for(int i=0;i<E;i++){
        scanf("%d %d %d",&u,&v,&w);
        if(u>=0 && v>=0 && v<V && u<V){
            graph[u][v]=graph[v][u]=w;
        }else{
            printf("Invalid input! Try again\n");
            i--;
        }
    }
    printf("Adjacency Matrix: \n");
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            printf("%d ",graph[i][j]);
        }
        printf("\n");
    }
    primMST(V,graph);
}