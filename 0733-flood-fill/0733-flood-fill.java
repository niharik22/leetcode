class Solution {
    int rows = 0;
    int cols = 0;
    int originalColor = -1;
    Deque<int[]> nextCoords = new ArrayDeque<>();
    HashSet<String> visited = new HashSet<>();

    private boolean isValid(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    private void addCoordinate(int[][] image, int i, int j) {
        String coord = i + " : " + j;
        if (isValid(i, j) && !visited.contains(coord) && image[i][j] == originalColor) {
            visited.add(coord);
            nextCoords.offer(new int[]{i, j});
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        originalColor = image[sr][sc];

        // Early return if the starting color is the same as the new color
        if (originalColor == color) {
            return image;
        }

        visited.add(sr + " : " + sc);
        nextCoords.offer(new int[]{sr, sc});

        while (!nextCoords.isEmpty()) {
            int[] cur = nextCoords.poll();
            image[cur[0]][cur[1]] = color;

            addCoordinate(image, cur[0] + 1, cur[1]);
            addCoordinate(image, cur[0] - 1, cur[1]);
            addCoordinate(image, cur[0], cur[1] + 1);
            addCoordinate(image, cur[0], cur[1] - 1);
        }

        return image;
    }
}
