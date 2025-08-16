package part_1;
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class serverTLS {
    public static void main(String[] args) throws Exception {
        
        // Server:
        // - Create a TLS server socket that listens on a specified port
        // - Accept connections from clients and send a simple response (e.g. "Hello, Client!") back.
        // - Use a certificate signed by you as a trusted CA for authentication
        
        int port = 8443; //server port
        
        try{
            //initialize KeyStore -> server-side authentication
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream("server_keystore.jks"), "password".toCharArray());

            //set-up KeyManagerFactory -> server-side authentication
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, "password".toCharArray());

            //initialize SSLContext
            //SSLContext sc = SSLContext.getInstance("TLSv1.2"); //for 1.2 (TLSv1.2)  
            SSLContext sc = SSLContext.getInstance("TLSv1.3"); //for 1.3 (TLSv1.3)
            sc.init(kmf.getKeyManagers(), null, null);

            //SSLServerSocketFactory and SSLServerSocket -> listen for incoming connections 
            SSLServerSocketFactory sssf = sc.getServerSocketFactory();
            SSLServerSocket sss = (SSLServerSocket) sssf.createServerSocket(port);
            System.out.println("Server Listening on Port " + port);

            //SSLSocket connection -> accept incoming connection
            SSLSocket sSocket = (SSLSocket) sss.accept();
            
            //send response -> client read/receive client message
            try(BufferedReader in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sSocket.getOutputStream()))){

                //read/receive client message
                String cMessage = in.readLine();
                System.out.println("Received From Client: " + cMessage);

                //send response -> client
                out.write("Hello, Client!\n");
                out.flush();
            
            }catch(Exception e){ //catch exception is server/client communication couldnt occur
                System.err.println("Error in establishing server and client communication: " + e.getMessage());
                e.printStackTrace();
            }finally{sSocket.close();} //close connection

        }catch(Exception e){ //catch if server could not be established
            System.err.println("Server error: " + e.getMessage());
            if(e instanceof SSLException){ //catch SSL exception if cause of server not being established
                System.err.println("SSL error: Invalid certificate or SSL config.");
            }
            e.printStackTrace();
        }
    }
}
