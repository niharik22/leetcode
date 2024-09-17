class Solution {

    // Function to get the next and previous valid turns for a given wheel
    private char[] getvalidTurns(char w) {
        int i = Character.getNumericValue(w); // Convert char to int
        char nT = (char)(((((i + 1) % 10) + 10) % 10) + '0'); // Calculate next turn
        char pT = (char)(((((i - 1) % 10) + 10) % 10) + '0'); // Calculate previous turn
        return new char[]{nT, pT}; // Return as char array
    }

    public int openLock(String[] deadends, String target) { 
        int turn = 0;
        Set<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends)); 
        Queue<String> pendingCombinations = new LinkedList<>();

        // If the initial combination is a deadend, return -1
        if (visitedCombinations.contains("0000")) {
            return -1;
        }

        pendingCombinations.add("0000");
        visitedCombinations.add("0000");

        while (!pendingCombinations.isEmpty()) {
            int currentLevelNodesCount = pendingCombinations.size();

            for (int i = 0; i < currentLevelNodesCount; i++) {
                String currentCombination = pendingCombinations.poll();

                // If the target combination is found, return the number of turns
                if (currentCombination.equals(target)) {
                    return turn;
                }

                for (int wheel = 0; wheel < 4; wheel++) {
                    StringBuilder newCombination = new StringBuilder(currentCombination);
                    char[] vTurn = getvalidTurns(newCombination.charAt(wheel));

                    // Queueing next combination
                    newCombination.setCharAt(wheel, vTurn[0]);
                    String nextCombination = newCombination.toString();
                    if (!visitedCombinations.contains(nextCombination)) {
                        visitedCombinations.add(nextCombination);
                        pendingCombinations.offer(nextCombination);
                    }

                    // Reset to the original and queueing previous combination
                    newCombination.setCharAt(wheel, vTurn[1]);
                    String prevCombination = newCombination.toString();
                    if (!visitedCombinations.contains(prevCombination)) {
                        visitedCombinations.add(prevCombination);
                        pendingCombinations.offer(prevCombination);
                    }
                }
            }
            turn++;
        }

        // If no solution is found, return -1
        return -1;
    }
}