PART 1 : TLS Client and Server Implementation Using Java Sockets and SSL APIs (60%)

Objective:
    Implement a clinet and server that communicate securely using TLS, focusing on low-level
    Socket and SSL APIs (i.e. avoiding higher-level libraries). The client should authenticate 
    the server using a certificate issued by a self-created certificate authority (CA).

Requirements:
    1. Client:
        - Establish a connection to the server over a secure channel using TLS
        - Verify the server's certificate, which is issued by a you as a trusted certificate authority (CA).
        - Authenticate the server.
        - Send a simple message (e.g. "Hello, Server!") once the connection is established

    2. Server:
        - Create a TLS server socket that listens on a specified port
        - Accept connections from clients and send a simple response (e.g. "Hello, Client!") back
        - Use a certificate signed by you as a trusted CA for authentication.

    3. Certificate Authority (CA):
        - The students should become their own certificate authority by generating a root CA certificate
        and private key
        - Issue a certificate for the server signed by the root CA's private key. This certificate should be
        used by the server for the TLS connection
        - The client must trust the CA and verify the server certificate against it

    4. Certificates:
        - Create a certificate chain that includes the root CA certificate (yourself) and the server certificate
        - Configure the server to present its certificate, and configure the client to validate the server certificate
        against the trusted CA

    5. Additional Notes:
        - No mutual authentication is required. The client only verifies the server's certificate.
        - Provide thorough error handling if certificate validation fails (e.g. invalid certificate, untrusted CA, etc.)

Technologies:
    - Java Sockets (java.net.Socket / java.net.ServerSocket)
    - Java Secure Sockets Extension (JSSE) APIs like SSLContext, SSLSocket, and SSLSocketFactory
    - Java Keytool or openssl to generate certificates

Deliverables:
    1. Java code for the client and server
    2. The process of generating the root CA certificate and issuing the server certificate
    3. A PDF report (500 words limit) that explains the certificate generation and the process of using your
    own CA. Include an explanation of how the client authenticates the server.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Process of Generating the Root CA Certificate and Issuing the Server Certificate
    1. In terminal, move to part_1 directory where server and client scripts are located -> ../CYBR372AS2/part_1

    2. Generate the CA's (CERTIFICATE AUTHORITY) private key and self-signed certificate:
        - First line: first create a private key
        - Second line: make a certificate for the CA using that private key

        openssl genrsa -out ca.key.pem 2048
        openssl req -x509 -new -nodes -key ca.key.pem -sha256 -days 1024 -out ca.crt.pem

    3. Generate the server's private key and certificate signing request (CSR):
        - First line: creating a private for the server
        - Second line: creating a signing request for server

        openssl genrsa -out server.key.pem 2048
        openssl req -new -key server.key.pem -out server.csr

    4. Sign the server's certificate with the CA private key

        openssl x509 -req -in server.csr -CA ca.crt.pem -CAkey ca.key.pem -CAcreateserial -out server.crt.pem -days 500 -sha256

    5. Convert the servers private key and certificate into PKCS 12 format (java key store uses this so has to be in this form to use it)

        openssl pkcs12 -export -inkey server.key.pem -in server.crt.pem -name "server" -out server.p12 -CAfile ca.crt.pem -caname root

    6. Convert the certificates authority 

        openssl x509 -outform der -in ca.crt.pem -out ca.crt.der 

    7. Creating server key store (src and dest keystore) in java key storage format

        keytool -importkeystore -srckeystore server.p12 -srcstoretype PKCS12 -destkeystore server_keystore.jks -deststoretype JKS

    8. Creating client trust store 

        keytool -import -file ca.crt.der -alias ca -keystore ca_truststore.jks

Java Code for the Client and Server
    - java code for serverTLS.java is stored in CYBR372AS2/part_1/serverTLS.java
    - java code for clientTLS.java is stored in CYBR372AS2/part_1/clientTLS.java
    - to switch between TLS 1.2 and TLS 1.3 uncomment/comment lines 26/27 in clientTLS.java and
    uncomment/comment lines 25/26 in serverTLS.java
    - Run serverTLS.java and clientTLS.java
        - Open up two terminals and move to directory where the clientTLS.java and serverTLS.java is stored

        javac serverTLS.java
        java serverTLS.java
        javac clientTLS.java
        java clientTLS.java


