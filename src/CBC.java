import java.util.Arrays;

public class CBC {
    public int[] CBCEncrypt(int[] iv, int[] pt, int[] key) {
        if (pt.length % 8 != 0) {
            System.out.println("pt format wrong!");
            return null;
        }
        
        int blocknum = pt.length / 8;
        int[] ret = new int[pt.length];

        for (int i = 0; i < blocknum; i++) {
            int[] currPT = utils.getCurrPT(pt, i);
            System.out.println("time " + (i+1) + "PT:" + Arrays.toString(currPT));
            System.out.println("time " + (i+1) + "IV:" + Arrays.toString(iv));
            int[] newPT = utils.XOR(iv, currPT);
            System.out.println("time " + (i+1) + "after IV ⊕ PT:" + Arrays.toString(newPT));
            int[] currCT = SDES.sDES(key, newPT);
            System.out.println("time " + (i+1) + "after Encryption:" + Arrays.toString(currCT) + "\n");
            utils.writeCurrCT(ret, currCT, i);
            iv = currCT; // I think no need to do deep copy here.
        }

        return ret;
    }
}
