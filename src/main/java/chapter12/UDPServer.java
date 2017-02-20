package chapter12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

    private static int PORT = 13;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024],
                            1024);
                    socket.receive(request);

                    System.out.println("request == "
                            + new String(request.getData(), "UTF-8"));

                    byte[] data = "sending data".getBytes("UTF-8");
                    DatagramPacket response = new DatagramPacket(data,
                            data.length, request.getAddress(),
                            request.getPort());
                    socket.send(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

}
