def hasCycle(n, edges):
    # Build adjacency list
    graph = [[] for _ in range(n)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    visited = [False] * n

    def dfs(node, parent):
        visited[node] = True
        for neighbor in graph[node]:
            if not visited[neighbor]:
                if dfs(neighbor, node):  # recurse
                    return True
            elif neighbor != parent:     # visited and not parent = cycle
                return True
        return False

    # Handle disconnected graphs
    for i in range(n):
        if not visited[i]:
            if dfs(i, -1):
                return True
    return Falsedef hasCycle(n, edges):
    parent = list(range(n))

    def find(x):
        while parent[x] != x:
            parent[x] = parent[parent[x]]  # path compression
            x = parent[x]
        return x

    def union(x, y):
        px, py = find(x), find(y)
        if px == py:
            return False  # same set = cycle
        parent[px] = py
        return True

    for u, v in edges:
        if not union(u, v):
            return True
    return False
