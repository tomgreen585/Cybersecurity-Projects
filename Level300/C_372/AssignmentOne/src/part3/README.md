# How to run part3

## PLEASE OBSERVE ALLCOMMANDS FILES TO RUN EVERYTHING IN A COPY AND PASTE IN TERMINAL. If you want singluar methods look below

## AWARE: Results of all plaintext_size, cipher_mode, total_time, key_size, enc/dec are already in results.csv in this directory. If you run anything below they will write to the bottom of results.csv. If you want to write to new file change the .csv file name on line 128 of part3/Part3.java

## INITIALISATION

- javac -cp lib/opencsv-5.9.jar src/part3/Util.java src/part3/Part3.java

## TESTING ALL ECB (can copy and paste all in to observe ECB)

- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext1.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext1.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext1.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext2.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext2.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext2.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext3.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext3.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext3.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext4.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext4.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext4.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext5.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext5.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext5.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext6.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext6.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext6.txt -o encrypted.txt -m ECB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m ECB -k key.base64

## Testing all CBC

- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext1.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext1.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext1.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext2.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext2.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext2.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext3.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext3.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext3.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext4.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext4.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext4.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext5.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext5.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext5.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext6.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext6.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext6.txt -o encrypted.txt -m CBC
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CBC -k key.base64 -iv iv.base64

## Testing all CTR

- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext1.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext1.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext1.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext2.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext2.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext2.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext3.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext3.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext3.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext4.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext4.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext4.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext5.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext5.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext5.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext6.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext6.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext6.txt -o encrypted.txt -m CTR
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CTR -k key.base64 -iv iv.base64

## Testing all OFB

- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext1.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext1.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext1.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext2.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext2.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext2.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext3.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext3.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext3.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext4.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext4.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext4.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext5.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext5.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext5.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext6.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext6.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext6.txt -o encrypted.txt -m OFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m OFB -k key.base64 -iv iv.base64

## Testing all CFB

- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext1.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext1.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext1.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext2.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext2.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext2.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext3.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext3.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext3.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext4.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext4.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext4.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext5.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext5.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext5.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext6.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext6.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext6.txt -o encrypted.txt -m CFB
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m CFB -k key.base64 -iv iv.base64

## Testing all GCM

- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext1.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext1.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext1.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext2.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext2.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext2.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext3.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext3.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext3.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext4.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext4.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext4.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext5.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext5.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext5.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 enc -i plaintext6.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 128 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 enc -i plaintext6.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 192 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 enc -i plaintext6.txt -o encrypted.txt -m GCM
- java -cp "lib/opencsv-5.9.jar:src" part3.Part3 256 dec -i --input-file encrypted.txt.enc -o decrypted.txt -m GCM -k key.base64 -iv iv.base64
