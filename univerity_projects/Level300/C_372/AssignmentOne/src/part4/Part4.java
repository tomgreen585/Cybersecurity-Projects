package part4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

public class Part4 {
    private static final Logger LOG = Logger.getLogger(Part4.class.getSimpleName());
    private static final String ALGORITHM = "AES";
    private static final String PATH = "src/part4/";

    //encrypts the plaintext file
    public static void encrypt(String inputFile, String outputFile, String pass) throws Exception {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16]; //salt for password
        sr.nextBytes(salt);
        byte[] iv = new byte[16]; //iv for encryption
        sr.nextBytes(iv);
        
        char[] password = pass.toCharArray(); //password provided to char
        SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); //used PBKDF2 based on wiki
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, 1000, 128); //generate key (password, salt, iteration, 128(default)) - wiki
        SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec); //generate secret key
        IvParameterSpec ivSpec = new IvParameterSpec(iv); //iv for encryption
        SecretKeySpec keySpec = new SecretKeySpec(pbeKey.getEncoded(), ALGORITHM); //secret key for encryption - AES

        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //used cbc padding as defualt
        pbeCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
    
        if (!outputFile.endsWith(".enc")) {outputFile = outputFile + ".enc";} //if input had no .enc then append it
        try (
            InputStream fin = Files.newInputStream(Path.of(inputFile)); //plaintext
            OutputStream fout = Files.newOutputStream(Path.of(outputFile)); //encrypted
            CipherOutputStream cipherOut = new CipherOutputStream(fout, pbeCipher)) { //write data
            fout.write(salt); //write salt to header
            fout.write(iv); //write iv to header
            final byte[] bytes = new byte[1024];
            for (int length = fin.read(bytes); length != -1; length = fin.read(bytes)) {
                cipherOut.write(bytes, 0, length);
            }
            LOG.log(Level.INFO, "Encryption Complete.");
        } catch (IOException e) {
            LOG.log(Level.INFO, "Unable to encrypt", e);
        }
    }
    
    //decrypts the encrypted file
    public static void decrypt(String inputFile, String outputFile, String pass) throws Exception {
        try (InputStream encryptedData = Files.newInputStream(Path.of(inputFile))) { //read encrypted file
            byte[] salt = new byte[16];
            encryptedData.read(salt); //read salt from header
            byte[] iv = new byte[16];
            encryptedData.read(iv); //read iv from header
    
            char[] password = pass.toCharArray(); //password provided to char
            SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); //used PBKDF2 based on wiki
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, 1000, 128); //generate key (password, salt, iteration, 128(default)) - wiki
            SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec); //generate secret key
            IvParameterSpec ivSpec = new IvParameterSpec(iv); //iv for encryption
            SecretKeySpec keySpec = new SecretKeySpec(pbeKey.getEncoded(), ALGORITHM); //secret key for encryption - AES
    
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //used cbc padding as defualt
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec); //decrypt mode
    
            if (!outputFile.endsWith(".txt")) {outputFile = outputFile + ".txt";} //if input had no .dec then append it
            try (
                CipherInputStream decryptStream = new CipherInputStream(encryptedData, cipher); //read encrypted data
                OutputStream decryptedOut = Files.newOutputStream(Path.of(outputFile))) { //write decrypted data
                final byte[] bytes = new byte[1024];
                for (int length = decryptStream.read(bytes); length != -1; length = decryptStream.read(bytes)) {
                    decryptedOut.write(bytes, 0, length);
                }
                LOG.log(Level.INFO, "Decryption complete.");
            } catch (IOException e) {
                Logger.getLogger(Part4.class.getName()).log(Level.SEVERE, "Unable to decrypt", e);
            }
        }
    }
    
    //create brute-force password
    public static String createBrutePassword(int max, String array, String password){
        char[] alpha = array.toCharArray(); //array of to iterate over (0,1,2)
        char[] output = password.toCharArray(); //password being used currently
        int length = output.length; //length of password
        String newPassword = null; //new pass created
        String idx = new String(alpha); //string of array
        int[] digits = new int[length]; //increment digits based on length
        
        if (length <= 6){ //if length is less than 6
            for (int i = 0; i < length; i++) {digits[i] = idx.indexOf(output[i]);} //get index of output
            for (int j = length - 1; j >= 0; --j) { //iterate over length-1 
                digits[j] = (digits[j] + 1) % max; //increment char
                output[j] = alpha[digits[j]]; //set output to new char
                if (digits[j] != 0) { //if digit is not 0
                    newPassword = new String(output); //set new password
                    break; //break out of loop
                }
            }
        
            if (newPassword == null) { //if new password is null (reached z)
                newPassword = new String(output); //set password back
                newPassword = "a" + newPassword; //add a to password to start again
            }
        } else {System.out.println("Could not find password");}
        return newPassword; //return new password
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3 || args.length > 7) { //if arguments are less than 3 or more than 5
            System.out.println("USAGE: Please refer to README.md for appropriate run command");
            System.exit(1);
        }
        
        String inputFile = null; //plaintext/encrypted
        String outputFile = null; //encrypted/decrypted
        String typeOfBrute = null; //type of brute force
        String pass = null; //password
        
        //ENCRYPTION
        if (args[0].equals("enc")){ //if encryption
            LOG.log(Level.INFO, "Encrypting File");
            for(int i = 0; i < args.length; i++){ //loop through arguments provided
                if(args[i].equals("-i") || args[i].equals("--input-file")){ //if match input decl.
                    inputFile = PATH + args[i+1]; //set input file
                } else if (args[i].equals("-o") || args[i].equals("--output-file")){ //if match output decl.
                    outputFile = PATH + args[i+1]; //set output file
                } else if(args[i].equals("--pass") || args[i].equals("-p")){ //if match pas decl.
                    pass = args[i+1]; //set password
                }
            }
            if(outputFile == null){ //if no specified output file then create one to write too
                File o = new File(PATH + "encrypted.enc");
                outputFile = o.toString();
            }
            encrypt(inputFile, outputFile, pass); //encrypt
            System.out.println("ENCRYPTION COMPLETE");
        
        //BRUTE FORCE
        } else if (args[0].endsWith(".enc")){ //if brute force
            LOG.log(Level.INFO, "Brute-forcing enc");
            inputFile = PATH + args[0];
            for(int i = 0; i < args.length; i++){ //loop through arguments provided
                if (args[i].equals("-t")){ //if match type (0,1,2) decl.
                    typeOfBrute = args[i+1]; //set type
                }
            }
            if(outputFile == null){ //if no specified output file then create one to write too
                File o = new File(PATH + "decrypted.txt");
                outputFile = o.toString();
            }

            String password = ""; //empty password
            String plaintext = Files.readString(Path.of(PATH + "plaintext.txt")); //read plaintext
            String decrypted = ""; //empty decrypted to get decrypted.dec text
            long startTime = System.nanoTime(); //start of brute-force

            while (!plaintext.equals(decrypted)){ //while plaintext does not equal decrypted.dec string
                if (typeOfBrute.equals("0")){ //lowercase letters
                    int max = 26; //26 letters
                    String arrayToGo = "abcdefghijklmnopqrstuvwxyz"; //array of lowercase letters
                    pass = createBrutePassword(max, arrayToGo, password); //create brute force password
                    password = pass; //set password as created password
                    decrypt(inputFile, outputFile, pass); //try decrypting
                    try {decrypted = Files.readString(Path.of(outputFile));} //read decrypted file
                    catch (IOException e) {}
                    Thread.sleep(10); //added to stop program from crashing
                } else if (typeOfBrute.equals("1")){ //lowercase letters and numbers
                    int max = 36; //36 letters and numbers
                    String arrayToGo = "abcdefghijklmnopqrstuvwxyz1234567890"; //array of lowercase letters and numbers
                    pass = createBrutePassword(max, arrayToGo, password); //create brute force password
                    password = pass; //set password as created password
                    decrypt(inputFile, outputFile, pass); //try decrypting
                    try {decrypted = Files.readString(Path.of(outputFile));} //read decrypted file
                    catch (IOException e) {}
                    Thread.sleep(10);
                } else if (typeOfBrute.equals("2")){ //lowercase and uppercase letters
                    int max = 52; //52 letters
                    String arrayToGo = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; //array of lowercase and uppercase letters
                    pass = createBrutePassword(max, arrayToGo, password);//create brute force password
                    password = pass; //set password as created password
                    decrypt(inputFile, outputFile, pass); //try decrypting
                    try {decrypted = Files.readString(Path.of(outputFile));} //read decrypted file
                    catch (IOException e) {}
                    Thread.sleep(10);
                }
            }

            long endTime = System.nanoTime(); //end brute force time
            long duration = endTime - startTime; //calculate duration
            String timeItTook = Long.toString(duration); //conver to string
            System.out.println("TOTAL TIME: " + timeItTook + ", to decrypt: " + inputFile); //time it took to brute force for the .enc file
            System.out.println("Decryption Password : " + password); //actual encryption password used

        } else {System.out.println("Could not encrypt or decrypt file");}
    }
}