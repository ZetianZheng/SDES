import java.util.Arrays;

public class CTR {
    public static int[] counter = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

    private void counterIncrease() {
        int n = counter.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0 && counter[i] == 1) {
                System.out.println("counter full!");
                break;
            }

            if(counter[i] == 1) {
                counter[i] = 0;
                continue;
            }

            counter[i] = 1;
            break;
        }
    }

    public int[] CTREncrypt(int[] pt, int[] key) {
        if (pt.length % 8 != 0) {
            System.out.println("pt format wrong!");
            return null;
        }

        int blocknum = pt.length / 8;
        int[] ret = new int[pt.length];

        for (int i = 0; i < blocknum; i++) {
            System.out.println("time " + (i+1) + " Counter:" + Arrays.toString(counter));
            int[] currKey = SDES.sDES(key, counter);
            System.out.println("time " + (i+1) + " key after encryption using counter:" + Arrays.toString(currKey));
            int[] currPT = utils.getCurrPT(pt, i);
            System.out.println("time " + (i+1) + " PT:" + Arrays.toString(currPT));
            int[] currCT = utils.XOR(currKey, currPT);
            System.out.println("time " + (i+1) + "after PT ⊕ Encrypt Key:" + Arrays.toString(currCT) + "\n");

            utils.writeCurrCT(ret, currCT, i);
            counterIncrease();
        }

        return ret;
    }

    
    
}
