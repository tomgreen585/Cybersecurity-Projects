package part3;

import java.io.File;
import java.io.FileWriter;
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
import javax.crypto.spec.GCMParameterSpec;
import com.opencsv.CSVWriter;

public class Part3 {
    private static final Logger LOG = Logger.getLogger(Part3.class.getSimpleName());
    private static final String ALGORITHM = "AES";
    private static final String PATH = "src/part3/";
    
    //encrypts the plaintext file
    public static long encrypt(String inputFile, String outputFile, byte[] key, String cipherString, long totalTime) throws Exception {
        long startTime = System.nanoTime(); //encrypt start time
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(key);
        byte[] initVector = new byte[16];
        IvParameterSpec iv = null;
        GCMParameterSpec gcm = null;
        if(cipherString.contains("GCM")){ //gcm uses iv with GCMParameterSpec
            sr.nextBytes(initVector);
            gcm = new GCMParameterSpec(16 * 8, initVector);
        } else if(!cipherString.contains("ECB")){ //ecb does not use iv
            sr.nextBytes(initVector);
            iv = new IvParameterSpec(initVector); //cbc-cfb-ofb-ctr
        }

        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(cipherString);

        if(cipherString.contains("GCM")){
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, gcm); //gcm uses GCMParameterSpec for init
        } else if(!cipherString.contains("ECB")){ //cbc-cfb-ofb-ctr -> IvParameterSpec
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec); //ecb doesnt use iv for init
        }

        if(!outputFile.endsWith(".enc")){outputFile = outputFile + ".enc";} //if input had no .enc then append it
        try (
            InputStream fin = Files.newInputStream(Path.of(inputFile)); //plaintext
            OutputStream fout = Files.newOutputStream(Path.of(outputFile)); //encrypted.enc
            CipherOutputStream cipherOut = new CipherOutputStream(fout, cipher)) { //write data
            final byte[] bytes = new byte[1024];
            for (int length = fin.read(bytes); length != -1; length = fin.read(bytes)) {
                cipherOut.write(bytes, 0, length);
            }
            
            String encryptKey = Base64.getEncoder().encodeToString(key); //encode key to base64
            FileWriter keyFile = new FileWriter(PATH + "key.base64");
            keyFile.write(encryptKey); //write key to file
            keyFile.close();
            if(!cipherString.contains("ECB")){ //write iv to file if not ecb
                String encryptIvKey = Base64.getEncoder().encodeToString(initVector); //encode iv to base64
                FileWriter ivFile = new FileWriter(PATH + "iv.base64");
                ivFile.write(encryptIvKey); //write iv to ivfile
                ivFile.close();
            }
            
            LOG.log(Level.INFO, "Encryption Complete.");
            long endTime = System.nanoTime(); //encrypt end time
            totalTime = endTime - startTime; //calculate total time
        } catch (IOException e) {
            LOG.log(Level.INFO, "Unable to encrypt", e);
        }
        return totalTime; //return the total time for encryption
    }

    //decrypts the encrypted file
    public static long decrypt(String inputFile, String outputFile, byte[] key, byte[] initVector, String cipherString, long totalTime) throws Exception {
        long startTime = System.nanoTime(); //decrypt start time
        IvParameterSpec iv = null;
        GCMParameterSpec gcm = null;
        if(cipherString.contains("GCM")){ //gcm uses iv with GCMParameterSpec
            gcm = new GCMParameterSpec(16 * 8, initVector);
        }
        else if(!cipherString.contains("ECB")){ //ecb does not use iv
            iv = new IvParameterSpec(initVector); //cbc-cfb-ofb-ctr
        }
        
        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(cipherString);

        if(cipherString.contains("GCM")){
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, gcm); //gcm uses GCMParameterSpec for init
        } else if(!cipherString.contains("ECB")){
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv); //cbc-cfb-ofb-ctr
        } else {
            cipher.init(Cipher.DECRYPT_MODE, skeySpec); //ecb doesnt use iv for init
        }

        if(!outputFile.endsWith(".dec")){outputFile = outputFile + ".dec";} //if input had no .dec then append it
        try (
            InputStream encryptedData = Files.newInputStream(Path.of(inputFile)); //encrypted.enc
            CipherInputStream decryptStream = new CipherInputStream(encryptedData, cipher); //get data
            OutputStream decryptedOut = Files.newOutputStream(Path.of(outputFile))) { //decrypted.dec
            final byte[] bytes = new byte[1024];
            for (int length = decryptStream.read(bytes); length != -1; length = decryptStream.read(bytes)) {
                decryptedOut.write(bytes, 0, length);
            }
            LOG.log(Level.INFO, "Decryption complete.");
            long endTime = System.nanoTime(); //decrypt end time
            totalTime = endTime - startTime; //calculate total time
        } catch (IOException ex) {
            Logger.getLogger(Part3.class.getName()).log(Level.SEVERE, "Unable to decrypt", ex);
        }
        return totalTime; //return the total time for decryption
    }    

    //write results to result.csv
    public static void writingToCSV(String inputFile, String cipherString, long totalTime, int keySize, String encOrDec) throws IOException {
        String timeItTook = Long.toString(totalTime); //convert time to string
        String keySizeString = String.valueOf(keySize); //convert keysize to string
        
        File results = new File(PATH + "results.csv"); 
        boolean fileExists = results.exists(); //check if file exists
        
        File file = new File(inputFile); //get plaintext file
        double answer = file.length() / 1024; //convert to mb
        String realAnswer = String.format("%.2f", answer); //format to 2 decimal places
        String howLarge = realAnswer + " mb"; //convert to string

        try (FileWriter fw = new FileWriter(results, true); //if file exists write to end of it
            CSVWriter cv = new CSVWriter(fw)) { //write to csv
            if (!fileExists) { //if file does not exist write header
                String[] header = {"plaintext_size", "cipher_mode", "total_time", "key_size", "enc/dec\n"};
                cv.writeNext(header); //write header
            }
            String[] fromRun = {howLarge, cipherString, timeItTook, keySizeString, encOrDec};
            cv.writeNext(fromRun); //write data
            
        } catch (IOException e) {System.out.println("cant write to results.csv");}
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3 || args.length > 15) {
            System.out.println("USAGE: Improper usage please refer to README.md");
            System.exit(1);
        }
        for (int t = 0; t < 10; t++){ //run the command provided 10 times
            int keySize = Integer.valueOf(args[0]); //get key size
            String inputFile = null; //plaintext/encrypted
            String outputFile = null; //encrypted/decrypted
            String cipherString = null; //cipher mode
            byte[] key = new byte[keySize / 8]; //calculate key size provided
            byte[] iv = new byte[16];
            long totalTime = 0; //total time for encryption/decryption

            //ENCODING
            if (args[1].equals("enc")){ //if encryption
                String encOrDec = args[1]; //assign enc
                for (int i = 1; i < args.length; i++){ //loop through arguments provided
                    if(args[i].equals("--input-file") || args[i].equals("-i")){ //if match input decl.
                        inputFile = PATH + args[i + 1]; //set input file
                    } else if(args[i].equals("--output-file") || args[i].equals("-o")){ //if match output decl.
                        outputFile = PATH + args[i+1]; //set output file
                    } else if(args[i].equals("-k")){ //if match key decl.
                        String file = PATH + args[i+1].toString(); //get key file
                        String keyContent = new String(Files.readAllBytes(Path.of(file))); //read key file
                        key = Base64.getDecoder().decode(keyContent); //decode key
                    } else if(args[i].equals("-m")){ //if match mode decl.
                        String modeType = args[i+1]; //get mode type
                        if(modeType.equals("ECB") || modeType.equals("CBC")){
                            cipherString = "AES/" + modeType + "/PKCS5PADDING"; //set cipher string
                        } else if(modeType.equals("CFB") || modeType.equals("OFB") || modeType.equals("CTR") || modeType.equals("GCM")){
                            cipherString = "AES/" + modeType + "/NoPadding"; //set cipher string
                        }
                    }
                }
                if(outputFile == null){ //if no specified output file then create one to write too
                    File generatedOutputFile = new File(PATH + "encrypted.enc");
                    outputFile = generatedOutputFile.toString();
                }
                if(cipherString == null){cipherString = "AES/CBC/PKCS5PADDING";} //if not mode specified then CBC default

                totalTime = encrypt(inputFile, outputFile, key, cipherString, totalTime); //encrypt and get total time
                writingToCSV(inputFile, cipherString, totalTime, keySize, encOrDec); //write results.csv
            
            //DECODING
            } else if (args[1].equals("dec")){ //if decryption
                String encOrDec = args[1]; //assign dec
                for(int i = 0; i < args.length; i++){ //loop through arguments provided
                    if(args[i].equals("--input-file") || args[i].equals("-i")){ //if match input decl.
                        inputFile = PATH + args[i+1]; //set input file
                    } else if (args[i].equals("--output-file") || args[i].equals("-o")){ //if match output decl.
                        outputFile = PATH + args[i+1]; //set output file
                    } else if (args[i].equals("-m")){ //if match mode decl.
                        String modeType = args[i+1]; //get mode type
                        if(modeType.equals("ECB") || modeType.equals("CBC")){
                            cipherString = "AES/" + modeType + "/PKCS5PADDING"; //set cipher string
                        } else if(modeType.equals("CFB") || modeType.equals("OFB") 
                        || modeType.equals("CTR") || modeType.equals("GCM")){
                            cipherString = "AES/" + modeType + "/NoPadding"; //set cipher string
                        }
                    } else if (args[i].equals("-k")){ //if match key decl.
                        String file = PATH + args[i+1].toString(); //get key file
                        String keyContent = new String(Files.readAllBytes(Path.of(file))); //read key file
                        key = Base64.getDecoder().decode(keyContent); //decode key
                    } else if (args[i].equals("-iv")){ //if match iv decl.
                        String file = PATH + args[i+1].toString(); //get iv file
                        String keyContent = new String(Files.readAllBytes(Path.of(file))); //read iv file
                        iv = Base64.getDecoder().decode(keyContent); //decode iv
                    }
                }
                if(outputFile == null){ //if no specified output file then create one to write too
                    File generatedOutputFile = new File(PATH + "decrypted.dec");
                    outputFile = generatedOutputFile.toString();
                }
                if(cipherString == null){cipherString = "AES/CBC/PKCS5PADDING";} //if not mode specified then CBC default

                totalTime = decrypt(inputFile, outputFile, key, iv, cipherString, totalTime); //decrypt and get total time
                writingToCSV(inputFile, cipherString, totalTime, keySize, encOrDec);  //write results.csv
            } else {
                System.out.println("Could not successfully encode or decode.");
            }
        }
    }
}