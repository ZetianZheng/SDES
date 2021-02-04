## Getting Started

modify or add a new line in the input.csv with format "Key, PlainText", and run the code
the result of SDES will be saved in the file: output.csv.

## Folder Structure
### encryption implements
- 'App.java': read input.csv, call function SDES.java and write results to output.csv
- 'SDES.java': call functions Key generation and Encryption
- 'Encryption.java': mainly SDES encrypt process, using Feistel structure, do double F function, Switch, initial permutation and final permutation
    - 'FFunction.java': implement f function, include S-box function and do XOR operation to result of F function
### Key generation implements
- 'KeyGeneration': generate subkeys from orginal key.
    - 'Key.java': class Key
### other tools:
- 'utils.java': include some tools: convert between String and array, concat arrays, XOR operation, Decimal to Binary
- 'Permutation.java': do all permutate operation in SDES exclude S-Box operate