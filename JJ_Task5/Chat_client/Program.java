package JavaJunior.JJ_Task5.Chat_client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your pass: ");
            String pass = scanner.nextLine();
            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name, pass);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote Ip: " + remoteIp);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
