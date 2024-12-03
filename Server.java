import javax.net.ssl.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.keyStore", "servercert.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "serverpass");
        System.setProperty("javax.net.ssl.trustStore", "serverTruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "truststorepass");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(8443);

        System.out.println("Server started...");
        SSLSocket socket = (SSLSocket) serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String line = in.readLine();
        System.out.println("Received: " + line);
        out.println("Hello, client!");
    }
}
