package HW_7;

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;
    private Queue queue;
    private Stack stackPath;

    public Graph() {
        stack = new Stack(MAX_VERTS);
        queue = new Queue(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() { // in depth
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs() { //in breadth
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0); // Insert at the end of the queue
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true; // Label
                displayVertex(v2); // Inference
                queue.insert(v2);
            }
        }
        for (int i = 0; i < size; i++) // Reset Flags
            vertexList[i].wasVisited = false;
    }


    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    // Homework -----------------------------------------------------------------------------

    public void bfsBig(int start, int end) {
        stackPath = new Stack(MAX_VERTS); // Stack of path nodes
        int lengthPath = 0; // Path length
        int num = 0;
        bfsShort(start, end);
        stackPath.push(start);
        while (!stackPath.isEmpty()) {
            num = stackPath.pop();
            System.out.println(vertexList[num].label);
            lengthPath++;
        }
        System.out.println("Short way length: " + lengthPath);
    }

    public void bfsShort(int start, int end) { //shortest way

        for (int i = 0; i < size; i++) // Reset Flags
            vertexList[i].wasVisited = false;

        while (!queue.isEmpty()) { // Cleaning the queue
            queue.remove();
        }

        if (end != start) {
            vertexList[start].wasVisited = true;
            queue.insert(0); // Insert at the end of the queue
            int v2;
            while (!queue.isEmpty()) {
                int v1 = queue.remove();
                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                    if (vertexList[v2] == vertexList[end]) {
                        stackPath.push(v2);
                        bfsShort(start, v1);
                    }
                    vertexList[v2].wasVisited = true; // Label
                    queue.insert(v2);
                }
            }
        }
    }
}
