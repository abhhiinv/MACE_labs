from collections import deque

def shortestPath(n, edges, start, end):
    graph = [[] for _ in range(n + 1)]
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    visited = set([start])
    queue = deque([[start]])  # store full paths instead of just nodes

    while queue:
        path = queue.popleft()
        node = path[-1]  # last node in current path

        if node == end:
            return path  # found it!

        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(path + [neighbor])  # extend path

    return []  # no path found