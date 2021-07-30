package findandunion;


import java.util.Arrays;

public class FindAndUnion {
    private static int dist[] = new int[9];

    public static void main(String[] args) {
        for (int i = 1; i < 9; i++) {
            dist[i] = -1;
        }
        addOrRejectEdge(new Edge(7, 6, 1));
        addOrRejectEdge(new Edge(8, 2, 2));
        addOrRejectEdge(new Edge(6, 5, 2));

        addOrRejectEdge(new Edge(0, 1, 4));
        addOrRejectEdge(new Edge(2, 5, 4));
        addOrRejectEdge(new Edge(8, 6, 6));

        addOrRejectEdge(new Edge(2, 3, 7));
        addOrRejectEdge(new Edge(7, 8, 7));
        addOrRejectEdge(new Edge(0, 7, 8));

        addOrRejectEdge(new Edge(1, 2, 8));
        addOrRejectEdge(new Edge(3, 4, 9));
        addOrRejectEdge(new Edge(5, 4, 10));

        addOrRejectEdge(new Edge(1, 7, 11));
        addOrRejectEdge(new Edge(3, 5, 14));


//        addOrRejectEdge(new Edge(1, 2, 1));
//        addOrRejectEdge(new Edge(3, 4, 2));
//        addOrRejectEdge(new Edge(5, 6, 3));
//
//        addOrRejectEdge(new Edge(7, 8, 4));
//        addOrRejectEdge(new Edge(2, 4, 5));
//        addOrRejectEdge(new Edge(2, 5, 6));
//
//        addOrRejectEdge(new Edge(1, 3, 7));
//        addOrRejectEdge(new Edge(6, 8, 8));
//        addOrRejectEdge(new Edge(5, 7, 9));
    }

    private static void addOrRejectEdge(Edge edge) {
        System.out.println();
        System.out.println("Begining:" + Arrays.toString(dist));
        System.out.println("deciding Edge:" + edge);
        //all disjoint
//        if (dist[edge.fromVertex] == -1 && dist[edge.toVertex] == -1) {
//            //toVertex becomes the father of fromVertex
//            dist[edge.fromVertex] = edge.toVertex;
//            System.out.println("Selected:" + edge);
//            System.out.println("Ending:" + Arrays.toString(dist));
//            return;
//        }

        int fromVertexParent = getParent(edge.fromVertex);
        int toVertexParent = getParent(edge.toVertex);

        int fromVertexParentWeight = getParentWeight(edge.fromVertex);
        int toVertexParentWeight = getParentWeight(edge.toVertex);

        System.out.println("fromVertexParent:" + fromVertexParent + " toVertexParent:" + toVertexParent);
        System.out.println("fromVertexParentWeight:" + fromVertexParentWeight + " toVertexParentWeight:" + toVertexParentWeight);
        if (fromVertexParent == toVertexParent) {
            System.out.println("Rejected:" + edge);
        } else if (fromVertexParentWeight < 0 && toVertexParentWeight < 0) {
            System.out.println("Selected:" + edge);
            if (Math.abs(fromVertexParentWeight) > Math.abs(toVertexParentWeight)) {
                dist[toVertexParent] = fromVertexParent;
                dist[fromVertexParent] = dist[fromVertexParent] - 1;
            } else {
                dist[fromVertexParent] = toVertexParent;
                dist[toVertexParent] = dist[toVertexParent] - 1;
            }
        } else if (fromVertexParentWeight < toVertexParentWeight) {
            System.out.println("Selected:" + edge);
            dist[fromVertexParent] = toVertexParent;
        } else if (toVertexParentWeight < fromVertexParentWeight) {
            System.out.println("Selected:" + edge);
            dist[toVertexParent] = fromVertexParent;
        }
        System.out.println("Ending:" + Arrays.toString(dist));
    }

    static int getParent(int index) {
        while (dist[index] > 0) {
            index = dist[index];
        }
        return dist[index] > 0 ? dist[index] : index;
    }

    static int getParentWeight(int index) {
        while (dist[index] > 0) {
            index = dist[index];
        }
        return dist[index];
    }


    static class Edge {
        int fromVertex;
        int toVertex;
        int weight;

        public Edge(int fromVertex, int toVertex, int weight) {
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "fromVertex=" + fromVertex +
                    ", toVertex=" + toVertex +
                    ", weight=" + weight +
                    '}';
        }
    }
}
