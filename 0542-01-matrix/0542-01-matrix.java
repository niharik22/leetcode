class Solution {

    Set<String> processed = new HashSet<>(); 
     int r;
     int c;
    public boolean isValidCoords(int i, int j){
        return i>=0 && i<r && j>=0 && j<c; 
    }
    
    public int[][] updateMatrix(int[][] mat) {
         r = mat.length;
         c = mat[0].length;
        Deque<int[]> zeros = new ArrayDeque<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(mat[i][j] == 0){
                    zeros.offerLast(new int[]{i,j});
                } else if(mat[i][j] == 1){
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!zeros.isEmpty()){
            int[] zero = zeros.pollFirst();
            int zR = zero[0];
            int zC = zero[1];
            for(int[] dir: dirs){
                int nR = zR+dir[0];
                int nC = zC+dir[1];
                if(isValidCoords(nR,nC) && mat[nR][nC]>1+mat[zR][zC]){
                   mat[nR][nC] = 1+mat[zR][zC];
                   zeros.offerLast(new int[]{nR,nC});
                }
            }
        }
       return mat;     
    }
}