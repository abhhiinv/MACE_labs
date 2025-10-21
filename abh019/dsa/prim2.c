#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
#define MAX 20
#define INF INT_MAX
#define no_edge -1

int n=0;
int cost[MAX][MAX];
int near[MAX];
int mst[MAX-1][2];
int min_cost = 0;
int mst_found = 0;
