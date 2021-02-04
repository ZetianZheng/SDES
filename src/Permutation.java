public class Permutation {
    public static int[] Permute(int[] rule, int[] input) { // this is a static function
        int[] output = new int[rule.length];
        
        for (int i = 0; i < rule.length; i++) {
            int index = rule[i] - 1;
            output[i] = input[index];
        }
        
        return output;
    }
}
