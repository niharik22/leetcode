class Solution {
    public int compareVersion(String version1, String version2) {

        String[] versionA = version1.split("\\.");
        String[] versionB = version2.split("\\.");

        int maxSize = Integer.max(versionA.length,versionB.length);

        int a=0;
        int b=0;
        for(int i = 0; i< maxSize; i++){
            a = i<versionA.length?Integer.parseInt(versionA[i]):0;
            b = i<versionB.length?Integer.parseInt(versionB[i]):0;
             if(a>b){
               return 1;
            }else if(b>a){
               return -1;
            }
        }

        return 0;
    }
}