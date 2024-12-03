import javax.net.ssl.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.keyStore", "clientcert.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "clientpass");
        System.setProperty("javax.net.ssl.trustStore", "clientTruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "truststorepass");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 8443);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Hello, server!");
        String response = in.readLine();
        System.out.println("Received: " + response);
    }
}
