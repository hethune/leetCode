from collections import defaultdict
from heapq import *
from pprint import pprint


class Mst:
    def __init__(self):
        self.edges = []

    def sum_x(self):
        return sum(list([e[2] for e in self.edges]))

    def sum_y(self):
        return sum(list([e[3] for e in self.edges]))


class Graph:
    def __init__(self, nodes, edges):
        self.nodes = nodes
        self.edges = edges
        self.connections = self.makeConnections(nodes, edges)
        self.normalize(1, 0)
        self.localMin = Mst()
    def makeConnections(self, nodes, edges):
        connections = defaultdict(list)
        for n1,n2,c,t in edges:
            connections[n1].append((c, t, n1, n2))
            connections[n2].append((c, t, n2, n1))
        return connections
    def normalize(self, A, B):
        self.normalizedConnections = {k: [(A*c + B*t, x, y, c, t) for (c, t, x, y) in self.connections[k]] for k in self.connections}
        return self

    def updateLocalMin(self, mst):
        if self.localMin is None or len(self.localMin.edges) == 0:
            self.localMin = mst
            return
        if mst.sum_x() * mst.sum_y() < self.localMin.sum_x() * self.localMin.sum_y():
            self.localMin = mst


def prim(g):
    mst = Mst()
    used = set(g.nodes[0])
    usableEdges = g.normalizedConnections[nodes[0]][:]
    heapify(usableEdges)

    while usableEdges:
        cost, n1, n2, originalCost, originalTime = heappop(usableEdges)
        if n2 not in used:
            used.add(n2)
            mst.edges.append((n1, n2, originalCost, originalTime))
            for edge in g.normalizedConnections[n2]:
                if edge[2] not in used:
                    heappush(usableEdges, edge)
    g.updateLocalMin(mst)
    return mst    


def productMst(g):
    A = prim(g.normalize(1, 0))
    B = prim(g.normalize(0, 1))
    productMstHelper(g, A, B)
    return g.localMin


def productMstHelper(g, A, B):
    a = A.sum_y() - B.sum_y()
    b = B.sum_x() - A.sum_x()

    C = prim(g.normalize(a, b))

    (x1, y1) = (B.sum_x() - A.sum_x(), B.sum_y() - A.sum_y())
    (x2, y2) = (C.sum_x() - A.sum_x(), C.sum_y() - A.sum_y())

    if x1*y2 >= x2*y1:
        return
    productMstHelper(g, A, C)
    productMstHelper(g, C, B)


def debug(g):
    pprint(g.localMin)
    # pprint(g.localMin.edges)

#test
nodes = list("ABCDE")
edges = [ ("A", "B", 161, 79), ("A", "C", 161, 15), ("A", "D", 13, 153),
          ("B", "E", 142, 183),
      ("C", "E", 236, 80), ("C", "B", 65, 92),
      ("D", "E", 40, 241)]

# nodes = list("ABCDEFG")
# edges = [ ("A", "B", 7, 0), ("A", "D", 5, 0),
#           ("B", "C", 8, 0), ("B", "D", 9, 0), ("B", "E", 7, 0),
#       ("C", "E", 5, 0),
#       ("D", "E", 15, 0), ("D", "F", 6, 0),
#       ("E", "F", 8, 0), ("E", "G", 9, 0),
#       ("F", "G", 11, 0)]

graph = Graph(nodes, edges)

print productMst(graph).edges
print graph.localMin.edges
print graph.localMin.sum_x()
print graph.localMin.sum_y()