import java.util.Arrays;

public class KeyGeneration {
    public static final int[] P10 = new int[]{3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    public static final int[] P8 = new int[]{6, 3, 7, 4, 8, 5, 10, 9};
    public static final int[] LS1 = new int[]{2, 3, 4, 5, 1};
    public static final int[] LS2 = new int[]{3, 4, 5, 1, 2};

    public Key keyGeneration (int[] orgKey) {
        int[] resultP10 = new int[10];
        int[] resultLS1 = new int[10];
        int[] resultLS2 = new int[10];
        int[] k1 = new int[8];
        int[] k2 = new int[8];
        
        
        resultP10 = Permutation.Permute(P10, orgKey); // static function call
        
        resultLS1 = LSHelper(LS1, resultP10);
        resultLS2 = LSHelper(LS2, resultLS1);     
        
        k1 = Permutation.Permute(P8, resultLS1);
        k2 = Permutation.Permute(P8, resultLS2);
     
        Key key = new Key(k1, k2);
        
        return key;
    }
    
    public int[] LSHelper(int[] LSRule, int[] input) {
        int[] LSLeft = Arrays.copyOfRange(input, 0, 5);
        int[] LSRight = Arrays.copyOfRange(input, 5, 10);
        int[] resultLSLeft = Permutation.Permute(LSRule, LSLeft);
        int[] resultLSRight = Permutation.Permute(LSRule, LSRight);
        
        int[] output = new int[10];
        int oindex = 0;
    
        for (int index = 0; index < resultLSLeft.length; index++) {
            output[oindex] = resultLSLeft[index];
            oindex++;
        }
        for (int index = 0; index < resultLSRight.length; index++) {
            output[oindex] = resultLSRight[index];
            oindex++;
        }
    
        return output;
    }
    
    
}
