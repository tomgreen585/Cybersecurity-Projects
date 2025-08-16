package part_1;
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class clientTLS {
    public static void main(String[] args) throws Exception {
        
        // Client:
        // - Establish a connection to the server over a secure channel using TLS
        // - Verify the server's certificate, which is issued by a you as a trusted certificate authority (CA)
        // - Authenticate the server
        // - Send a simple message (e.g. "Hello, Server!") once the connection has been established.
        
        try{
            //load CA certificate into TrustStore
            KeyStore ks = KeyStore.getInstance("JKS");
            try (FileInputStream trustStoreStream = new FileInputStream("ca_truststore.jks")) {
                ks.load(trustStoreStream, "password".toCharArray());
            }

            //set-up TrustManagerFactory -> verify server certificate
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);

            //initialise SSLContext -> client-side authentication
            //SSLContext sc = SSLContext.getInstance("TLSv1.2"); //for 1.2 (TLSv1.2) 
            SSLContext sc = SSLContext.getInstance("TLSv1.3"); //for 1.3 (TLSv1.3)
            sc.init(null, tmf.getTrustManagers(), null);

            //initialise SSLSocketFactory -> initialise SSLSocket -> establish connection with server
            SSLSocketFactory ssf = sc.getSocketFactory();
            SSLSocket sSocket = (SSLSocket) ssf.createSocket("localhost", 8443);

            //send response -> client read/receive server message
            try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()))){

                //send response -> server
                out.write("Hello, Server!\n");
                out.flush();

                //read/receive server message
                String sMessage = in.readLine();
                System.out.println("Received from server: " + sMessage);

            }catch(IOException e){ //catch exception if server/client communication couldnt occur
                System.err.println("Error during communication: " + e.getMessage());
                e.printStackTrace();
            } finally {sSocket.close();} //close connection

        }catch(Exception e){ //catch if client could not be established
            System.err.println("Client error: " + e.getMessage());
            if(e instanceof SSLHandshakeException){ //SSLHandshakeException if server cert. invalid or untrusted
                System.err.println("SSL handshake failed: Server cert. invalid or untrusted.");
            } else if(e instanceof FileNotFoundException){ //FileNotFoundException if TrustStoreFile not found
                System.err.println("TrustStoreFile not found: ca_truststore.jks must be used");
            } else if(e instanceof SSLException){ //SSLException if problem with SSL config. or cert.
                System.err.println("SSL error: Problem with SSL config. or cert.");
            }
            e.printStackTrace();
        }      
    }
}
