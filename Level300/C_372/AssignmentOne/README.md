# CYBR372 Assignment One greenthom - 300536064

## References

- ChatGPT
(understanding bug issues across for crypto library and understanding of encryption/decryption methods)
- https: //docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#PBEEx
(used to understand password-based generated encryption and decryption)
- https: //en.wikipedia.org/wiki/PBKDF2
(to understand how to implement key derivation process)
- https: //docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/javax/crypto/SecretKeyFactory.html
(understand SecretKeyFactor object implementation)
- https: //www.tutorialspoint.com/java/lang/system_nanotime.htm
(understand how to implement the time for processes)
- https: //www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
(understand java writing to csv)
- https: //www.baeldung.com/java-encryption-iv
(understand diPerent AES mode types e.g. which require padding and iv)
- https: //stackoverflow.com/questions/14005633/java-generate-all-possible-permutations-of-a-string
(used to understand implementing password generator for brute-force)

## Part One

- Part One: Design choice came from looking at the O’Reilly videos where they seperated encryption and decryption algorithms with user input. The initial FileEncryptor.java class had one method (main) which used args to to encrypt or decrypt. Also did encryption and decryption in one go. In my implementation I seperated encryption and decryption algorithms into their own method. Each encryption and decryption handles all AES mode (GCM, ECB, CBC, CFB, OFB, CTR) depending on their implementation and encryption/decryption preference. In my main method I take user argument based on whether they want to encrypt or decrypt. This then takes them to the respective if loop where user input are assigned to variables to use for encryption or decryption methods. All input examples as per the assignment handout can be used and are given in the README.md of that directory if used with correct java ... Meets the requirement of command lines in part one handout, and successfully encrypts and decrypts across all AES modes, key input, no .enc and .dec provided respectively.
- Please find corresponding code to run part one inside the part one directory (src/part1/). Part1.java is the main class where encryption and decryption take place.
- To run program please observe and use commands that is in the README.md inside of the same directory
- Note: All commands as per the assignment hand-out work as long as the start of the command matches the provided. For encryption:  “java -cp src part1.Part1 enc” and decryption “java -cp src part1.Part1 dec”. All specifications after that can be followed as per the hand-out or what is provided in README.md.
- Please also provide corresponding key used to encrypt plaintext as that is mandatory for encryption. Please also provide iv for decryption also as that is mandatory for decryption, unless file was encrypted in ECB mode.

## Part Two

- Part Two: Design choice came from looking at the password-based key derivation function 2 (PBKDF2). Copied same layout from part one and reworked it to fit password based encryption. This involved using salt instead of key aswell as using iv. Encryptin with password also involved the use of SecretKeyFactory, PBEKeySpec and SecretKey. SecretKeyFactor was implemented with PBKDF2WithHmacSHA256 which was the PBKDF2 type discussed in the password-based key derivation function 2 wiki page. In the wiki page they used PBEKeySpec which involved creating an object (password, salt, iter, keyL). My choice of iteration (1000), was purely based on the fact that it was the default choice that is normally used in basic implementation (even though it is reccommended to use 600,000 as of 2023) and use 128 key length as said in handout. SecretKeySpec is used same as per part 1 but with the user inputted key. Used AES/CBC/PKCS5Padding as said per handout. Encryption involves writing salt and iv to header of file, so we dont have to user input for decryption. This is then read from the header of the .enc when decrypting it, and works when decrypted with the password used for encrypting that .enc file. In the main method, it is similar to part one but it is only taking the arguments of enc/dec (to decide on whether user is encrypting or decrypting) and input file, outputfile, and password. Meets the requirement of successfully encrypting and decrypting with only the password specified in the args provided to program. IV and salt are written to header as per requirement (explanation in README.md in part2 dir).
- Please find corresponding code to run part two inside the part one directory (src/part2/). Part2.java is the main class where encryption and decryption take place.
- To run program please observe and use commands that is in the README.md inside of the same directory.
- Note: All commands as per the assignment hand-out work as long as the start of the command matches the provided. For encryption: “java -cp src part2.Part2 enc” and decryption “java -cp src part2.Part2 dec”. All specifications after that can be followed as per the hand-out or what is in the README.md.
- Please also provide the same password to encrypt the file in order to successfully decrypt the file.

## Part Three

- Part Three: Same as part one Part1.java but encryption and decryption methods are returning a long (time) so we can output how long the encryption and decryption is taking. This is then parsed to a writingToCSV method which writes the results of running different key lengths (128,192,256), modes of operation(cbc, ecb, cfb, ofb, ctr, gcm), plaintext size (100kb-1gb) and whether it is encryption or decryption data. This is written to a results.csv which appends new data to the bottom of the .csv file. Meets requirement as outputs results to result.csv and then made observations in the report.pdf.
- Please find corresponding code to run part three inside the part one directory (src/part3/). Part4.java is the main class where encryption, decryption and csv output take place.
- To run  program please observe and use commands that is in the README.md inside of the same directory
- Note: All commands as per the assignment hand-out work as long as the start of the command matches the provided. For encryption:  “java -cp “lib/opencsv-5.9 jar:src” part3.Part3 BYTE_SIZE enc" and decryption “java-cp “lib/opencsv-5.9.jar:src” part3.Part3 BYTE_SIZE dec”. All specifications after that can be followed as per the hand-out or what is provided in README.md.
- Please also find the results.csv inside of the same directory. If commands are run this will add their outputs to the bottom of the results file. Please also find the report.pdf inside of the directory also.

## Part Four

- Part Four: Same as part two Part2.java but we are brute-forcinng the encryption.enc that is outputted from using the encryption method. Using a createBrutePassword method to place in an array of characters to iterate over (lowercase, num, uppercase) where the pasword is changing each time it is parsed to it, starting from a string of 1-6. This carries out when user specifies command line arguments to "brfc" which in main carries it to the "brfc" if loop where it iterates over the argments to obtain the encryption.enc file to brute-force and the type of bruteforce (0(lowercase), 1(lower,Num), 2(lower, upper)). Then goes into a while loop where it breaks if the decrypted.dec matches the plaintext.txt file. Depending on what type of brute force it parses the number of chars, charArray, currPass to createBrutePassword, where itll then return a string that will be attempted to be decrypted in the decryption method. Outputs to terminal the total time for the encryption.enc file and the actual password (that is used for encrypting the .enc file). Meets the requirement of successfully brute-forcing a encryption.enc file through use of different password variations. Also met requirement of the 0,1,2 to to handle different char password characters. Also estimated time it took to brute-force a ciphertext (calculations in the README.md file in that dir).
- Please find corresponding code to run part four inside the part one directory (src/part4/). Part4.java is the main class where encryption and brute-force take place.
- To run program please observe and use commands that is in the README.md inside of the same directory.
- Note: All commands as per the assignment hand-out work as long as the start of the command matches the provided. For encryption: “java -cp src part4.Part4 enc” and brute-force “java -cp src part4.Part4 file.enc”. All specifications after that can be followed as per the hand-out or what is in the README.md.
• Whatever password that is used to encrypt the encryption file will be used to decrypt the encrypted file without specification if provided the encryption file and password was not greater than 6.
