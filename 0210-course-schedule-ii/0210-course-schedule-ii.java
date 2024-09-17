class Solution {

    private HashSet<Integer> visited;
    private Stack<Integer> stack;
    private HashSet<Integer> onPath; 
    private boolean hasCycle; 
    private List<List<Integer>> adj;

    private void addEdge(int from, int to) {
        adj.get(from).add(to);
    }

    private void dfs(int course) {
        if (onPath.contains(course)) {
            hasCycle = true;
            return;
        }
        if (visited.contains(course)) {
            return;
        }

        onPath.add(course);
        for (int next : adj.get(course)) {
            dfs(next);
            if (hasCycle) {
                return;
            }
        }

        onPath.remove(course);
        visited.add(course);
        stack.push(course);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new HashSet<>();
        onPath = new HashSet<>();
        hasCycle = false;
        adj = new ArrayList<>();
        stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            addEdge(prereq[1], prereq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                dfs(i);
            }
            if (hasCycle) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; !stack.isEmpty(); i++) {
            order[i] = stack.pop();
        }
        return order;
    }
}