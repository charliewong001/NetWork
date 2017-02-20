package chapter12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    private static int PORT = 13;

    private static String HOSTNAME = "localhost";

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(0)) {
            socket.setSoTimeout(10000);
            InetAddress address = InetAddress.getByName(HOSTNAME);
            DatagramPacket request = new DatagramPacket(new byte[1], 1, address,
                    PORT);
            request.setData("please give me data".getBytes("UTF-8"));
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);

            socket.send(request);
            socket.receive(response);

            String result = new String(response.getData(), 0,
                    response.getLength(), "UTF-8");

            System.out.println("result = " + result);

            //            CountDownLatch l = new CountDownLatch(1);
            //            l.await();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
