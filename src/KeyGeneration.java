import java.util.Arrays;

public class KeyGeneration {
    public static final int[] P10 = new int[]{3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    public static final int[] P8 = new int[]{6, 3, 7, 4, 8, 5, 10, 9};
    public static final int[] LS1 = new int[]{2, 3, 4, 5, 1};
    public static final int[] LS2 = new int[]{3, 4, 5, 1, 2};

    public Key keyGeneration (int[] orgKey) {
        int[] resultP10 = Permutation.Permute(P10, orgKey);
        
        int[] resultLS1 = LSHelper(LS1, resultP10);
        int[] resultLS2 = LSHelper(LS2, resultLS1);     
        
        int[] k1 = Permutation.Permute(P8, resultLS1);
        int[] k2 = Permutation.Permute(P8, resultLS2);
     
        Key key = new Key(k1, k2);
        
        return key;
    }
    
    public int[] LSHelper(int[] LSRule, int[] input) {
        int[] LSLeft = Arrays.copyOfRange(input, 0, 5);
        int[] LSRight = Arrays.copyOfRange(input, 5, 10);
        int[] resultLSLeft = Permutation.Permute(LSRule, LSLeft);
        int[] resultLSRight = Permutation.Permute(LSRule, LSRight);
        
        int[] output = utils.concat(resultLSLeft, resultLSRight);
    
        return output;
    }
    
    
}
