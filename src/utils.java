public class utils {
    public static int[] String2Array(String S) {
        int[] output = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int n = c - '0';
            output[i] = n;
        }

        return output;
    }

    public static String array2String(int[] args) {
        StringBuilder output = new StringBuilder();
        for (int i : args) {
            output.append(i);
        }
        
        return output.toString();
    }

    public static int[] concat(int[] A, int[] B) {
        int index = 0;
        int[] output = new int[A.length + B.length];

        for (int i = 0; i < A.length; i++) {
            output[index] = A[i];
            index++;
        }

        for (int i = 0; i < B.length; i++) {
            output[index] = B[i];
            index++;
        }

        return output;
    }

    public static int[] XOR(int[] row, int[] col) {
        int[] output = new int[row.length];

        for (int i = 0; i < row.length; i++) {
            output[i] = row[i] ^ col[i];
        }

        return output;
    }

    public static int[] Decimal2Binary(int de) {
        String numStr = "";
        
        if (de == 0) {
            numStr = "0";
        }

        while (de > 0) {
            int cur = de % 2;
            numStr = cur + numStr;
            de /= 2;
        }

        if (numStr.length() < 2) {
            int[] result = new int[2];
            result[0] = 0;
            result[1] = Integer.parseInt(numStr);
            return result;
        }

        int[] result = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            int n = c - '0';
            result[i] = n;
        }

        return result;
    }
    // ---------------------- getCurrPT, writeCurrCT: Using for CBC or CTR mode ---------------------------
    public static int[] getCurrPT(int[] pt, int currblock) {
        int[] ret = new int[8];
        for (int i = 0; i < 8; i++) {
            int index = i + currblock * 8;
            ret[i] = pt[index];
        }

        return ret;
    }

    public static void writeCurrCT(int[] ct, int[] currCT, int currblock) {
        for (int i = 0; i < 8; i++) {
            int index = i + currblock * 8;
            ct[index] = currCT[i];
        }
    }
}
