import java.util.Arrays;

public class FFunction {
    public static final int[] EP = new int[]{4, 1, 2, 3, 2, 3, 4, 1};
    public static final int[][] S0 = new int[][]{
        {1, 0, 3, 2},
        {3, 2, 1, 0},
        {0, 2, 1, 3},
        {3, 1, 3, 2}
    };
    public static final int[][] S1 = new int[][]{
        {0, 1, 2, 3},
        {2, 0, 1, 3},
        {3, 0, 1, 0},
        {2, 1, 0, 3}
    };
    public static final int[] P4 = new int[]{2, 4, 3, 1};

    // F function:
    // @param: L : the left 4 bits of result after IP;
    // @param: R : the right 4 bits of result after IP;
    // @param: SK : SubKey generated by Key generation.
    //
    // Get expansion permutation, then do XOR operation with subkey
    // Do Sbox opeartion to each left 4 bits and right 4 bits of XOR result
    // Use P4 permutation and XOR operation with L to generate result of F function
    public int[] fFunction(int[] L, int[] R, int[] SK) {
        int[] resultEP = Permutation.Permute(EP, R);

        int[] resultXOR = utils.XOR(resultEP, SK);
        int[] resultXORLeft = Arrays.copyOfRange(resultXOR, 0, 4);
        int[] resultXORRight = Arrays.copyOfRange(resultXOR, 4, 8);

        int[] resultSBox = utils.concat(sBox(S0, resultXORLeft), sBox(S1, resultXORRight));
        // System.out.println("Sbox output" + Arrays.toString(resultSBox));

        int[] resultP4 = Permutation.Permute(P4, resultSBox);

        int[] resultFf = utils.XOR(resultP4, L);
        // System.out.println("F function output" + Arrays.toString(resultFf));
        return resultFf;
    }

    public int[] sBox(int[][] S, int[] input) {
        // binary convert to Decimal to get coordinate of SBoxes
        int[] c2 = new int[]{2, 1}; 

        int row = input[1] * c2[0] + input[2] * c2[1];
        int col = input[0] * c2[0] + input[3] * c2[1];
        // col - row
        int temp = S[col][row]; 

        int[] output = utils.Decimal2Binary(temp);
        return output;
    }

    
}
