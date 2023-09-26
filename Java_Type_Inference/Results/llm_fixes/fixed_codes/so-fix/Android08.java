import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class Android08 {

    private static final String TAG = "TAG";

    public static void main(String[] args) {

        try {
            java.net.InetAddress server = Inet4Address.getByName("thehost");
            if (server.isReachable(5000)) {
                System.out.println("Ping!");
            }

            Socket clientsocket = new Socket(server, 8080);
        } catch (UnknownHostException e) {
            System.err.println("Server Not Found");
        } catch (IOException e) {
            System.err.println("Couldn't open socket");
        }
    }
}