from collections import defaultdict
from heapq import *
from pprint import pprint

class Graph:
    connections = defaultdict(list)
    nodes = []
    edges = []
    def __init__(self, nodes, edges):
        self.nodes = nodes
        self.edges = edges
        self.connections = self.makeConnections(nodes, edges)
    def makeConnections(self, nodes, edges):
        connections = defaultdict(list)
        for n1,n2,c in edges:
            connections[n1].append((c, n1, n2))
            connections[n2].append((c, n2, n1))
        return connections

def prim(g):
    mst = []
    used = set(g.nodes[0])
    usableEdges = g.connections[nodes[0]][:]
    heapify(usableEdges)

    while usableEdges:
        cost, n1, n2 = heappop(usableEdges)
        if n2 not in used:
            used.add(n2)
            mst.append((n1, n2, cost))
            for edge in g.connections[n2]:
                if edge[2] not in used:
                    heappush(usableEdges, edge)
    return mst
    

#test
nodes = list("ABCDEFG")
edges = [ ("A", "B", 7), ("A", "D", 5),
          ("B", "C", 8), ("B", "D", 9), ("B", "E", 7),
      ("C", "E", 5),
      ("D", "E", 15), ("D", "F", 6),
      ("E", "F", 8), ("E", "G", 9),
      ("F", "G", 11)]
graph = Graph(nodes, edges)

print "prim:", prim(graph)