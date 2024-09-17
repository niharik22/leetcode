class Solution {

     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> keyStack = new ArrayDeque<>();

        // Start with room 0
        keyStack.offerLast(0);
        visited.add(0);

        while (!keyStack.isEmpty()) {
            int currentRoom = keyStack.pollLast();
            for (int key : rooms.get(currentRoom)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    keyStack.offerLast(key);
                }
            }
        }

        // Check if all rooms have been visited
        return visited.size() == n;
    }
}