# How to run part1

## INITIALISATION

- javac src/part1/Util.java src/part1/Part1.java

## All cases in handout will work if specified with correct file path and correct name of plaintext, encryption, decryption, iv, and key files

## ENCRYPTION (no mode, no key). --input-file or -i, --output-file or -o works across. Dont need to specify output file

- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt
- java -cp src part1.Part1 enc --input-file plaintext.txt --output-file encrypted.txt
- java -cp src part1.Part1 enc -o encrypted.txt -i plaintext.txt
- java -cp src part1.Part1 enc --output-file encrypted.txt --input-file plaintext.txt
- java -cp src part1.Part1 enc -i plaintext.txt
- java -cp src part1.Part1 enc --input-file plaintext.txt

## ENCRYPTION (mode, key). Based on if you have key from using top methods. --input-file or -i, --output-file or -o still works across. Dont need to specify output file

- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -k key.base64 -m ECB
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -m ECB
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -k key.base64 -m CBC
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -m CBC
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -k key.base64 -m CTR
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -m CTR
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -k key.base64 -m OFB
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -m OFB
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -k key.base64 -m CFB
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -m CFB
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -k key.base64 -m GCM
- java -cp src part1.Part1 enc -i plaintext.txt -o encrypted.txt -m GCM

## DECRYPTION (no mode). --input-file or -i, --output-file or -o still works across. Key and IV are mandatory. Dont need to specify output file. Must use key and iv related to the encrypted file

- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -k key.base64 -iv iv.base64
- java -cp src part1.Part1 dec -i encrypted.enc -k key.base64 -iv iv.base64

## DECRYPTION (mode). --input-file or -i, --output-file or -o still works across. If specified mode for encryption, you have to specify same one for decryption. ECB has no iv for encryption so dont specify. Dont need to specify output file. Must use key and iv related to the encrypted file

- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -m ECB -k key.base64
- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -m CBC -k key.base64 -iv iv.base64
- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -m CTR -k key.base64 -iv iv.base64
- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -m OFB -k key.base64 -iv iv.base64
- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -m CFB -k key.base64 -iv iv.base64
- java -cp src part1.Part1 dec -i encrypted.txt.enc -o decrypted.dec -m GCM -k key.base64 -iv iv.base64
