public class ArrayMethods{

   /*
   *PART 1
   */
   public static int rowSum(int[][] ary, int x){
     int ans = 0;
     if(x>=ary.length){
       return ans;
     }
     for(int i=0;i<ary[x].length;i++){
       ans+=ary[x][i];
     }
     return ans;
   }
    //returns the sum of the elements in Row x of ary.
    //When x is past the last row count it as a zero. (NO indexOutOfBounds should ever occur)

   public static int columnSum(int[][] ary, int x){
     int ans = 0;
     for(int i=0;i<ary.length;i++){
       if(x<ary[i].length){
         ans+=ary[i][x];
       }
     }
     return ans;
   }
    //returns the sum of the elements in Column x of ary (careful with rows of different lengths!).
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)

   /*
   *PART 2 - use prior methods where appropriate
   */
   public static int[] allRowSums(int[][] ary){
     int[] ans = new int[ary.length];
     for(int i=0;i<ary.length;i++){
       ans[i]=rowSum(ary,i);
     }
     return ans;
   }
    //returns an array of the row sums for each row of ary.
    //Index i of the return array contains the sum of elements in row i.

    public static int[] allColSums(int[][] ary){
      int m = 0;
      for(int i=0;i<ary.length;i++){
        if(m<ary[i].length){
          m=ary[i].length;
        }
      }
      int[] ans = new int[m];
      for(int i=0;i<m;i++){
        ans[i]=columnSum(ary,i);
      }
      return ans;
    }
    //Returns an array with the column sum of each column of ary.
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)
    //Index i of the return array contains the sum of elements in column i, ignoring any rows that are too short.
    //The length of the returned array should be the length of the LONGEST array in ary.


   /*
   *PART 3 - use prior methods where appropriate
   */
   public static boolean isRowMagic(int[][] ary){
     int[] rs = allRowSums(ary);
     for(int i=1;i<rs.length;i++){
       if(rs[i]!=rs[i-1]){
         return false;
       }
     }
     return true;
   }
     //checks if the array is row-magic (this means that every row has the same row sum).

   public static boolean isColumnMagic(int[][] ary){
     int[] cs = allColSums(ary);
     for(int i=1;i<cs.length;i++){
       if(cs[i]!=cs[i-1]){
         return false;
       }
     }
     return true;
   }
    //checks if the array is column-magic (this means that every column has the same column sum).

}
