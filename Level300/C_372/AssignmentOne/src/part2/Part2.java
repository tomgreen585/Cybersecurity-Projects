package part2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.Base64;
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

public class Part2 {
    private static final Logger LOG = Logger.getLogger(Part2.class.getSimpleName());
    private static final String ALGORITHM = "AES";
    private static final String PATH = "src/part2/";

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
    
        System.out.println("Secret Key: " + Base64.getEncoder().encodeToString(keySpec.getEncoded()));
        System.out.println("IV: " + Base64.getEncoder().encodeToString(iv));

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
            encryptedData.read(salt); //read salt in header
            byte[] iv = new byte[16];
            encryptedData.read(iv); //read iv in header
    
            char[] password = pass.toCharArray(); //password provided to char
            SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); //used PBKDF2 based on wiki
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, 1000, 128); //generate key (password, salt, iteration, 128(default)) - wiki
            SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec); //generate secret key
            IvParameterSpec ivSpec = new IvParameterSpec(iv); //iv for encryption
            SecretKeySpec keySpec = new SecretKeySpec(pbeKey.getEncoded(), ALGORITHM); //secret key for encryption - AES
    
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //used cbc padding as defualt
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec); //decrypt mode
    
            if (!outputFile.endsWith(".txt")) {outputFile = outputFile + ".txt";} //if input had no .enc then append it
            try (
                CipherInputStream decryptStream = new CipherInputStream(encryptedData, cipher); //read data
                OutputStream decryptedOut = Files.newOutputStream(Path.of(outputFile))) { //write decrypted data
                final byte[] bytes = new byte[1024];
                for (int length = decryptStream.read(bytes); length != -1; length = decryptStream.read(bytes)) {
                    decryptedOut.write(bytes, 0, length);
                }
                LOG.log(Level.INFO, "Decryption complete.");
            } catch (IOException e) {
                Logger.getLogger(Part2.class.getName()).log(Level.SEVERE, "Unable to decrypt", e);
            }
        }
    }    

    public static void main(String[] args) throws Exception {
        if (args.length < 5) {
            System.out.println("USAGE: Please refer to README.md for appropriate run command");
            System.exit(1);
        }
        
        String inputFile = null; //plaintext/encrypted
        String outputFile = null; //encrypted/decrypted
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
        
        //DECRYPTION
        } else if (args[0].equals("dec")){ //if decryption
            LOG.log(Level.INFO, "Decrypting File");
            for(int i = 0; i < args.length; i++){ //loop through arguments provided
                if(args[i].equals("-i") || args[i].equals("--input-file")){ //if match input decl.
                    inputFile = PATH + args[i+1]; //set input file
                } else if (args[i].equals("-o") || args[i].equals("--output-file")){ //if match output decl.
                    outputFile = PATH + args[i+1]; //set output file
                } else if (args[i].equals("-p") || args[i].equals("--pass")){ //if match pas decl.
                    pass = args[i+1]; //set password
                }
            }
            if(outputFile == null){ //if no specified output file then create one to write too
                File o = new File(PATH + "decrypted.txt");
                outputFile = o.toString();
            }
            decrypt(inputFile, outputFile, pass); //decrypt
        } else {
            System.out.println("Could not encrypt or decrypt file");
        }
    }
}