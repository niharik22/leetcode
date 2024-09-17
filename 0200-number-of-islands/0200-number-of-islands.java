class Solution {
    
    int rows = 0;
    int cols = 0;
    
    private boolean validateCoords(int r, int c){
        return r>=0 && r<rows && c>=0 && c<cols;
    }
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        
        rows = grid.length;
        cols = grid[0].length;
        
        if(grid == null || (rows == 0 && cols ==0)){
            return -1;
        }
        
        Queue<int[]> bfsQ = new LinkedList<>();
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    grid[i][j]='0';
                    bfsQ.offer(new int[]{i,j});
                    while(!bfsQ.isEmpty()){
                        int[] p = bfsQ.poll();
                        int r = p[0];
                        int c = p[1];
                        for(int[] dir : directions){
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if(validateCoords(nr,nc) && grid[nr][nc]=='1'){
                            grid[nr][nc]='0';
                            bfsQ.offer(new int[]{nr,nc});
                            }
                        }        
                    }
                }
            }
        }
        return islands;
    }
}