// import java.util.Arrays;

public class SDES {
    public static int[] sDES(int[] orgKey, int[] plainText){
        KeyGeneration kg = new KeyGeneration(); 
        Key key = kg.keyGeneration(orgKey);
        // System.out.println("subkey 1" + Arrays.toString(key.k1));
        // System.out.println("subkey 2" + Arrays.toString(key.k2));
        
        Encryption encrypt = new Encryption();
        int[] cipherText = encrypt.encryption(plainText, key);

        return cipherText;
    }
}
