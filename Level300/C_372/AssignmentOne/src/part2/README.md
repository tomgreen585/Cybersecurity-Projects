# How to run part2

## Compile

- javac src/part2/Util.java src/part2/Part2.java

## Encryption commands (all based on plaintext file name however). -i or --inputfile and -o or --output-file work for both aswell

- java -cp src part2.Part2 enc -p "helloworld" -i plaintext.txt -o encrypted.txt
- java -cp src part2.Part2 enc --pass "helloworld" -i plaintext.txt -o encrypted.txt
- java -cp src part2.Part2 enc --pass "helloworld" -i plaintext.txt

## Decryption commands (all based on encryption file name however). -i or --inputfile and -o or --output-file work for both aswell

- java -cp src part2.Part2 dec -p "helloworld" -i encrypted.txt.enc -o plain.txt
- java -cp src part2.Part2 dec --pass "helloworld" -i encrypted.txt -o plain.txt

## Explanation on why decryption worked without providing the password salt

Decryption worked without providing the password salt due to reading it at the start of decryption in the encryption.enc file header. When encrypting the salt is appended along with the IV to the encryption data, so when decrypting the process will read it and use it. This also means that decryption of the specific encryption.enc file will only occur if the same 'key' (parameter) that was used for encryption is used for decryption, therefore ensuring that decryption can proceed correctly without manually specifying salt (and IV) just like in part1
